// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.

package com.azure.search.data.generated.models;

import com.azure.core.implementation.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Response containing the status of operations for all documents in the
 * indexing request.
 */
@Fluent
public final class DocumentIndexResult {
    /*
     * The list of status information for each document in the indexing
     * request.
     */
    @JsonProperty(value = "value", access = JsonProperty.Access.WRITE_ONLY)
    private List<IndexingResult> results;

    /**
     * Get the results property: The list of status information for each
     * document in the indexing request.
     *
     * @return the results value.
     */
    public List<IndexingResult> results() {
        return this.results;
    }
}