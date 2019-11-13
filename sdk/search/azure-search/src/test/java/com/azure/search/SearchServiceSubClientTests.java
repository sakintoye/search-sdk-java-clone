// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.search;

import com.azure.core.http.HttpPipeline;
import org.junit.Assert;
import org.junit.Test;

public class SearchServiceSubClientTests extends SearchServiceTestBase {


    @Test
    public void canGetIndexClientFromSearchClient() {
        SearchServiceClient serviceClient = getSearchService();

        SearchIndexClient indexClient = serviceClient.getIndexClient("hotels");

        // Validate the client was created
        Assert.assertNotNull(indexClient);

        // Validate the client points to the same instance
        Assert.assertEquals(serviceClient.getEndpoint(), indexClient.getEndpoint());
        Assert.assertEquals(serviceClient.getApiVersion(), indexClient.getApiVersion());

        // Validate that the client uses the same HTTP pipeline for authentication, retries, etc
        HttpPipeline servicePipeline = serviceClient.getHttpPipeline();
        HttpPipeline indexPipeline = indexClient.getHttpPipeline();

        Assert.assertEquals(servicePipeline, indexPipeline);

        // Validate that the client uses the specified index
        Assert.assertEquals("hotels", indexClient.getIndexName());
    }

    @Test
    public void canGetIndexAsyncClientFromSearchClient() {
        SearchServiceAsyncClient serviceClient = getAsyncSearchService();

        SearchIndexAsyncClient indexClient = serviceClient.getIndexClient("hotels");

        // Validate the client was created
        Assert.assertNotNull(indexClient);

        // Validate the client points to the same instance
        Assert.assertEquals(serviceClient.getEndpoint(), indexClient.getEndpoint());
        Assert.assertEquals(serviceClient.getApiVersion(), indexClient.getApiVersion());

        // Validate that the client uses the same HTTP pipeline for authentication, retries, etc
        HttpPipeline servicePipeline = serviceClient.getHttpPipeline();
        HttpPipeline indexPipeline = indexClient.getHttpPipeline();

        Assert.assertEquals(servicePipeline, indexPipeline);

        // Validate that the client uses the specified index
        Assert.assertEquals("hotels", indexClient.getIndexName());
    }

    @Test
    public void canGetIndexClientAfterUsingServiceClient() {
        SearchServiceClient serviceClient = getSearchService();
        try {
            // this is expected to fail
            serviceClient.deleteIndex("thisindexdoesnotexist");
        } catch (Exception e) {
            // deleting the index should fail as it does not exist
        }

        // This should not fail
        SearchIndexClient indexClient = serviceClient.getIndexClient("hotels");
        Assert.assertEquals("hotels", indexClient.getIndexName());
    }

    @Test
    public void canGetIndexAsyncClientAfterUsingServiceClient() {
        SearchServiceAsyncClient serviceClient = getAsyncSearchService();
        try {
            // this is expected to fail
            serviceClient.deleteIndex("thisindexdoesnotexist");
        } catch (Exception e) {
            // deleting the index should fail as it does not exist
        }

        // This should not fail
        SearchIndexAsyncClient indexClient = serviceClient.getIndexClient("hotels");
        Assert.assertEquals("hotels", indexClient.getIndexName());
    }

    private SearchServiceClient getSearchService() {
        return new SearchServiceClientBuilder()
            .endpoint("https://test1.search.windows.net")
            .credential(new ApiKeyCredentials("api-key"))
            .buildClient();
    }

    private SearchServiceAsyncClient getAsyncSearchService() {
        return new SearchServiceClientBuilder()
            .endpoint("https://test1.search.windows.net")
            .credential(new ApiKeyCredentials("api-key"))
            .buildAsyncClient();
    }
}