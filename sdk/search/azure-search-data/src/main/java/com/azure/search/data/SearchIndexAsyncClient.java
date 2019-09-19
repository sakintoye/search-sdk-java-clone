// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.search.data;

import com.azure.core.http.rest.PagedFlux;
import com.azure.search.data.customization.Document;
import com.azure.search.data.generated.models.AutocompleteItem;
import com.azure.search.data.generated.models.AutocompleteParameters;
import com.azure.search.data.generated.models.DocumentIndexResult;
import com.azure.search.data.generated.models.IndexBatch;
import com.azure.search.data.generated.models.SearchParameters;
import com.azure.search.data.generated.models.SearchRequestOptions;
import com.azure.search.data.generated.models.SearchResult;
import com.azure.search.data.generated.models.SuggestParameters;
import com.azure.search.data.generated.models.SuggestResult;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * The public (Customer facing) interface for SearchIndexASyncClient.
 */
public interface SearchIndexAsyncClient {
    // Indices

    /**
     * Gets Client Api Version.
     *
     * @return the apiVersion value
     */
    String getApiVersion();

    /**
     * Gets The name of the Azure Search service.
     *
     * @return the searchServiceName value
     */
    String getSearchServiceName();

    /**
     * Gets The DNS suffix of the Azure Search service. The default is search.windows.net.
     *
     * @return the searchDnsSuffix value
     */
    String getSearchDnsSuffix();

    /**
     * Gets The name of the Azure Search index
     *
     * @return the indexName value
     */
    String getIndexName();

    /**
     * Sets The name of the Azure Search index.
     *
     * @param indexName the indexName value
     * @return the service client itself
     */
    SearchIndexAsyncClient setIndexName(String indexName);


    // Index Operations

    /**
     * Uploads a document to the target index.
     *
     * @param document the document to upload to the target Index
     * @param <T> the type of object to serialize
     * @return document index result
     */
    <T> Mono<DocumentIndexResult>  uploadDocument(T document);

    /**
     * Uploads a collection of documents to the target index.
     *
     * @param documents collection of documents to upload to the target Index
     * @param <T> the type of object to serialize
     * @return document index result
     */
    <T> Mono<DocumentIndexResult> uploadDocuments(List<T> documents);

    /**
     * Deletes a collection of documents from the target index
     *
     * @param documents collection of documents to delete from the target Index.
     * @param <T> The type of object to serialize.
     * @return document index result.
     */
    <T> Mono<DocumentIndexResult> deleteDocuments(List<T> documents);

    /**
     * Merges a document with an existing document in the target index.
     *
     * @param document the document to be merged
     * @param <T> the type of object to serialize
     * @return document index result
     */
    <T> Mono<DocumentIndexResult>  mergeDocument(T document);

    /**
     * Merges a collection of documents with existing documents in the target index.
     *
     * @param documents collection of documents to be merged
     * @param <T> the type of object to serialize
     * @return document index result
     */
    <T> Mono<DocumentIndexResult> mergeDocuments(List<T> documents);

    /**
     * This action behaves like merge if a document with the given key already exists in the index.
     * If the document does not exist, it behaves like upload with a new document.
     *
     * @param document the document to be merged, if exists, otherwise uploaded as a new document
     * @param <T> the type of object to serialize
     * @return document index result
     */
    <T> Mono<DocumentIndexResult> mergeOrUploadDocument(T document);

    /**
     * This action behaves like merge if a document with the given key already exists in the index.
     * If the document does not exist, it behaves like upload with a new document.
     *
     * @param documents collection of documents to be merged, if exists, otherwise uploaded as a new document
     * @param <T> the type of object to serialize
     * @return document index result
     */
    <T> Mono<DocumentIndexResult> mergeOrUploadDocuments(List<T> documents);

    /**
     * Deletes a document from the target index.
     * Note that any field you specify in a delete operation, other than the key field, will be ignored.
     *
     * @param document the document to delete from the target Index
     * @param <T> The type of object to serialize
     * @return document index result
     */
    <T> Mono<DocumentIndexResult> deleteDocument(T document);

    /**
     * Gets the number of documents.
     *
     * @return the number of documents
     */
    Mono<Long> countDocuments();

    /**
     * Searches for documents in the Azure Search index.
     *
     * @return PagedFlux of the search result
     */
    PagedFlux<SearchResult> search();

    /**
     * Searches for documents in the Azure Search index
     *
     * @param searchText Search Test
     * @param searchParameters Search Parameters
     * @param searchRequestOptions Search Request Options
     * @return PagedFlux of the search result.
     */
    PagedFlux<SearchResult> search(String searchText,
                                   SearchParameters searchParameters,
                                   SearchRequestOptions searchRequestOptions);

    /**
     * Retrieves a document from the Azure Search index.
     *
     * @param key the name of the document
     * @return document object
     */
    Mono<Document> getDocument(String key);

    /**
     * Retrieves a document from the Azure Search index.
     *
     * @param key document key
     * @param selectedFields selected fields to return
     * @param searchRequestOptions search request options
     * @return document object
     */
    Mono<Document> getDocument(String key,
                               List<String> selectedFields,
                               SearchRequestOptions searchRequestOptions);

    /**
     * Suggests documents in the Azure Search index that match the given partial query text.
     *
     * @param searchText search text
     * @param suggesterName suggester name
     * @return suggests result
     */
    PagedFlux<SuggestResult> suggest(String searchText, String suggesterName);

    /**
     * Suggests documents in the Azure Search index that match the given partial query text.
     *
     * @param searchText search text
     * @param suggesterName suggester name
     * @param suggestParameters suggest parameters
     * @param searchRequestOptions search request options
     * @return suggests results
     */
    PagedFlux<SuggestResult> suggest(String searchText,
                                     String suggesterName,
                                     SuggestParameters suggestParameters,
                                     SearchRequestOptions searchRequestOptions);

    /**
     * Sends a batch of document write actions to the Azure Search index.
     *
     * @param batch batch of documents to send to the index with the requested action
     * @return document index result
     */
    Mono<DocumentIndexResult> index(IndexBatch batch);

    /**
     * Autocompletes incomplete query terms based on input text and matching terms in the Azure Search index.
     *
     * @param searchText search text
     * @param suggesterName suggester name
     * @return auto complete result
     */
    PagedFlux<AutocompleteItem> autocomplete(String searchText, String suggesterName);

    /**
     * Autocompletes incomplete query terms based on input text and matching terms in the Azure Search index.
     *
     * @param searchText search text
     * @param suggesterName suggester name
     * @param searchRequestOptions search request options
     * @param autocompleteParameters auto complete parameters
     * @return auto complete result
     */
    PagedFlux<AutocompleteItem> autocomplete(String searchText,
                                             String suggesterName,
                                             SearchRequestOptions searchRequestOptions,
                                             AutocompleteParameters autocompleteParameters);
}
