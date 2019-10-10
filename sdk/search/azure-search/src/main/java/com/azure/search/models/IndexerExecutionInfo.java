// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.

package com.azure.search.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Represents the current status and execution history of an indexer.
 */
@Fluent
public final class IndexerExecutionInfo {
    /*
     * Overall indexer status. Possible values include: 'unknown', 'error',
     * 'running'
     */
    @JsonProperty(value = "status", access = JsonProperty.Access.WRITE_ONLY)
    private IndexerStatus status;

    /*
     * The result of the most recent or an in-progress indexer execution.
     */
    @JsonProperty(value = "lastResult", access = JsonProperty.Access.WRITE_ONLY)
    private IndexerExecutionResult lastResult;

    /*
     * History of the recent indexer executions, sorted in reverse
     * chronological order.
     */
    @JsonProperty(value = "executionHistory", access = JsonProperty.Access.WRITE_ONLY)
    private List<IndexerExecutionResult> executionHistory;

    /*
     * The execution limits for the indexer.
     */
    @JsonProperty(value = "limits", access = JsonProperty.Access.WRITE_ONLY)
    private IndexerLimits limits;

    /**
     * Get the status property: Overall indexer status. Possible values
     * include: 'unknown', 'error', 'running'.
     *
     * @return the status value.
     */
    public IndexerStatus getStatus() {
        return this.status;
    }

    /**
     * Get the lastResult property: The result of the most recent or an
     * in-progress indexer execution.
     *
     * @return the lastResult value.
     */
    public IndexerExecutionResult getLastResult() {
        return this.lastResult;
    }

    /**
     * Get the executionHistory property: History of the recent indexer
     * executions, sorted in reverse chronological order.
     *
     * @return the executionHistory value.
     */
    public List<IndexerExecutionResult> getExecutionHistory() {
        return this.executionHistory;
    }

    /**
     * Get the limits property: The execution limits for the indexer.
     *
     * @return the limits value.
     */
    public IndexerLimits getLimits() {
        return this.limits;
    }
}
