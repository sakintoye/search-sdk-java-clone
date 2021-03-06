/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.containerregistry.v2018_09_01.implementation;

import com.microsoft.azure.management.containerregistry.v2018_09_01.ProvisioningState;
import com.microsoft.azure.management.containerregistry.v2018_09_01.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.Resource;

/**
 * An object that represents a replication for a container registry.
 */
@JsonFlatten
public class ReplicationInner extends Resource {
    /**
     * The provisioning state of the replication at the time the operation was
     * called. Possible values include: 'Creating', 'Updating', 'Deleting',
     * 'Succeeded', 'Failed', 'Canceled'.
     */
    @JsonProperty(value = "properties.provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private ProvisioningState provisioningState;

    /**
     * The status of the replication at the time the operation was called.
     */
    @JsonProperty(value = "properties.status", access = JsonProperty.Access.WRITE_ONLY)
    private Status status;

    /**
     * Get the provisioning state of the replication at the time the operation was called. Possible values include: 'Creating', 'Updating', 'Deleting', 'Succeeded', 'Failed', 'Canceled'.
     *
     * @return the provisioningState value
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the status of the replication at the time the operation was called.
     *
     * @return the status value
     */
    public Status status() {
        return this.status;
    }

}
