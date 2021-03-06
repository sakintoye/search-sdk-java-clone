/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.labservices.v2018_10_15.implementation;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Status Details of the long running operation for an environment.
 */
public class OperationStatusResponseInner {
    /**
     * status of the long running operation for an environment.
     */
    @JsonProperty(value = "status", access = JsonProperty.Access.WRITE_ONLY)
    private String status;

    /**
     * Get status of the long running operation for an environment.
     *
     * @return the status value
     */
    public String status() {
        return this.status;
    }

}
