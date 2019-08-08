// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.

package com.azure.search.data.generated.implementation;

import com.azure.core.http.HttpPipeline;
import com.azure.core.implementation.RestProxy;
import com.azure.core.implementation.annotation.ServiceClientBuilder;
import com.azure.search.data.generated.Documents;
import com.azure.search.data.generated.SearchIndexRestClient;

/**
 * A builder for creating a new instance of the SearchIndexRestClient type.
 */
@ServiceClientBuilder(serviceClients = SearchIndexRestClient.class)
public final class SearchIndexRestClientBuilder {
    /*
     * Client Api Version.
     */
    private String apiVersion;

    /**
     * Sets Client Api Version.
     *
     * @param apiVersion the apiVersion value.
     * @return the SearchIndexRestClientBuilder.
     */
    public SearchIndexRestClientBuilder apiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
        return this;
    }

    /*
     * The name of the Azure Search service.
     */
    private String searchServiceName;

    /**
     * Sets The name of the Azure Search service.
     *
     * @param searchServiceName the searchServiceName value.
     * @return the SearchIndexRestClientBuilder.
     */
    public SearchIndexRestClientBuilder searchServiceName(String searchServiceName) {
        this.searchServiceName = searchServiceName;
        return this;
    }

    /*
     * The DNS suffix of the Azure Search service. The default is search.windows.net.
     */
    private String searchDnsSuffix;

    /**
     * Sets The DNS suffix of the Azure Search service. The default is search.windows.net.
     *
     * @param searchDnsSuffix the searchDnsSuffix value.
     * @return the SearchIndexRestClientBuilder.
     */
    public SearchIndexRestClientBuilder searchDnsSuffix(String searchDnsSuffix) {
        this.searchDnsSuffix = searchDnsSuffix;
        return this;
    }

    /*
     * The name of the Azure Search index.
     */
    private String indexName;

    /**
     * Sets The name of the Azure Search index.
     *
     * @param indexName the indexName value.
     * @return the SearchIndexRestClientBuilder.
     */
    public SearchIndexRestClientBuilder indexName(String indexName) {
        this.indexName = indexName;
        return this;
    }

    /*
     * The HTTP pipeline to send requests through
     */
    private HttpPipeline pipeline;

    /**
     * Sets The HTTP pipeline to send requests through.
     *
     * @param pipeline the pipeline value.
     * @return the SearchIndexRestClientBuilder.
     */
    public SearchIndexRestClientBuilder pipeline(HttpPipeline pipeline) {
        this.pipeline = pipeline;
        return this;
    }

    /**
     * Builds an instance of SearchIndexRestClient with the provided parameters.
     *
     * @return an instance of SearchIndexRestClient.
     */
    public SearchIndexRestClient build() {
        if (searchDnsSuffix == null) {
            this.searchDnsSuffix = "search.windows.net";
        }
        if (pipeline == null) {
            this.pipeline = RestProxy.createDefaultPipeline();
        }
        SearchIndexRestClientImpl client = new SearchIndexRestClientImpl(pipeline);
        if (this.apiVersion != null) {
            client.setApiVersion(this.apiVersion);
        }
        if (this.searchServiceName != null) {
            client.setSearchServiceName(this.searchServiceName);
        }
        if (this.searchDnsSuffix != null) {
            client.setSearchDnsSuffix(this.searchDnsSuffix);
        }
        if (this.indexName != null) {
            client.setIndexName(this.indexName);
        }
        return client;
    }
}