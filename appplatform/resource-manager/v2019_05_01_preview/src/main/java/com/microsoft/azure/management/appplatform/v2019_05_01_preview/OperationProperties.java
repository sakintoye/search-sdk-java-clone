/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.appplatform.v2019_05_01_preview;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Extra Operation properties.
 */
public class OperationProperties {
    /**
     * Service specifications of the operation.
     */
    @JsonProperty(value = "serviceSpecification")
    private ServiceSpecification serviceSpecification;

    /**
     * Get service specifications of the operation.
     *
     * @return the serviceSpecification value
     */
    public ServiceSpecification serviceSpecification() {
        return this.serviceSpecification;
    }

    /**
     * Set service specifications of the operation.
     *
     * @param serviceSpecification the serviceSpecification value to set
     * @return the OperationProperties object itself.
     */
    public OperationProperties withServiceSpecification(ServiceSpecification serviceSpecification) {
        this.serviceSpecification = serviceSpecification;
        return this;
    }

}
