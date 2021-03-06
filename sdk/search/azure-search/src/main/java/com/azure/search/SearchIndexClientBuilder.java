// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.search;

import com.azure.core.annotation.ServiceClientBuilder;
import com.azure.core.http.HttpClient;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.HttpPipelineBuilder;
import com.azure.core.http.policy.HttpPipelinePolicy;
import com.azure.core.util.logging.ClientLogger;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a fluent builder API to help aid the configuration and instantiation of
 * {@link SearchIndexClient SearchIndexClients} and {@link SearchIndexAsyncClient SearchIndexAsyncClients}.
 * Call {@link #buildClient() buildClient} and {@link #buildAsyncClient() buildAsyncClient} respectively to construct
 * an instance of the desired client.
 *
 * <p>
 * The following information must be provided on this builder:
 *     <ul>
 *         <li>the Azure Cognitive Search service endpoint through {@code .endpoint()}
 *         <li>the index name through {@code .indexName()}
 *         <li>the API key through {@code .credential()}</li>
 *     </ul>
 * </p>
 */
@ServiceClientBuilder(serviceClients = {SearchIndexClient.class, SearchIndexAsyncClient.class})
public class SearchIndexClientBuilder {

    private ApiKeyCredentials apiKeyCredentials;
    private String apiVersion;
    private String endpoint;
    private String indexName;
    private HttpClient httpClient;
    private final List<HttpPipelinePolicy> policies;

    private final ClientLogger logger = new ClientLogger(SearchIndexClientBuilder.class);

    /**
     * Default Constructor
     */
    public SearchIndexClientBuilder() {
        apiVersion = "2019-05-06";
        policies = new ArrayList<>();
        httpClient = HttpClient.createDefault();
    }

    /**
     * Sets the api version to work against
     *
     * @param apiVersion api version
     * @return the updated SearchIndexClientBuilder object
     */
    public SearchIndexClientBuilder apiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
        return this;
    }

    /**
     * Sets the Azure Cognitive Search service endpoint
     *
     * @param endpoint the endpoint URL to the Azure Cognitive Search service
     * @return the updated SearchIndexClientBuilder object
     * @throws IllegalArgumentException on invalid service endpoint
     */
    public SearchIndexClientBuilder endpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    /**
     * Sets the index name
     *
     * @param indexName name of the index
     * @return the updated SearchIndexClientBuilder object
     */
    public SearchIndexClientBuilder indexName(String indexName) {
        this.indexName = indexName;
        return this;
    }

    /**
     * Set the http client (optional). If this is not set, a default httpClient will be created
     *
     * @param httpClient value of httpClient
     * @return the updated SearchIndexClientBuilder object
     */
    public SearchIndexClientBuilder httpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
        return this;
    }

    /**
     * Sets the api key to use for request authentication.
     *
     * @param apiKeyCredentials api key for request authentication
     * @return the updated SearchIndexClientBuilder object
     * @throws IllegalArgumentException when the api key is empty
     * @throws IllegalArgumentException when the api key is empty
     */
    public SearchIndexClientBuilder credential(ApiKeyCredentials apiKeyCredentials) {
        if (apiKeyCredentials == null || StringUtils.isBlank(apiKeyCredentials.getApiKey())) {
            throw logger.logExceptionAsError(new IllegalArgumentException("Empty apiKeyCredentials"));
        }
        this.apiKeyCredentials = apiKeyCredentials;
        return this;
    }

    /**
     * Http Pipeline policy
     *
     * @param policy policy to add to the pipeline
     * @return the updated SearchIndexClientBuilder object
     */
    public SearchIndexClientBuilder addPolicy(HttpPipelinePolicy policy) {
        this.policies.add(policy);
        return this;
    }

    /**
     * @return a {@link SearchIndexClient} created from the configurations in this builder.
     */
    public SearchIndexClient buildClient() {
        return new SearchIndexClient(buildAsyncClient());
    }

    /**
     * @return a {@link SearchIndexAsyncClient} created from the configurations in this builder.
     */
    public SearchIndexAsyncClient buildAsyncClient() {
        if (apiKeyCredentials != null) {
            this.policies.add(new SearchApiKeyPipelinePolicy(apiKeyCredentials));
        }

        HttpPipeline pipeline = new HttpPipelineBuilder()
            .httpClient(httpClient)
            .policies(policies.toArray(new HttpPipelinePolicy[0]))
            .build();

        return new SearchIndexAsyncClient(endpoint, indexName, apiVersion, pipeline);
    }
}
