// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.search.data;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.PagedResponse;
import com.azure.search.data.common.DocumentResponseConversions;
import com.azure.search.data.common.SearchPagedResponse;
import com.azure.search.data.customization.RangeFacetResult;
import com.azure.search.data.customization.ValueFacetResult;
import com.azure.search.data.generated.models.FacetResult;
import com.azure.search.data.generated.models.IndexAction;
import com.azure.search.data.generated.models.IndexBatch;
import com.azure.search.data.generated.models.QueryType;
import com.azure.search.data.generated.models.SearchParameters;
import com.azure.search.data.generated.models.SearchRequestOptions;
import com.azure.search.data.generated.models.SearchResult;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.azure.search.data.generated.models.QueryType.SIMPLE;
import static com.azure.search.data.generated.models.SearchMode.ALL;

public class SearchSyncTests extends SearchTestBase {

    private SearchIndexClient client;

    @Override
    protected void search(
        String searchText, SearchParameters searchParameters, SearchRequestOptions searchRequestOptions) {
        PagedIterable<SearchResult> results = client.search(searchText, searchParameters, searchRequestOptions);
        results.iterableByPage().iterator().next();
    }

    @Override
    protected void indexDocuments(List<IndexAction> indexActions) {
        client.index(new IndexBatch().actions(indexActions));
    }

    @Override
    protected void initializeClient() {
        client = builderSetup().indexName(INDEX_NAME).buildClient();
    }

    @Override
    protected void setIndexName(String indexName) {
        client.setIndexName(indexName);
    }

    @Override
    public void canSearchDynamicDocuments() {
        PagedIterable<SearchResult> results = client.search("*", new SearchParameters(), new SearchRequestOptions());

        Assert.assertNotNull(results);

        Iterator<PagedResponse<SearchResult>> iterator = results.iterableByPage().iterator();
        List<Map<String, Object>> searchResults = new ArrayList<>();
        while (iterator.hasNext()) {
            SearchPagedResponse result = (SearchPagedResponse) iterator.next();
            Assert.assertNull(result.count());
            Assert.assertNull(result.coverage());
            Assert.assertNull(result.facets());
            Assert.assertNotNull(result.items());

            result.items().forEach(item -> {
                Assert.assertEquals(1, item.score(), 0);
                Assert.assertNull(item.highlights());
                searchResults.add(item.additionalProperties());
            });
        }
        Assert.assertEquals(hotels.size(), searchResults.size());
        Assert.assertTrue(compareResults(searchResults, hotels));
    }

    @Override
    public void canSearchWithSelectedFields() {
        // Ask JUST for the following two fields
        SearchParameters sp = new SearchParameters();
        sp.searchFields(new LinkedList<>(Arrays.asList("HotelName", "Category")));
        sp.select(new LinkedList<>(Arrays.asList("HotelName", "Rating", "Address/City", "Rooms/Type")));

        PagedIterable<SearchResult> results = client.search("fancy luxury secret", sp, new SearchRequestOptions());

        HashMap<String, Object> expectedHotel1 = new HashMap<>();
        expectedHotel1.put("HotelName", "Fancy Stay");
        expectedHotel1.put("Rating", 5);
        expectedHotel1.put("Address", null);
        expectedHotel1.put("Rooms", Arrays.asList());

        // This is the expected document when querying the document later (notice that only two fields are expected)
        HashMap<String, Object> expectedHotel2 = new HashMap<>();
        expectedHotel2.put("HotelName", "Secret Point Motel");
        expectedHotel2.put("Rating", 3);
        HashMap<String, Object> address = new LinkedHashMap<>();
        address.put("City", "New York");
        expectedHotel2.put("Address", address);
        HashMap<String, Object> rooms = new LinkedHashMap<>();
        rooms.put("Type", "Budget Room");
        HashMap<String, Object> rooms2 = new LinkedHashMap<>();
        rooms2.put("Type", "Budget Room");
        expectedHotel2.put("Rooms", Arrays.asList(rooms, rooms2));

        Iterator<PagedResponse<SearchResult>> iterator = results.iterableByPage().iterator();
        PagedResponse<SearchResult> result = iterator.next();
        Assert.assertEquals(2, result.items().size());

        // From the result object, extract the two hotels, clean up (irrelevant fields) and change data structure
        // as a preparation to check equality
        Map<String, Object> hotel1 = extractAndTransformSingleResult(result.items().get(0));
        Map<String, Object> hotel2 = extractAndTransformSingleResult(result.items().get(1));

        Assert.assertEquals(expectedHotel1, hotel1);
        Assert.assertEquals(expectedHotel2, hotel2);
    }

    @Override
    public void canUseTopAndSkipForClientSidePaging() {
        List<String> orderBy = Stream.of("HotelId").collect(Collectors.toList());
        SearchParameters parameters = new SearchParameters().top(3).skip(0).orderBy(orderBy);

        PagedIterable<SearchResult> results = client.search("*", parameters, new SearchRequestOptions());
        assertKeySequenceEqual(results, Arrays.asList("1", "10", "100"));

        parameters = parameters.skip(3);
        results = client.search("*", parameters, new SearchRequestOptions());
        assertKeySequenceEqual(results, Arrays.asList("11", "12", "13"));
    }

    private void assertKeySequenceEqual(PagedIterable<SearchResult> results, List<String> expectedKeys) {
        Assert.assertNotNull(results);

        List<String> actualKeys = results.stream().filter(doc -> doc.additionalProperties().containsKey("HotelId"))
            .map(doc -> (String) doc.additionalProperties().get("HotelId")).collect(Collectors.toList());

        Assert.assertEquals(expectedKeys, actualKeys);
    }

    @Override
    public void searchWithoutOrderBySortsByScore() {
        Iterator<SearchResult> results = client
            .search("*", new SearchParameters().filter("Rating lt 4"), new SearchRequestOptions()).iterator();
        SearchResult firstResult = results.next();
        SearchResult secondResult = results.next();
        Assert.assertTrue(firstResult.score() <= secondResult.score());
    }

    @Override
    public void orderByProgressivelyBreaksTies() {
        List<String> orderByValues = new ArrayList<>();
        orderByValues.add("Rating desc");
        orderByValues.add("LastRenovationDate asc");

        String[] expectedResults = new String[]{"1", "9", "3", "4", "5", "10", "2", "6", "7", "8"};

        Stream<String> results = client
            .search("*", new SearchParameters().orderBy(orderByValues), new SearchRequestOptions()).stream()
            .map(res -> res.additionalProperties().get("HotelId").toString());
        Assert.assertArrayEquals(results.toArray(), expectedResults);
    }

    @Override
    public void canFilter() {
        SearchParameters searchParameters = new SearchParameters()
            .filter("Rating gt 3 and LastRenovationDate gt 2000-01-01T00:00:00Z");
        PagedIterable<SearchResult> results = client.search("*", searchParameters, new SearchRequestOptions());
        Assert.assertNotNull(results);

        List<Map<String, Object>> searchResultsList = getSearchResults(results);
        Assert.assertEquals(2, searchResultsList.size());

        List hotelIds = searchResultsList.stream().map(r -> r.get("HotelId")).collect(Collectors.toList());
        Assert.assertTrue(Arrays.asList("1", "5").containsAll(hotelIds));
    }

    @Override
    public void canSearchWithRangeFacets() {
        PagedIterable<SearchResult> results = client.search("*", getSearchParametersForRangeFacets(), new SearchRequestOptions());
        Assert.assertNotNull(results);

        Iterator<PagedResponse<SearchResult>> iterator = results.iterableByPage().iterator();
        while (iterator.hasNext()) {
            SearchPagedResponse result = (SearchPagedResponse) iterator.next();
            assertContainKeys(result.items());
            Assert.assertNotNull(result.facets());
            List<RangeFacetResult> baseRateFacets = getRangeFacetsForField(result.facets(), "Rooms/BaseRate", 4);
            List<RangeFacetResult> lastRenovationDateFacets = getRangeFacetsForField(result.facets(), "LastRenovationDate", 2);
            assertRangeFacets(baseRateFacets, lastRenovationDateFacets);
        }
    }

    @Override
    public void canSearchWithValueFacets() {
        PagedIterable<SearchResult> results = client.search("*", getSearchParametersForValueFacets(), new SearchRequestOptions());
        Assert.assertNotNull(results);

        Iterator<PagedResponse<SearchResult>> iterator = results.iterableByPage().iterator();
        while (iterator.hasNext()) {
            SearchPagedResponse result = (SearchPagedResponse) iterator.next();
            assertContainKeys(result.items());
            Map<String, List<FacetResult>> facets = result.facets();
            Assert.assertNotNull(facets);

            assertValueFacetsEqual(getValueFacetsForField(facets, "Rating", 2),
                new ArrayList<>(Arrays.asList(new ValueFacetResult(1L, 5),
                    new ValueFacetResult(4L, 4))));

            assertValueFacetsEqual(getValueFacetsForField(facets, "SmokingAllowed", 2),
                new ArrayList<>(Arrays.asList(new ValueFacetResult(4L, false),
                    new ValueFacetResult(2L, true))));

            assertValueFacetsEqual(getValueFacetsForField(facets, "Category", 3),
                new ArrayList<>(Arrays.asList(new ValueFacetResult(5L, "Budget"),
                    new ValueFacetResult(1L, "Boutique"),
                    new ValueFacetResult(1L, "Luxury"))));

            assertValueFacetsEqual(getValueFacetsForField(facets, "LastRenovationDate", 6),
                new ArrayList<>(Arrays.asList(new ValueFacetResult(1L, "1970-01-01T00:00:00Z"),
                    new ValueFacetResult(1L, "1982-01-01T00:00:00Z"),
                    new ValueFacetResult(2L, "1995-01-01T00:00:00Z"),
                    new ValueFacetResult(1L, "1999-01-01T00:00:00Z"),
                    new ValueFacetResult(1L, "2010-01-01T00:00:00Z"),
                    new ValueFacetResult(1L, "2012-01-01T00:00:00Z"))));

            assertValueFacetsEqual(getValueFacetsForField(facets, "Rooms/BaseRate", 4),
                new ArrayList<>(Arrays.asList(new ValueFacetResult(1L, 2.44),
                    new ValueFacetResult(1L, 7.69),
                    new ValueFacetResult(1L, 8.09),
                    new ValueFacetResult(1L, 9.69))));

            assertValueFacetsEqual(getValueFacetsForField(facets, "Tags", 10),
                new ArrayList<>(Arrays.asList(new ValueFacetResult(1L, "24-hour front desk service"),
                    new ValueFacetResult(1L, "air conditioning"),
                    new ValueFacetResult(4L, "budget"),
                    new ValueFacetResult(1L, "coffee in lobby"),
                    new ValueFacetResult(2L, "concierge"),
                    new ValueFacetResult(1L, "motel"),
                    new ValueFacetResult(2L, "pool"),
                    new ValueFacetResult(1L, "restaurant"),
                    new ValueFacetResult(1L, "view"),
                    new ValueFacetResult(4L, "wifi"))));
        }
    }

    @Override
    public void canSearchWithLuceneSyntax() {
        Map<String, Object> expectedResult = new HashMap<>();
        expectedResult.put("HotelName", "Roach Motel");
        expectedResult.put("Rating", 1);

        SearchParameters searchParameters = new SearchParameters().queryType(QueryType.FULL).select(Arrays.asList("HotelName", "Rating"));
        PagedIterable<SearchResult> results = client.search("HotelName:roch~", searchParameters, new SearchRequestOptions());

        Assert.assertNotNull(results);
        List<Map<String, Object>> searchResultsList = getSearchResults(results);
        Assert.assertEquals(1, searchResultsList.size());
        Assert.assertEquals(expectedResult, searchResultsList.get(0));
    }

    @Override
    public void canFilterNonNullableType() throws Exception {
        List<Map<String, Object>> expectedDocsList = prepareDataForNonNullableTest();
        SearchParameters searchParameters = new SearchParameters()
            .filter("IntValue eq 0 or (Bucket/BucketName eq 'B' and Bucket/Count lt 10)");

        PagedIterable<SearchResult> results = client.search("*", searchParameters, new SearchRequestOptions());
        Assert.assertNotNull(results);

        List<Map<String, Object>> searchResultsList = getSearchResults(results);
        Assert.assertEquals(2, searchResultsList.size());

        Assert.assertEquals(expectedDocsList, searchResultsList);
    }

    @Override
    public void canSearchWithSearchModeAll() {
        List<Map<String, Object>> response = getSearchResults(client
            .search("Cheapest hotel", new SearchParameters().queryType(SIMPLE).searchMode(ALL),
                new SearchRequestOptions()));
        Assert.assertEquals(1, response.size());
        Assert.assertEquals("2", response.get(0).get("HotelId"));

    }

    @Override
    public void defaultSearchModeIsAny() {
        List<Map<String, Object>> response = getSearchResults(client.search("Cheapest hotel", new SearchParameters(), new SearchRequestOptions()));
        Assert.assertEquals(7, response.size());
        Assert.assertEquals(
            Arrays.asList("2", "10", "3", "4", "5", "1", "9"),
            response.stream().map(res -> res.get("HotelId").toString()).collect(Collectors.toList()));

    }

    @Override
    public void canGetResultCountInSearch() {
        PagedIterable<SearchResult> results = client.search("*", new SearchParameters().includeTotalResultCount(true), new SearchRequestOptions());
        Assert.assertNotNull(results);
        Iterator<PagedResponse<SearchResult>> resultsIterator = results.iterableByPage().iterator();

        Assert.assertEquals(hotels.size(), ((SearchPagedResponse) resultsIterator.next()).count().intValue());
        Assert.assertFalse(resultsIterator.hasNext());
    }

    @Override
    public void canSearchWithRegex() {
        SearchParameters searchParameters = new SearchParameters()
            .queryType(QueryType.FULL)
            .select(Arrays.asList("HotelName", "Rating"));

        PagedIterable<SearchResult> results = client
            .search("HotelName:/.*oach.*\\/?/", searchParameters, new SearchRequestOptions());
        Assert.assertNotNull(results);

        List<Map<String, Object>> resultsList = getSearchResults(results);

        Map<String, Object> expectedHotel = new HashMap<>();
        expectedHotel.put("HotelName", "Roach Motel");
        expectedHotel.put("Rating", 1);

        Assert.assertEquals(1, resultsList.size());
        Assert.assertEquals(dropUnnecessaryFields(resultsList.get(0)), expectedHotel);
    }

    @Override
    public void canSearchWithEscapedSpecialCharsInRegex() {
        SearchParameters searchParameters = new SearchParameters().queryType(QueryType.FULL);

        PagedIterable<SearchResult> results = client
            .search(
                "\\+\\-\\&\\|\\!\\(\\)\\{\\}\\[\\]\\^\\~\\*\\?\\:", searchParameters,
                new SearchRequestOptions());
        Assert.assertNotNull(results);

        List<Map<String, Object>> resultsList = getSearchResults(results);
        Assert.assertEquals(0, resultsList.size());
    }

    @Override
    public void canSearchWithMinimumCoverage() {
        PagedIterable<SearchResult> results = client
            .search("*", new SearchParameters().minimumCoverage(50.0), new SearchRequestOptions());
        Assert.assertNotNull(results);

        Iterator<PagedResponse<SearchResult>> resultsIterator = results.iterableByPage().iterator();
        Assert.assertEquals(100.0, ((SearchPagedResponse) resultsIterator.next()).coverage(), 0);
    }

    private List<Map<String, Object>> getSearchResults(PagedIterable<SearchResult> results) {
        Iterator<PagedResponse<SearchResult>> iterator = results.iterableByPage().iterator();
        List<Map<String, Object>> searchResults = new ArrayList<>();
        while (iterator.hasNext()) {
            SearchPagedResponse result = (SearchPagedResponse) iterator.next();
            Assert.assertNotNull(result.items());
            result.items().forEach(item -> searchResults.add(dropUnnecessaryFields(item.additionalProperties())));
        }

        return searchResults;
    }

    private Map<String, Object> extractAndTransformSingleResult(SearchResult result) {
        return dropUnnecessaryFields(
            DocumentResponseConversions.convertLinkedHashMapToMap(
                (result.additionalProperties())));
    }
}