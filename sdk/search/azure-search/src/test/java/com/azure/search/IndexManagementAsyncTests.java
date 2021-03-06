// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.search;

import com.azure.core.http.rest.PagedFlux;
import com.azure.search.models.AccessCondition;
import com.azure.search.models.AnalyzerName;
import com.azure.search.models.CorsOptions;
import com.azure.search.models.DataType;
import com.azure.search.models.Field;
import com.azure.search.models.Index;
import com.azure.search.models.MagnitudeScoringFunction;
import com.azure.search.models.MagnitudeScoringParameters;
import com.azure.search.models.ScoringFunctionAggregation;
import com.azure.search.models.ScoringFunctionInterpolation;
import com.azure.search.models.ScoringProfile;
import com.azure.search.models.Suggester;
import com.azure.search.models.SynonymMap;
import com.azure.search.test.AccessConditionAsyncTests;
import com.azure.search.test.AccessOptions;
import io.netty.handler.codec.http.HttpResponseStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class IndexManagementAsyncTests extends IndexManagementTestBase {
    private SearchServiceAsyncClient client;

    // commonly used lambda definitions
    private BiFunction<Index, AccessOptions, Mono<Index>> createOrUpdateIndexAsyncFunc =
        (Index index, AccessOptions ac) -> client.createOrUpdateIndex(index);

    private Supplier<Index> newIndexFunc = this::createTestIndex;

    private Function<Index, Index> mutateIndexFunc = this::mutateCorsOptionsInIndex;

    private BiFunction<String, AccessOptions, Mono<Void>> deleteIndexAsyncFunc =
        (String name, AccessOptions ac) -> client.deleteIndex(name);

    @Override
    protected void beforeTest() {
        super.beforeTest();
        client = getSearchServiceClientBuilder().buildAsyncClient();
    }

    @Test
    public void createIndexReturnsCorrectDefinition() {
        Index index = createTestIndex();
        StepVerifier
            .create(client.createIndex(index))
            .assertNext(createdIndex -> assertIndexesEqual(index, createdIndex))
            .verifyComplete();

        StepVerifier
            .create(client.createIndexWithResponse(index.setName("hotel2"), generateRequestOptions()))
            .assertNext(createdIndex -> assertIndexesEqual(index, createdIndex.getValue()))
            .verifyComplete();
    }

    @Test
    public void createIndexReturnsCorrectDefaultValues() {
        Index index = createTestIndex()
            .setCorsOptions(new CorsOptions().setAllowedOrigins("*"))
            .setScoringProfiles(Collections.singletonList(new ScoringProfile()
                .setName("MyProfile")
                .setFunctions(Collections.singletonList(new MagnitudeScoringFunction()
                    .setParameters(new MagnitudeScoringParameters()
                        .setBoostingRangeStart(1)
                        .setBoostingRangeEnd(4))
                    .setFieldName("Rating")
                    .setBoost(2.0))
                )
            ));

        StepVerifier
            .create(client.createIndex(index))
            .assertNext(indexResponse -> {
                ScoringProfile scoringProfile = indexResponse.getScoringProfiles().get(0);
                Assert.assertNull(indexResponse.getCorsOptions().getMaxAgeInSeconds());
                Assert.assertEquals(ScoringFunctionAggregation.SUM, scoringProfile.getFunctionAggregation());
                Assert.assertNotNull(scoringProfile.getFunctions().get(0));
                Assert.assertEquals(ScoringFunctionInterpolation.LINEAR, scoringProfile.getFunctions().get(0).getInterpolation());
            })
            .verifyComplete();
    }

    @Test
    public void createIndexFailsWithUsefulMessageOnUserError() {
        Index index = new Index()
            .setName(HOTEL_INDEX_NAME)
            .setFields(Collections.singletonList(
                new Field()
                    .setName("HotelId")
                    .setType(DataType.EDM_STRING)
                    .setKey(false)
            ));

        assertHttpResponseExceptionAsync(
            client.createIndex(index),
            HttpResponseStatus.BAD_REQUEST,
            String.format("The request is invalid. Details: index : Found 0 key fields in index '%s'. "
                + "Each index must have exactly one key field.", HOTEL_INDEX_NAME));
    }

    @Test
    public void getIndexReturnsCorrectDefinition() {
        Index index = createTestIndex();
        client.createIndex(index).block();

        StepVerifier
            .create(client.getIndex(index.getName()))
            .assertNext(res -> assertIndexesEqual(index, res))
            .verifyComplete();

        StepVerifier
            .create(client.getIndexWithResponse(index.getName(), generateRequestOptions()))
            .assertNext(res -> assertIndexesEqual(index, res.getValue()))
            .verifyComplete();
    }

    @Test
    public void getIndexThrowsOnNotFound() {
        assertHttpResponseExceptionAsync(
            client.getIndex("thisindexdoesnotexist"),
            HttpResponseStatus.NOT_FOUND,
            "No index with the name 'thisindexdoesnotexist' was found in the service"
        );
    }

    @Test
    public void existsReturnsTrueForExistingIndex() {
        Index index = createTestIndex();
        client.createIndex(index).block();

        StepVerifier
            .create(client.indexExists(index.getName()))
            .assertNext(Assert::assertTrue)
            .verifyComplete();

        StepVerifier
            .create(client.indexExistsWithResponse(index.getName(), generateRequestOptions()))
            .assertNext(res -> Assert.assertTrue(res.getValue()))
            .verifyComplete();
    }

    @Test
    public void existsReturnsFalseForNonExistingIndex() {
        StepVerifier
            .create(client.indexExists("invalidindex"))
            .assertNext(Assert::assertFalse)
            .verifyComplete();
    }

    @Test
    public void deleteIndexIfNotChangedWorksOnlyOnCurrentResource() {
        AccessConditionAsyncTests act = new AccessConditionAsyncTests();

        act.deleteIfNotChangedWorksOnlyOnCurrentResourceAsync(
            deleteIndexAsyncFunc,
            newIndexFunc,
            createOrUpdateIndexAsyncFunc,
            mutateIndexFunc,
            HOTEL_INDEX_NAME);
    }

    @Test
    public void deleteIndexIfExistsWorksOnlyWhenResourceExists() {
        AccessConditionAsyncTests act = new AccessConditionAsyncTests();

        act.deleteIfExistsWorksOnlyWhenResourceExistsAsync(
            deleteIndexAsyncFunc,
            createOrUpdateIndexAsyncFunc,
            newIndexFunc,
            HOTEL_INDEX_NAME);
    }

    @Test
    public void deleteIndexIsIdempotent() {
        Index index = new Index()
            .setName(HOTEL_INDEX_NAME)
            .setFields(Collections.singletonList(
                new Field()
                    .setName("HotelId")
                    .setType(DataType.EDM_STRING)
                    .setKey(true)
            ));
        StepVerifier
            .create(client.deleteIndexWithResponse(index.getName(), new AccessCondition(), generateRequestOptions()))
            .assertNext(indexResponse ->
                Assert.assertEquals(HttpResponseStatus.NOT_FOUND.code(), indexResponse.getStatusCode())
            )
            .verifyComplete();

        StepVerifier
            .create(client.createIndexWithResponse(index, generateRequestOptions()))
            .assertNext(indexResponse ->
                Assert.assertEquals(HttpResponseStatus.CREATED.code(), indexResponse.getStatusCode())
            )
            .verifyComplete();

        // Delete the same index twice
        StepVerifier
            .create(client.deleteIndexWithResponse(index.getName(), new AccessCondition(), generateRequestOptions()))
            .assertNext(indexResponse ->
                Assert.assertEquals(HttpResponseStatus.NO_CONTENT.code(), indexResponse.getStatusCode())
            )
            .verifyComplete();

        StepVerifier
            .create(client.deleteIndexWithResponse(index.getName(), new AccessCondition(), generateRequestOptions()))
            .assertNext(indexResponse ->
                Assert.assertEquals(HttpResponseStatus.NOT_FOUND.code(), indexResponse.getStatusCode())
            )
            .verifyComplete();
    }

    @Test
    public void canCreateAndDeleteIndex() {
        Index index = createTestIndex();
        client.createIndex(index).block();
        client.deleteIndex(index.getName()).block();

        StepVerifier
            .create(client.indexExists(index.getName()))
            .assertNext(Assert::assertFalse)
            .verifyComplete();
    }

    @Test
    public void canCreateAndListIndexes() {
        Index index1 = createTestIndex();
        Index index2 = createTestIndex().setName("hotels2");

        client.createIndex(index1).block();
        client.createIndex(index2).block();

        PagedFlux<Index> listResponse = client.listIndexes();

        StepVerifier
            .create(listResponse.collectList())
            .assertNext(result -> {
                Assert.assertEquals(2, result.size());
                Assert.assertEquals(index1.getName(), result.get(0).getName());
                Assert.assertEquals(index2.getName(), result.get(1).getName());
            })
            .verifyComplete();
    }

    @Test
    public void canListIndexesWithSelectedField() {
        Index index1 = createTestIndex();
        Index index2 = createTestIndex().setName("hotels2");

        client.createIndex(index1).block();
        client.createIndex(index2).block();

        PagedFlux<Index> selectedFieldListResponse = client.listIndexes("name", generateRequestOptions());

        StepVerifier
            .create(selectedFieldListResponse.collectList())
            .assertNext(result ->
                result.forEach(res -> {
                    Assert.assertNotNull(res.getName());
                    Assert.assertNull(res.getFields());
                    Assert.assertNull(res.getDefaultScoringProfile());
                    Assert.assertNull(res.getCorsOptions());
                    Assert.assertNull(res.getScoringProfiles());
                    Assert.assertNull(res.getSuggesters());
                    Assert.assertNull(res.getAnalyzers());
                    Assert.assertNull(res.getTokenizers());
                    Assert.assertNull(res.getTokenFilters());
                    Assert.assertNull(res.getCharFilters());
                })
            )
            .verifyComplete();

        StepVerifier
            .create(selectedFieldListResponse.collectList())
            .assertNext(result -> {
                Assert.assertEquals(2, result.size());
                Assert.assertEquals(index1.getName(), result.get(0).getName());
                Assert.assertEquals(index2.getName(), result.get(1).getName());
            })
            .verifyComplete();
    }

    @Test
    public void canAddSynonymFieldProperty() {
        String synonymMapName = "names";
        SynonymMap synonymMap = new SynonymMap().setName(synonymMapName).setSynonyms("hotel,motel");
        client.createSynonymMap(synonymMap).block();

        Index index = new Index()
            .setName(HOTEL_INDEX_NAME)
            .setFields(Arrays.asList(
                new Field()
                    .setName("HotelId")
                    .setType(DataType.EDM_STRING)
                    .setKey(true),
                new Field()
                    .setName("HotelName")
                    .setType(DataType.EDM_STRING)
                    .setSynonymMaps(Collections.singletonList(synonymMapName))
            ));

        StepVerifier
            .create(client.createIndex(index))
            .assertNext(createdIndex -> {
                List<String> actualSynonym = index.getFields().get(1).getSynonymMaps();
                List<String> expectedSynonym = createdIndex.getFields().get(1).getSynonymMaps();
                Assert.assertEquals(actualSynonym, expectedSynonym);
            })
            .verifyComplete();
    }

    @Test
    public void canUpdateSynonymFieldProperty() {
        String synonymMapName = "names";
        SynonymMap synonymMap = new SynonymMap()
            .setName(synonymMapName)
            .setSynonyms("hotel,motel");

        client.createSynonymMap(synonymMap).block();

        // Create an index
        Index index = createTestIndex();
        Field hotelNameField = getFieldByName(index, "HotelName");
        hotelNameField.setSynonymMaps(Collections.singletonList(synonymMapName));
        client.createIndex(index).block();

        // Update an existing index
        Index existingIndex = client.getIndex(index.getName()).block();
        assert existingIndex != null;
        hotelNameField = getFieldByName(existingIndex, "HotelName");
        hotelNameField.setSynonymMaps(Collections.emptyList());

        StepVerifier
            .create(client.createOrUpdateIndexWithResponse(existingIndex,
                true, new AccessCondition(), generateRequestOptions()))
            .assertNext(res  ->
                assertIndexesEqual(existingIndex, res.getValue())
            )
            .verifyComplete();
    }

    public void canUpdateIndexDefinition() {
        Index fullFeaturedIndex = createTestIndex();

        // Start out with no scoring profiles and different CORS options.
        Index initialIndex = createTestIndex();
        initialIndex.setName(fullFeaturedIndex.getName())
            .setScoringProfiles(new ArrayList<>())
            .setDefaultScoringProfile(null)
            .setCorsOptions(initialIndex.getCorsOptions().setAllowedOrigins("*"));

        Index index = client.createIndex(initialIndex).block();
        assert index != null;

        // Now update the index.
        String[] allowedOrigins = fullFeaturedIndex.getCorsOptions()
            .getAllowedOrigins()
            .toArray(new String[0]);
        index.setScoringProfiles(fullFeaturedIndex.getScoringProfiles())
            .setDefaultScoringProfile(fullFeaturedIndex.getDefaultScoringProfile())
            .setCorsOptions(index.getCorsOptions().setAllowedOrigins(allowedOrigins));

        StepVerifier
            .create(client.createOrUpdateIndex(index))
            .assertNext(res -> assertIndexesEqual(fullFeaturedIndex, res))
            .verifyComplete();

        // Modify the fields on an existing index
        Index existingIndex = client.getIndex(fullFeaturedIndex.getName()).block();
        assert existingIndex != null;

        SynonymMap synonymMap = client.createSynonymMap(new SynonymMap()
            .setName("names")
            .setSynonyms("hotel,motel")
        ).block();
        assert synonymMap != null;

        Field tagsField = getFieldByName(existingIndex, "Description_Custom");
        tagsField.setRetrievable(false)
            .setSearchAnalyzer(AnalyzerName.WHITESPACE.toString())
            .setSynonymMaps(Collections.singletonList(synonymMap.getName()));

        Field hotelWebSiteField = new Field()
            .setName("HotelWebsite")
            .setType(DataType.EDM_STRING)
            .setSearchable(Boolean.TRUE)
            .setFilterable(Boolean.TRUE);
        addFieldToIndex(existingIndex, hotelWebSiteField);

        Field hotelNameField = getFieldByName(existingIndex, "HotelName");
        hotelNameField.setRetrievable(false);

        StepVerifier
            .create(client
                .createOrUpdateIndexWithResponse(existingIndex, true, new AccessCondition(), generateRequestOptions()))
            .assertNext(res -> assertIndexesEqual(existingIndex, res.getValue()))
            .verifyComplete();
    }

    @Test
    public void canUpdateSuggesterWithNewIndexFields() {
        Index index = createTestIndex();
        client.createIndex(index).block();

        Index existingIndex = client.getIndex(index.getName()).block();
        assert existingIndex != null;

        existingIndex.getFields().addAll(Arrays.asList(
            new Field()
                .setName("HotelAmenities")
                .setType(DataType.EDM_STRING),
            new Field()
                .setName("HotelRewards")
                .setType(DataType.EDM_STRING)));
        existingIndex.setSuggesters(Collections.singletonList(new Suggester()
            .setName("Suggestion")
            .setSourceFields(Arrays.asList("HotelAmenities", "HotelRewards"))
        ));

        StepVerifier
            .create(client.createOrUpdateIndexWithResponse(existingIndex,
                true, new AccessCondition(), generateRequestOptions()))
            .assertNext(res -> assertIndexesEqual(existingIndex, res.getValue()))
            .verifyComplete();
    }

    @Test
    public void createOrUpdateIndexThrowsWhenUpdatingSuggesterWithExistingIndexFields() {
        Index index = createTestIndex();
        client.createIndex(index).block();

        Index existingIndex = client.getIndex(index.getName()).block();
        assert existingIndex != null;

        String existingFieldName = "Category";
        existingIndex.setSuggesters(Collections.singletonList(new Suggester()
            .setName("Suggestion")
            .setSourceFields(Collections.singletonList(existingFieldName))
        ));

        assertHttpResponseExceptionAsync(
            client.createOrUpdateIndex(existingIndex),
            HttpResponseStatus.BAD_REQUEST,
            String.format("Fields that were already present in an index (%s) cannot be referenced by a new suggester."
                + " Only new fields added in the same index update operation are allowed.", existingFieldName));
    }

    @Test
    public void createOrUpdateIndexCreatesWhenIndexDoesNotExist() {
        Index expected = createTestIndex();

        StepVerifier
            .create(client.createOrUpdateIndex(expected))
            .assertNext(res -> assertIndexesEqual(expected, res))
            .verifyComplete();

        StepVerifier
            .create(client.createOrUpdateIndexWithResponse(expected.setName("hotel1"),
                false, new AccessCondition(), generateRequestOptions()))
            .assertNext(res -> assertIndexesEqual(expected, res.getValue()))
            .verifyComplete();

        StepVerifier
            .create(client.createOrUpdateIndexWithResponse(expected.setName("hotel2"),
                false, new AccessCondition(), generateRequestOptions()))
            .assertNext(res -> Assert.assertEquals(HttpResponseStatus.CREATED.code(), res.getStatusCode()))
            .verifyComplete();
    }

    @Test
    public void createOrUpdateIndexIfNotExistsFailsOnExistingResource() {
        AccessConditionAsyncTests act = new AccessConditionAsyncTests();

        act.createOrUpdateIfNotExistsFailsOnExistingResourceAsync(
            createOrUpdateIndexAsyncFunc,
            newIndexFunc,
            mutateIndexFunc);
    }

    @Test
    public void createOrUpdateIndexIfNotExistsSucceedsOnNoResource() {
        AccessConditionAsyncTests act = new AccessConditionAsyncTests();

        act.createOrUpdateIfNotExistsSucceedsOnNoResourceAsync(
            createOrUpdateIndexAsyncFunc,
            newIndexFunc);
    }

    @Test
    public void createOrUpdateIndexIfExistsSucceedsOnExistingResource() {
        AccessConditionAsyncTests act = new AccessConditionAsyncTests();
        act.updateIfExistsSucceedsOnExistingResourceAsync(
            newIndexFunc,
            createOrUpdateIndexAsyncFunc,
            mutateIndexFunc);
    }

    @Test
    public void createOrUpdateIndexIfExistsFailsOnNoResource() {
        AccessConditionAsyncTests act = new AccessConditionAsyncTests();
        act.updateIfExistsFailsOnNoResourceAsync(
            newIndexFunc,
            createOrUpdateIndexAsyncFunc);
    }

    @Test
    public void createOrUpdateIndexIfNotChangedSucceedsWhenResourceUnchanged() {
        AccessConditionAsyncTests act = new AccessConditionAsyncTests();
        act.updateIfNotChangedSucceedsWhenResourceUnchangedAsync(
            newIndexFunc,
            createOrUpdateIndexAsyncFunc,
            mutateIndexFunc);
    }

    @Test
    public void createOrUpdateIndexIfNotChangedFailsWhenResourceChanged() {
        AccessConditionAsyncTests act = new AccessConditionAsyncTests();
        act.updateIfNotChangedFailsWhenResourceChangedAsync(
            newIndexFunc,
            createOrUpdateIndexAsyncFunc,
            mutateIndexFunc);
    }

    @Test
    public void canCreateAndGetIndexStats() {
        Index testIndex = createTestIndex();
        Index index = client.createOrUpdateIndex(testIndex).block();
        assert index != null;

        StepVerifier
            .create(client.getIndexStatistics(index.getName()))
            .assertNext(stats -> {
                Assert.assertEquals(0, stats.getDocumentCount());
                Assert.assertEquals(0, stats.getStorageSize());
            })
            .verifyComplete();

        StepVerifier
            .create(client.getIndexStatisticsWithResponse(index.getName(), generateRequestOptions()))
            .assertNext(stats -> {
                Assert.assertEquals(0, stats.getValue().getDocumentCount());
                Assert.assertEquals(0, stats.getValue().getStorageSize());
            })
            .verifyComplete();

    }
}
