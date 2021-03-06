// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.search;

import com.azure.core.annotation.ServiceClient;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.PagedIterableBase;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.search.models.AutocompleteItem;
import com.azure.search.models.AutocompleteOptions;
import com.azure.search.models.DocumentIndexResult;
import com.azure.search.models.IndexBatch;
import com.azure.search.models.RequestOptions;
import com.azure.search.models.SearchOptions;
import com.azure.search.models.SearchResult;
import com.azure.search.models.SuggestOptions;
import com.azure.search.models.SuggestResult;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * TODO: Add class description
 */
@ServiceClient(builder = SearchIndexClientBuilder.class)
public class SearchIndexClient {

    private final SearchIndexAsyncClient asyncClient;

    /**
     * Package private constructor to be used by {@link SearchIndexClientBuilder}
     *
     * @param searchIndexAsyncClient Async SearchIndex Client
     */
    SearchIndexClient(SearchIndexAsyncClient searchIndexAsyncClient) {
        this.asyncClient = searchIndexAsyncClient;
    }

    /**
     * Gets the name of the Azure Cognitive Search index.
     *
     * @return the indexName value.
     */
    public String getIndexName() {
        return asyncClient.getIndexName();
    }

    /**
     * Gets the {@link HttpPipeline} powering this client.
     *
     * @return the pipeline.
     */
    HttpPipeline getHttpPipeline() {
        return this.asyncClient.getHttpPipeline();
    }

    /**
     * Uploads a collection of documents to the target index
     *
     * @param documents collection of documents to upload to the target Index.
     * @return document index result.
     */
    public DocumentIndexResult uploadDocuments(Iterable<?> documents) {
        return this.uploadDocumentsWithResponse(documents, Context.NONE).getValue();
    }

    /**
     * Uploads a collection of documents to the target index
     *
     * @param documents collection of documents to upload to the target Index.
     * @param context additional context that is passed through the Http pipeline during the service call
     * @return response containing the document index result.
     */
    public Response<DocumentIndexResult> uploadDocumentsWithResponse(Iterable<?> documents, Context context) {
        return asyncClient.uploadDocumentsWithResponse(documents, context).block();
    }

    /**
     * Merges a collection of documents with existing documents in the target index.
     *
     * @param documents collection of documents to be merged
     * @return document index result
     */
    public DocumentIndexResult mergeDocuments(Iterable<?> documents) {
        return this.mergeDocumentsWithResponse(documents, Context.NONE).getValue();
    }

    /**
     * Merges a collection of documents with existing documents in the target index.
     *
     * @param documents collection of documents to be merged
     * @param context additional context that is passed through the Http pipeline during the service call
     * @return response containing the document index result.
     */
    public Response<DocumentIndexResult> mergeDocumentsWithResponse(Iterable<?> documents, Context context) {
        return asyncClient.mergeDocumentsWithResponse(documents, context).block();
    }

    /**
     * This action behaves like merge if a document with the given key already exists in the index.
     * If the document does not exist, it behaves like upload with a new document.
     *
     * @param documents collection of documents to be merged, if exists, otherwise uploaded
     * @return document index result
     */
    public DocumentIndexResult mergeOrUploadDocuments(Iterable<?> documents) {
        return this.mergeOrUploadDocumentsWithResponse(documents, Context.NONE).getValue();
    }

    /**
     * This action behaves like merge if a document with the given key already exists in the index.
     * If the document does not exist, it behaves like upload with a new document.
     *
     * @param documents collection of documents to be merged, if exists, otherwise uploaded
     * @param context additional context that is passed through the Http pipeline during the service call
     * @return response containing a document index result
     */
    public Response<DocumentIndexResult> mergeOrUploadDocumentsWithResponse(Iterable<?> documents, Context context) {
        return asyncClient.mergeOrUploadDocumentsWithResponse(documents, context).block();
    }

    /**
     * Deletes a collection of documents from the target index
     *
     * @param documents collection of documents to delete from the target Index.
     * @return document index result.
     */
    public DocumentIndexResult deleteDocuments(Iterable<?> documents) {
        return this.deleteDocumentsWithResponse(documents, Context.NONE).getValue();
    }

    /**
     * Deletes a collection of documents from the target index
     *
     * @param documents collection of documents to delete from the target Index.
     * @param context additional context that is passed through the Http pipeline during the service call
     * @return response containing a document index result.
     */
    public Response<DocumentIndexResult> deleteDocumentsWithResponse(Iterable<?> documents, Context context) {
        return asyncClient.deleteDocumentsWithResponse(documents, context).block();
    }

    /**
     * Gets Client Api Version.
     *
     * @return the apiVersion value.
     */
    public String getApiVersion() {
        return asyncClient.getApiVersion();
    }

    /**
     * Gets the endpoint for the Azure Cognitive Search service.
     *
     * @return the endpoint value.
     */
    public String getEndpoint() {
        return this.asyncClient.getEndpoint();
    }

    /**
     * Gets the number of documents
     *
     * @return the number of documents.
     */
    public Long getDocumentCount() {
        return this.getDocumentCountWithResponse(Context.NONE).getValue();
    }

    /**
     * Gets the number of documents
     *
     * @param context additional context that is passed through the Http pipeline during the service call
     * @return response containing the number of documents.
     */
    public Response<Long> getDocumentCountWithResponse(Context context) {
        Mono<Response<Long>> result = asyncClient.getDocumentCountWithResponse(context);
        return result.block();
    }

    /**
     * Searches for documents in the Azure Cognitive Search index
     *
     * @param searchText search text
     * @return A {@link PagedIterable} that iterates over {@link SearchResult} objects
     * and provides access to the {@link SearchPagedResponse} object for each page containing HTTP response and count,
     * facet, and coverage information.
     */
    public PagedIterableBase<SearchResult, SearchPagedResponse> search(String searchText) {
        return new PagedIterableBase<>(asyncClient.search(searchText, null, null));
    }

    /**
     * Searches for documents in the Azure Cognitive Search index
     *
     * @param searchText search text
     * @param searchOptions search options
     * @param requestOptions additional parameters for the operation.
     * Contains the tracking ID sent with the request to help with debugging
     * @param context additional context that is passed through the Http pipeline during the service call
     * @return A {@link PagedIterable} that iterates over {@link SearchResult} objects
     * and provides access to the {@link SearchPagedResponse} object for each page containing HTTP response and count,
     * facet, and coverage information.
     */
    public PagedIterableBase<SearchResult, SearchPagedResponse> search(String searchText,
                                                                       SearchOptions searchOptions,
                                                                       RequestOptions requestOptions,
                                                                       Context context) {
        return new PagedIterableBase<>(asyncClient.search(searchText, searchOptions, requestOptions, context));
    }

    /**
     * Retrieves a document from the Azure Cognitive Search index.
     *
     * @param key the name of the document
     * @return document object
     */
    public Document getDocument(String key) {
        Mono<Document> results = asyncClient.getDocument(key);
        return results.block();
    }

    /**
     * Retrieves a document from the Azure Cognitive Search index.
     *
     * @param key document key
     * @param selectedFields selected fields to return
     * @param requestOptions additional parameters for the operation.
     * Contains the tracking ID sent with the request to help with debugging
     * @return document object
     */
    public Document getDocument(String key,
                                List<String> selectedFields,
                                RequestOptions requestOptions) {
        return this.getDocumentWithResponse(key,
            selectedFields,
            requestOptions,
            Context.NONE).getValue();
    }

    /**
     * Retrieves a document from the Azure Cognitive Search index.
     *
     * @param key document key
     * @param selectedFields selected fields to return
     * @param requestOptions additional parameters for the operation.
     * Contains the tracking ID sent with the request to help with debugging
     * @param context additional context that is passed through the Http pipeline during the service call
     * @return response containing a document object
     */
    public Response<Document> getDocumentWithResponse(String key,
                                                      List<String> selectedFields,
                                                      RequestOptions requestOptions,
                                                      Context context) {
        Mono<Response<Document>> results = asyncClient.getDocumentWithResponse(key,
            selectedFields,
            requestOptions,
            context);
        return results.block();
    }

    /**
     * Suggests documents in the Azure Cognitive Search index that match the given partial query text.
     *
     * @param searchText search text
     * @param suggesterName suggester name
     * @return A {@link PagedIterableBase} that iterates over {@link SuggestResult} objects
     * and provides access to the {@link SuggestPagedResponse} object for each page containing
     * HTTP response and coverage information.
     */
    public PagedIterableBase<SuggestResult, SuggestPagedResponse> suggest(String searchText, String suggesterName) {
        return new PagedIterableBase<>(asyncClient.suggest(searchText,
            suggesterName, null, null));
    }

    /**
     * Suggests documents in the Azure Cognitive Search index that match the given partial query text.
     *
     * @param searchText search text
     * @param suggesterName suggester name
     * @param suggestOptions suggest options
     * @param requestOptions additional parameters for the operation.
     * Contains the tracking ID sent with the request to help with debugging
     * @param context additional context that is passed through the Http pipeline during the service call
     * @return A {@link PagedIterableBase} that iterates over {@link SuggestResult} objects
     * and provides access to the {@link SuggestPagedResponse} object for each page containing
     * HTTP response and coverage information.
     */
    public PagedIterableBase<SuggestResult, SuggestPagedResponse> suggest(String searchText,
                                                                          String suggesterName,
                                                                          SuggestOptions suggestOptions,
                                                                          RequestOptions requestOptions,
                                                                          Context context) {
        return new PagedIterableBase<>(asyncClient.suggest(searchText,
            suggesterName, suggestOptions, requestOptions, context));
    }

    /**
     * Sends a batch of document write to the Azure Cognitive Search index.
     *
     * @param batch batch of documents to send to the index with the requested action
     * @return document index result
     */
    public DocumentIndexResult index(IndexBatch<?> batch) {
        return this.indexWithResponse(batch, Context.NONE).getValue();
    }

    /**
     * Sends a batch of document write to the Azure Cognitive Search index.
     *
     * @param batch batch of documents to send to the index with the requested action
     * @param context additional context that is passed through the Http pipeline during the service call
     * @return a response containing a document index result
     */
    public Response<DocumentIndexResult> indexWithResponse(IndexBatch<?> batch, Context context) {
        Mono<Response<DocumentIndexResult>> results = asyncClient.indexWithResponse(batch, context);
        return results.block();
    }

    /**
     * Autocompletes incomplete query terms based on input text and matching terms in the Azure Cognitive Search index.
     *
     * @param searchText search text
     * @param suggesterName suggester name
     * @return auto complete result.
     */
    public PagedIterable<AutocompleteItem> autocomplete(String searchText, String suggesterName) {
        return new PagedIterable<>(asyncClient.autocomplete(searchText, suggesterName));
    }

    /**
     * Autocompletes incomplete query terms based on input text and matching terms in the Azure Cognitive Search index.
     *
     * @param searchText search text
     * @param suggesterName suggester name
     * @param autocompleteOptions autocomplete options
     * @param requestOptions additional parameters for the operation.
     * Contains the tracking ID sent with the request to help with debugging
     * @param context additional context that is passed through the HTTP pipeline during the service call
     * @return auto complete result.
     */
    public PagedIterable<AutocompleteItem> autocomplete(String searchText,
                                                        String suggesterName,
                                                        AutocompleteOptions autocompleteOptions,
                                                        RequestOptions requestOptions,
                                                        Context context) {
        return new PagedIterable<>(asyncClient.autocomplete(searchText,
            suggesterName, autocompleteOptions, requestOptions, context));
    }
}
