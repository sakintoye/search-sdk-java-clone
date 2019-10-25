// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.search;

import com.azure.core.http.netty.NettyAsyncHttpClientBuilder;
import com.azure.core.http.policy.HttpLogDetailLevel;
import com.azure.core.http.policy.HttpLogOptions;
import com.azure.core.http.policy.HttpLoggingPolicy;
import com.azure.core.http.policy.RetryPolicy;
import com.azure.search.common.jsonwrapper.JsonWrapper;
import com.azure.search.common.jsonwrapper.api.JsonApi;
import com.azure.search.common.jsonwrapper.api.Type;
import com.azure.search.common.jsonwrapper.jacksonwrapper.JacksonDeserializer;
import com.azure.search.test.environment.setup.SearchIndexService;
import org.junit.Assert;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchIndexClientTestBase extends SearchServiceTestBase {

    private static final String HOTELS_TESTS_INDEX_DATA_JSON = "HotelsTestsIndexData.json";
    protected static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    private JsonApi jsonApi = JsonWrapper.newInstance(JacksonDeserializer.class);

    protected <T> void uploadDocuments(SearchIndexClient client, List<T> uploadDoc) {
        client.uploadDocuments(uploadDoc);
        waitForIndexing();
    }

    protected <T> void uploadDocuments(SearchIndexAsyncClient client, List<T> uploadDoc) {
        client.uploadDocuments(uploadDoc)
            .block();
        waitForIndexing();
    }

    protected <T> void uploadDocument(SearchIndexClient client, T uploadDoc) {
        List<T> docs = new ArrayList<>();
        docs.add(uploadDoc);

        client.uploadDocuments(docs);
        waitForIndexing();
    }

    protected <T> void uploadDocument(SearchIndexAsyncClient client, T uploadDoc) {
        List<T> docs = new ArrayList<>();
        docs.add(uploadDoc);

        client.uploadDocuments(docs)
            .block();
        waitForIndexing();
    }

    protected List<Map<String, Object>> uploadDocumentsJson(
        SearchIndexAsyncClient client, String dataJson) {
        List<Map<String, Object>> documents =
            jsonApi.readJsonFileToList(dataJson, new Type<List<Map<String, Object>>>() {
            });

        uploadDocuments(client, documents);
        return documents;
    }

    protected List<Map<String, Object>> uploadDocumentsJson(
        SearchIndexClient client, String dataJson) {
        List<Map<String, Object>> documents =
            jsonApi.readJsonFileToList(dataJson, new Type<List<Map<String, Object>>>() {
            });

        uploadDocuments(client, documents);

        return documents;
    }

    protected SearchIndexClientBuilder getClientBuilder(String indexName) {
        if (!interceptorManager.isPlaybackMode()) {
            return new SearchIndexClientBuilder()
                .serviceEndpoint(String.format("https://%s.%s", searchServiceName, searchDnsSuffix))
                .indexName(indexName)
                .httpClient(new NettyAsyncHttpClientBuilder().wiretap(true).build())
                .credential(apiKeyCredentials)
                .addPolicy(interceptorManager.getRecordPolicy())
                .addPolicy(new RetryPolicy())
                .addPolicy(new HttpLoggingPolicy(
                    new HttpLogOptions().setLogLevel(HttpLogDetailLevel.BODY_AND_HEADERS)));
        } else {
            return new SearchIndexClientBuilder()
                .serviceEndpoint(String.format("https://%s.%s", searchServiceName, searchDnsSuffix))
                .indexName(indexName)
                .httpClient(interceptorManager.getPlaybackClient());
        }
    }

    protected void createHotelIndex() {
        if (!interceptorManager.isPlaybackMode()) {
            try {
                //Creating Index:
                searchServiceHotelsIndex = new SearchIndexService(
                    HOTELS_TESTS_INDEX_DATA_JSON,
                    searchServiceName,
                    searchDnsSuffix,
                    apiKeyCredentials.getApiKey());
                searchServiceHotelsIndex.initialize();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void setupIndexFromJsonFile(String jsonFile) {
        if (!interceptorManager.isPlaybackMode()) {
            // In RECORDING mode (only), create a new index:
            SearchIndexService searchIndexService = new SearchIndexService(
                jsonFile,
                searchServiceName,
                searchDnsSuffix,
                apiKeyCredentials.getApiKey());
            try {
                searchIndexService.initialize();
            } catch (IOException e) {
                Assert.fail(e.getMessage());
            }
        }
    }

    protected void waitForIndexing() {
        // Wait 2 secs to allow index request to finish
        if (!interceptorManager.isPlaybackMode()) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void assertException(Runnable exceptionThrower, Class<? extends Exception> expectedExceptionType, String expectedMessage) {
        try {
            exceptionThrower.run();
            Assert.fail();
        } catch (Throwable ex) {
            Assert.assertEquals(expectedExceptionType, ex.getClass());
            Assert.assertTrue(ex.getMessage().contains(expectedMessage));
        }
    }
}