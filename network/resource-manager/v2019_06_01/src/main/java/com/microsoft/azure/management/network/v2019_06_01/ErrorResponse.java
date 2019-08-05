/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2019_06_01;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The error object.
 */
public class ErrorResponse {
    /**
     * Error.
     * The error details object.
     */
    @JsonProperty(value = "error")
    private ErrorDetails error;

    /**
     * Get the error details object.
     *
     * @return the error value
     */
    public ErrorDetails error() {
        return this.error;
    }

    /**
     * Set the error details object.
     *
     * @param error the error value to set
     * @return the ErrorResponse object itself.
     */
    public ErrorResponse withError(ErrorDetails error) {
        this.error = error;
        return this;
    }

}
