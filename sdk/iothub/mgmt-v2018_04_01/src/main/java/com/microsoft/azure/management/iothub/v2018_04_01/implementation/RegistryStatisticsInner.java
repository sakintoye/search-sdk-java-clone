/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.iothub.v2018_04_01.implementation;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Identity registry statistics.
 */
public class RegistryStatisticsInner {
    /**
     * The total count of devices in the identity registry.
     */
    @JsonProperty(value = "totalDeviceCount", access = JsonProperty.Access.WRITE_ONLY)
    private Long totalDeviceCount;

    /**
     * The count of enabled devices in the identity registry.
     */
    @JsonProperty(value = "enabledDeviceCount", access = JsonProperty.Access.WRITE_ONLY)
    private Long enabledDeviceCount;

    /**
     * The count of disabled devices in the identity registry.
     */
    @JsonProperty(value = "disabledDeviceCount", access = JsonProperty.Access.WRITE_ONLY)
    private Long disabledDeviceCount;

    /**
     * Get the total count of devices in the identity registry.
     *
     * @return the totalDeviceCount value
     */
    public Long totalDeviceCount() {
        return this.totalDeviceCount;
    }

    /**
     * Get the count of enabled devices in the identity registry.
     *
     * @return the enabledDeviceCount value
     */
    public Long enabledDeviceCount() {
        return this.enabledDeviceCount;
    }

    /**
     * Get the count of disabled devices in the identity registry.
     *
     * @return the disabledDeviceCount value
     */
    public Long disabledDeviceCount() {
        return this.disabledDeviceCount;
    }

}