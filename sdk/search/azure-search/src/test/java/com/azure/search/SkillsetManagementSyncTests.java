// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.search;

import com.azure.core.exception.HttpResponseException;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.search.models.AccessCondition;
import com.azure.search.models.DefaultCognitiveServices;
import com.azure.search.models.EntityCategory;
import com.azure.search.models.InputFieldMappingEntry;
import com.azure.search.models.KeyPhraseExtractionSkill;
import com.azure.search.models.KeyPhraseExtractionSkillLanguage;
import com.azure.search.models.OcrSkillLanguage;
import com.azure.search.models.OutputFieldMappingEntry;
import com.azure.search.models.SentimentSkillLanguage;
import com.azure.search.models.Skillset;
import com.azure.search.models.SplitSkillLanguage;
import com.azure.search.models.TextExtractionAlgorithm;
import com.azure.search.models.TextSplitMode;
import com.azure.search.test.AccessConditionBase;
import io.netty.handler.codec.http.HttpResponseStatus;
import org.junit.Assert;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SkillsetManagementSyncTests extends SkillsetManagementTestBase {
    private SearchServiceClient client;

    @Override
    protected void beforeTest() {
        super.beforeTest();
        client = getSearchServiceClientBuilder().buildClient();
    }

    @Override
    public void createSkillsetReturnsCorrectDefinitionImageAnalysisKeyPhrase() {
        Skillset expectedSkillset = createTestSkillsetImageAnalysisKeyPhrase();
        Skillset actualSkillset = client.createSkillset(expectedSkillset);

        assertSkillsetsEqual(expectedSkillset, actualSkillset);
    }

    @Override
    public void createSkillsetReturnsCorrectDefinitionLanguageDetection() {
        Skillset expectedSkillset = createTestSkillsetLanguageDetection();
        Skillset actualSkillset = client.createSkillset(expectedSkillset);

        assertSkillsetsEqual(expectedSkillset, actualSkillset);
    }

    @Override
    public void createSkillsetReturnsCorrectDefinitionMergeText() {
        Skillset expectedSkillset = createTestSkillsetMergeText();
        Skillset actualSkillset = client.createSkillset(expectedSkillset);

        assertSkillsetsEqual(expectedSkillset, actualSkillset);
    }

    @Override
    public void createSkillsetReturnsCorrectDefinitionOcrEntity() {
        Skillset expectedSkillset = createTestSkillsetOcrEntity(null, null);
        Skillset actualSkillset = client.createSkillset(expectedSkillset);
        assertSkillsetsEqual(expectedSkillset, actualSkillset);

        List<EntityCategory> entityCategories = Arrays.asList(
            EntityCategory.LOCATION, EntityCategory.ORGANIZATION, EntityCategory.PERSON);

        expectedSkillset = createTestSkillsetOcrEntity(TextExtractionAlgorithm.PRINTED, entityCategories)
            .setName("testskillset1");
        actualSkillset = client.createSkillset(expectedSkillset);
        assertSkillsetsEqual(expectedSkillset, actualSkillset);
    }

    @Override
    public void createSkillsetReturnsCorrectDefinitionOcrHandwritingSentiment() {
        Skillset expectedSkillset = createTestSkillsetOcrSentiment(OcrSkillLanguage.PT,
            SentimentSkillLanguage.PT_PT, TextExtractionAlgorithm.PRINTED);
        Skillset actualSkillset = client.createSkillset(expectedSkillset);
        assertSkillsetsEqual(expectedSkillset, actualSkillset);

        expectedSkillset = createTestSkillsetOcrSentiment(OcrSkillLanguage.FI,
            SentimentSkillLanguage.FI, TextExtractionAlgorithm.PRINTED).setName("testskillset1");
        actualSkillset = client.createSkillset(expectedSkillset);
        assertSkillsetsEqual(expectedSkillset, actualSkillset);

        expectedSkillset = createTestSkillsetOcrSentiment(OcrSkillLanguage.EN,
            SentimentSkillLanguage.EN, TextExtractionAlgorithm.HANDWRITTEN).setName("testskillset2");
        actualSkillset = client.createSkillset(expectedSkillset);
        assertSkillsetsEqual(expectedSkillset, actualSkillset);
    }

    @Override
    public void createSkillsetReturnsCorrectDefinitionOcrKeyPhrase() {
        Skillset expectedSkillset = createTestSkillsetOcrKeyPhrase(OcrSkillLanguage.EN,
            KeyPhraseExtractionSkillLanguage.EN);
        Skillset actualSkillset = client.createSkillset(expectedSkillset);
        assertSkillsetsEqual(expectedSkillset, actualSkillset);

        expectedSkillset = createTestSkillsetOcrKeyPhrase(OcrSkillLanguage.FR, KeyPhraseExtractionSkillLanguage.FR)
            .setName("testskillset1");
        actualSkillset = client.createSkillset(expectedSkillset);
        assertSkillsetsEqual(expectedSkillset, actualSkillset);

        expectedSkillset = createTestSkillsetOcrKeyPhrase(OcrSkillLanguage.ES, KeyPhraseExtractionSkillLanguage.ES)
            .setName("testskillset2");
        actualSkillset = client.createSkillset(expectedSkillset);
        assertSkillsetsEqual(expectedSkillset, actualSkillset);
    }

    @Override
    public void createSkillsetReturnsCorrectDefinitionOcrShaper() {
        Skillset expectedSkillset = createTestSkillsetOcrShaper();
        Skillset actualSkillset = client.createSkillset(expectedSkillset);

        assertSkillsetsEqual(expectedSkillset, actualSkillset);
    }

    @Override
    public void createSkillsetReturnsCorrectDefinitionOcrSplitText() {
        Skillset expectedSkillset = createTestSkillsetOcrSplitText(OcrSkillLanguage.EN,
            SplitSkillLanguage.EN, TextSplitMode.PAGES);
        Skillset actualSkillset = client.createSkillset(expectedSkillset);
        assertSkillsetsEqual(expectedSkillset, actualSkillset);


        expectedSkillset = createTestSkillsetOcrSplitText(OcrSkillLanguage.FR,
            SplitSkillLanguage.FR, TextSplitMode.PAGES).setName("testskillset1");
        actualSkillset = client.createSkillset(expectedSkillset);
        assertSkillsetsEqual(expectedSkillset, actualSkillset);

        expectedSkillset = createTestSkillsetOcrSplitText(OcrSkillLanguage.FI,
            SplitSkillLanguage.FI, TextSplitMode.SENTENCES).setName("testskillset2");
        actualSkillset = client.createSkillset(expectedSkillset);
        assertSkillsetsEqual(expectedSkillset, actualSkillset);
        client.deleteSkillset(expectedSkillset.getName());

        expectedSkillset = createTestSkillsetOcrSplitText(OcrSkillLanguage.DA,
            SplitSkillLanguage.DA, TextSplitMode.SENTENCES).setName("testskillset3");
        actualSkillset = client.createSkillset(expectedSkillset);
        assertSkillsetsEqual(expectedSkillset, actualSkillset);
    }

    @Override
    public void createSkillsetReturnsCorrectDefinitionWithCognitiveServicesDefault() {
        Skillset expectedSkillset = createSkillsetWithCognitiveServicesKey();

        Skillset actualSkillset = client.createSkillset(expectedSkillset);

        assertSkillsetsEqual(expectedSkillset, actualSkillset);
    }

    @Override
    public void createSkillsetReturnsCorrectDefinitionWithOcrDefaultSettings() {
        Skillset expectedSkillset = createSkillsetWithOcrDefaultSettings(false);
        Skillset actualSkillset = client.createSkillset(expectedSkillset);

        assertSkillsetsEqual(expectedSkillset, actualSkillset);
    }

    @Override
    public void createSkillsetReturnsCorrectDefinitionWithImageAnalysisDefaultSettings() {
        Skillset expectedSkillset = createSkillsetWithImageAnalysisDefaultSettings();
        Skillset actualSkillset = client.createSkillset(expectedSkillset);

        assertSkillsetsEqual(expectedSkillset, actualSkillset);
    }

    @Override
    public void createSkillsetReturnsCorrectDefinitionWithKeyPhraseExtractionDefaultSettings() {
        Skillset expectedSkillset = createSkillsetWithKeyPhraseExtractionDefaultSettings();
        Skillset actualSkillset = client.createSkillset(expectedSkillset);

        assertSkillsetsEqual(expectedSkillset, actualSkillset);
    }

    @Override
    public void createSkillsetReturnsCorrectDefinitionWithMergeDefaultSettings() {
        Skillset expectedSkillset = createSkillsetWithMergeDefaultSettings();
        Skillset actualSkillset = client.createSkillset(expectedSkillset);

        assertSkillsetsEqual(expectedSkillset, actualSkillset);
    }

    @Override
    public void createSkillsetReturnsCorrectDefinitionWithEntityRecognitionDefaultSettings() {
        Skillset expectedSkillset = createSkillsetWithEntityRecognitionDefaultSettings();
        Skillset actualSkillset = client.createSkillset(expectedSkillset);

        assertSkillsetsEqual(expectedSkillset, actualSkillset);
    }

    @Override
    public void getOcrSkillsetReturnsCorrectDefinition() {
        Skillset expected = createSkillsetWithOcrDefaultSettings(false);
        client.createSkillset(expected);

        Skillset actual = client.getSkillset(expected.getName());

        assertSkillsetsEqual(expected, actual);
    }

    @Override
    public void getOcrSkillsetWithShouldDetectOrientationReturnsCorrectDefinition() {
        Skillset expected = createSkillsetWithOcrDefaultSettings(true);

        client.createSkillset(expected);

        Skillset actual = client.getSkillset(expected.getName());

        assertSkillsetsEqual(expected, actual);
    }

    @Override
    public void createSkillsetReturnsCorrectDefinitionWithSentimentDefaultSettings() {
        Skillset expectedSkillset = createSkillsetWithSentimentDefaultSettings();
        Skillset actualSkillset = client.createSkillset(expectedSkillset);

        assertSkillsetsEqual(expectedSkillset, actualSkillset);
    }

    @Override
    public void createSkillsetReturnsCorrectDefinitionWithSplitDefaultSettings() {
        Skillset expectedSkillset = createSkillsetWithSplitDefaultSettings();
        Skillset actualSkillset = client.createSkillset(expectedSkillset);

        assertSkillsetsEqual(expectedSkillset, actualSkillset);
    }

    @Override
    public void createCustomSkillsetReturnsCorrectDefinition() {
        Skillset expected = createSkillsetWithCustomSkills();
        Skillset actual = client.createSkillset(expected);

        assertSkillsetsEqual(expected, actual);
    }

    @Override
    public void getSkillsetThrowsOnNotFound() {
        try {
            String skillsetName = "thisdoesnotexist";
            client.getSkillset(skillsetName);

            Assert.fail("Expected an exception to be thrown");
        } catch (Exception ex) {
            Assert.assertEquals(HttpResponseException.class, ex.getClass());
            Assert.assertEquals(HttpResponseStatus.NOT_FOUND.code(),
                ((HttpResponseException) ex).getResponse().getStatusCode());
        }
    }

    @Override
    public void canCreateAndListSkillsets() {
        Skillset skillset1 = createSkillsetWithCognitiveServicesKey();
        Skillset skillset2 = createSkillsetWithEntityRecognitionDefaultSettings();

        client.createSkillset(skillset1);
        client.createSkillset(skillset2);

        PagedIterable<Skillset> actual = client.listSkillsets();
        List<Skillset> result = actual.stream().collect(Collectors.toList());

        Assert.assertEquals(2, result.size());
        Assert.assertEquals(skillset1.getName(), result.get(0).getName());
        Assert.assertEquals(skillset2.getName(), result.get(1).getName());
    }

    @Override
    public void canListSkillsetsWithSelectedField() {
        Skillset skillset1 = createSkillsetWithCognitiveServicesKey();
        Skillset skillset2 = createSkillsetWithEntityRecognitionDefaultSettings();

        client.createSkillset(skillset1);
        client.createSkillset(skillset2);

        PagedIterable<Skillset> selectedFieldListResponse = client.listSkillsets("name", generateRequestOptions());
        List<Skillset> result = selectedFieldListResponse.stream().collect(Collectors.toList());

        Assert.assertEquals(2, result.size());
        Assert.assertEquals(result.get(0).getName(), skillset1.getName());
        Assert.assertEquals(result.get(1).getName(), skillset2.getName());
    }

    @Override
    public void deleteSkillsetIsIdempotent() {
        Skillset skillset = createSkillsetWithOcrDefaultSettings(false);

        Response<Void> deleteResponse = client.deleteSkillsetWithResponse(skillset.getName(), null,
            null, null);
        Assert.assertEquals(HttpResponseStatus.NOT_FOUND.code(), deleteResponse.getStatusCode());

        client.createSkillset(skillset);

        // Delete the same skillset twice
        deleteResponse = client.deleteSkillsetWithResponse(skillset.getName(), null,
            null, null);
        Assert.assertEquals(HttpResponseStatus.NO_CONTENT.code(), deleteResponse.getStatusCode());

        deleteResponse = client.deleteSkillsetWithResponse(skillset.getName(), null,
            null, null);
        Assert.assertEquals(HttpResponseStatus.NOT_FOUND.code(), deleteResponse.getStatusCode());
    }

    @Override
    public void createOrUpdateCreatesWhenSkillsetDoesNotExist() {
        Skillset skillset = createTestOcrSkillSet(1, TextExtractionAlgorithm.HANDWRITTEN, false);

        Response<Skillset> createOrUpdateResponse = client.createOrUpdateSkillsetWithResponse(skillset,
            new AccessCondition(), generateRequestOptions(), Context.NONE);

        Assert.assertEquals(HttpResponseStatus.CREATED.code(), createOrUpdateResponse.getStatusCode());
    }

    @Override
    public void createOrUpdateUpdatesWhenSkillsetExists() {
        Skillset skillset = createTestOcrSkillSet(1, TextExtractionAlgorithm.HANDWRITTEN, false);

        Response<Skillset> createOrUpdateResponse = client.createOrUpdateSkillsetWithResponse(skillset,
            new AccessCondition(), generateRequestOptions(), Context.NONE);
        Assert.assertEquals(HttpResponseStatus.CREATED.code(), createOrUpdateResponse.getStatusCode());

        skillset = createTestOcrSkillSet(2, TextExtractionAlgorithm.PRINTED, false);
        createOrUpdateResponse = client.createOrUpdateSkillsetWithResponse(skillset, new AccessCondition(),
            generateRequestOptions(), Context.NONE);
        Assert.assertEquals(HttpResponseStatus.OK.code(), createOrUpdateResponse.getStatusCode());
    }

    @Override
    public void existsReturnsFalseForNonExistingSkillset() {
        Assert.assertFalse(client.skillsetExists("nonexistent"));
    }

    @Override
    public void existsReturnsTrueForExistingSkillset() {
        Skillset skillset = createSkillsetWithOcrDefaultSettings(false);

        client.createSkillset(skillset);

        Assert.assertTrue(client.skillsetExists(skillset.getName()));
    }

    @Override
    public void createOrUpdateUpdatesSkills() {
        Skillset skillset = createSkillsetWithOcrDefaultSettings(false);

        Skillset createdSkillset = client.createSkillset(skillset);

        // update skills
        createdSkillset.setSkills(Collections.singletonList(
            new KeyPhraseExtractionSkill()
                .setDefaultLanguageCode(KeyPhraseExtractionSkillLanguage.EN)
                .setName("mykeyphrases")
                .setDescription("Tested Key Phrase skill")
                .setContext(CONTEXT_VALUE)
                .setInputs(Collections.singletonList(
                    new InputFieldMappingEntry()
                        .setName("text")
                        .setSource("/document/mytext")))
                .setOutputs(Collections.singletonList(
                    new OutputFieldMappingEntry()
                        .setName("keyPhrases")
                        .setTargetName("myKeyPhrases")))));

        assertSkillsetsEqual(createdSkillset, client.createOrUpdateSkillset(createdSkillset));
    }

    @Override
    public void createOrUpdateUpdatesCognitiveService() {
        Skillset skillset = createSkillsetWithOcrDefaultSettings(false);

        Skillset createdSkillset = client.createSkillset(skillset);

        // update skills
        createdSkillset.setCognitiveServices(new DefaultCognitiveServices().setDescription("description"));

        assertSkillsetsEqual(createdSkillset, client.createOrUpdateSkillset(createdSkillset));
    }

    @Override
    public void createSkillsetReturnsCorrectDefinitionShaperWithNestedInputs() {
        Skillset expected = createSkillsetWithSharperSkillWithNestedInputs();
        Skillset actual = client.createSkillset(expected);

        assertSkillsetsEqual(expected, actual);
    }

    @Override
    public void createSkillsetThrowsExceptionWithNonShaperSkillWithNestedInputs() {
        Skillset skillset = createSkillsetWithNonSharperSkillWithNestedInputs();

        assertException(
            () -> client.createSkillset(skillset),
            HttpResponseException.class,
            "Skill '#1' is not allowed to have recursively defined inputs");
    }

    @Override
    public void createSkillsetReturnsCorrectDefinitionConditional() {
        Skillset expected = createTestSkillsetConditional();
        Skillset actual = client.createSkillset(expected);

        assertSkillsetsEqual(expected, actual);
    }

    @Override
    public void createOrUpdateSkillsetIfNotExistsFailsOnExistingResource() {
        Skillset skillset = createSkillsetWithOcrDefaultSettings(false);
        Skillset createdResource = client.createOrUpdateSkillset(skillset);
        Skillset mutatedResource = mutateSkillsInSkillset(createdResource);
        Context context = new Context("key", "value");

        try {
            client.createOrUpdateSkillset(mutatedResource, AccessConditionBase.generateIfNotExistsAccessCondition(),
                generateRequestOptions());
            Assert.fail("createOrUpdateSkillset did not throw an expected Exception");
        } catch (Exception ex) {
            Assert.assertEquals(HttpResponseException.class, ex.getClass());
            Assert.assertEquals(HttpResponseStatus.PRECONDITION_FAILED.code(),
                ((HttpResponseException) ex).getResponse().getStatusCode());
        }

        try {
            client.createOrUpdateSkillsetWithResponse(mutatedResource, AccessConditionBase.generateIfNotExistsAccessCondition(),
                generateRequestOptions(), context);
            Assert.fail("createOrUpdateSkillset did not throw an expected Exception");
        } catch (Exception ex) {
            Assert.assertEquals(HttpResponseException.class, ex.getClass());
            Assert.assertEquals(HttpResponseStatus.PRECONDITION_FAILED.code(),
                ((HttpResponseException) ex).getResponse().getStatusCode());
        }
    }

    @Override
    public void createOrUpdateSkillsetIfNotExistsSucceedsOnNoResource() {
        Skillset resource = createSkillsetWithOcrDefaultSettings(false);
        Context context = new Context("key", "value");

        Skillset updatedResource = client.createOrUpdateSkillset(resource, AccessConditionBase.generateIfNotExistsAccessCondition(),
            generateRequestOptions());
        Assert.assertFalse(updatedResource.getETag().isEmpty());

        updatedResource = client.createOrUpdateSkillset(resource.setName("test-skillset1"),
            AccessConditionBase.generateIfNotExistsAccessCondition(), generateRequestOptions());
        Assert.assertFalse(updatedResource.getETag().isEmpty());

        Response<Skillset> updatedResponse =
            client.createOrUpdateSkillsetWithResponse(resource.setName("test-skillset2"),
                AccessConditionBase.generateIfNotExistsAccessCondition(), generateRequestOptions(), context);
        Assert.assertFalse(updatedResponse.getValue().getETag().isEmpty());
    }

    @Override
    public void createOrUpdateSkillsetIfExistsSucceedsOnExistingResource() {
        Skillset skillset = createSkillsetWithOcrDefaultSettings(false);
        Skillset createdResource = client.createOrUpdateSkillset(skillset);
        Skillset mutatedResource = mutateSkillsInSkillset(createdResource);
        Skillset updatedResource = client.createOrUpdateSkillset(mutatedResource, AccessConditionBase.generateIfExistsAccessCondition(),
            generateRequestOptions());

        Assert.assertFalse(updatedResource.getETag().isEmpty());
        Assert.assertNotEquals(createdResource.getETag(), updatedResource.getETag());
    }

    @Override
    public void createOrUpdateSkillsetIfExistsFailsOnNoResource() {
        Skillset resource = createSkillsetWithOcrDefaultSettings(false);

        try {
            client.createOrUpdateSkillset(resource, AccessConditionBase.generateIfExistsAccessCondition(), generateRequestOptions());
            Assert.fail("createOrUpdateSkillset did not throw an expected Exception");
        } catch (Exception ex) {
            Assert.assertEquals(HttpResponseException.class, ex.getClass());
            Assert.assertEquals(HttpResponseStatus.PRECONDITION_FAILED.code(),
                ((HttpResponseException) ex).getResponse().getStatusCode());
        }
        // The resource should never have been created on the server, and thus it should not have an ETag
        Assert.assertNull(resource.getETag());
    }

    @Override
    public void createOrUpdateSkillsetIfNotChangedSucceedsWhenResourceUnchanged() {
        Skillset skillset = createSkillsetWithOcrDefaultSettings(false);
        Skillset createdResource = client.createOrUpdateSkillset(skillset);
        Skillset mutatedResource = mutateSkillsInSkillset(createdResource);
        Skillset updatedResource = client.createOrUpdateSkillset(mutatedResource, AccessConditionBase.generateIfNotChangedAccessCondition(createdResource.getETag()), generateRequestOptions());

        Assert.assertFalse(createdResource.getETag().isEmpty());
        Assert.assertFalse(updatedResource.getETag().isEmpty());
        Assert.assertNotEquals(createdResource.getETag(), updatedResource.getETag());
    }

    @Override
    public void createOrUpdateSkillsetIfNotChangedFailsWhenResourceChanged() {
        Skillset skillset = createSkillsetWithOcrDefaultSettings(false);
        Skillset createdResource = client.createOrUpdateSkillset(skillset);
        Skillset mutatedResource = mutateSkillsInSkillset(createdResource);
        Skillset updatedResource = client.createOrUpdateSkillset(mutatedResource);

        try {
            client.createOrUpdateSkillset(updatedResource, AccessConditionBase.generateIfNotChangedAccessCondition(createdResource.getETag()), generateRequestOptions());
            Assert.fail("createOrUpdateSkillset did not throw an expected Exception");
        } catch (Exception ex) {
            Assert.assertEquals(HttpResponseException.class, ex.getClass());
            Assert.assertEquals(HttpResponseStatus.PRECONDITION_FAILED.code(), ((HttpResponseException) ex).getResponse().getStatusCode());
        }
        Assert.assertFalse(createdResource.getETag().isEmpty());
        Assert.assertFalse(updatedResource.getETag().isEmpty());
        Assert.assertNotEquals(createdResource.getETag(), updatedResource.getETag());
    }

    @Override
    public void deleteSkillsetIfNotChangedWorksOnlyOnCurrentResource() {
        Skillset skillset = createSkillsetWithOcrDefaultSettings(false);
        Skillset staleResource = client.createOrUpdateSkillset(skillset);
        Skillset currentResource = client.createOrUpdateSkillset(staleResource.setDescription("description"));

        try {
            client.deleteSkillset(skillset.getName(), AccessConditionBase.generateIfNotChangedAccessCondition(staleResource.getETag()), generateRequestOptions());
            Assert.fail("deleteSkillset did not throw an expected Exception");
        } catch (Exception ex) {
            Assert.assertEquals(HttpResponseException.class, ex.getClass());
            Assert.assertEquals(HttpResponseStatus.PRECONDITION_FAILED.code(), ((HttpResponseException) ex).getResponse().getStatusCode());
        }

        Response<Void> response = client.deleteSkillsetWithResponse(skillset.getName(),
            AccessConditionBase.generateIfNotChangedAccessCondition(currentResource.getETag()),
            null,
            null);
        Assert.assertEquals(HttpResponseStatus.NO_CONTENT.code(), response.getStatusCode());
    }

    @Override
    public void deleteSkillsetIfExistsWorksOnlyWhenResourceExists() {
        Skillset skillset = createSkillsetWithOcrDefaultSettings(false);
        client.createSkillset(skillset);

        client.deleteSkillset(skillset.getName(), AccessConditionBase.generateIfExistsAccessCondition(), generateRequestOptions());
        try {
            client.deleteSkillset(skillset.getName(), AccessConditionBase.generateIfExistsAccessCondition(), generateRequestOptions());
            Assert.fail("deleteSkillset did not throw an expected Exception");
        } catch (Exception ex) {
            Assert.assertEquals(HttpResponseException.class, ex.getClass());
            Assert.assertEquals(HttpResponseStatus.PRECONDITION_FAILED.code(), ((HttpResponseException) ex).getResponse().getStatusCode());
        }
    }
}
