/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.signalr.v2018_10_01.implementation;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A class represents the access keys of SignalR service.
 */
public class SignalRKeysInner {
    /**
     * The primary access key.
     */
    @JsonProperty(value = "primaryKey")
    private String primaryKey;

    /**
     * The secondary access key.
     */
    @JsonProperty(value = "secondaryKey")
    private String secondaryKey;

    /**
     * SignalR connection string constructed via the primaryKey.
     */
    @JsonProperty(value = "primaryConnectionString")
    private String primaryConnectionString;

    /**
     * SignalR connection string constructed via the secondaryKey.
     */
    @JsonProperty(value = "secondaryConnectionString")
    private String secondaryConnectionString;

    /**
     * Get the primary access key.
     *
     * @return the primaryKey value
     */
    public String primaryKey() {
        return this.primaryKey;
    }

    /**
     * Set the primary access key.
     *
     * @param primaryKey the primaryKey value to set
     * @return the SignalRKeysInner object itself.
     */
    public SignalRKeysInner withPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
        return this;
    }

    /**
     * Get the secondary access key.
     *
     * @return the secondaryKey value
     */
    public String secondaryKey() {
        return this.secondaryKey;
    }

    /**
     * Set the secondary access key.
     *
     * @param secondaryKey the secondaryKey value to set
     * @return the SignalRKeysInner object itself.
     */
    public SignalRKeysInner withSecondaryKey(String secondaryKey) {
        this.secondaryKey = secondaryKey;
        return this;
    }

    /**
     * Get signalR connection string constructed via the primaryKey.
     *
     * @return the primaryConnectionString value
     */
    public String primaryConnectionString() {
        return this.primaryConnectionString;
    }

    /**
     * Set signalR connection string constructed via the primaryKey.
     *
     * @param primaryConnectionString the primaryConnectionString value to set
     * @return the SignalRKeysInner object itself.
     */
    public SignalRKeysInner withPrimaryConnectionString(String primaryConnectionString) {
        this.primaryConnectionString = primaryConnectionString;
        return this;
    }

    /**
     * Get signalR connection string constructed via the secondaryKey.
     *
     * @return the secondaryConnectionString value
     */
    public String secondaryConnectionString() {
        return this.secondaryConnectionString;
    }

    /**
     * Set signalR connection string constructed via the secondaryKey.
     *
     * @param secondaryConnectionString the secondaryConnectionString value to set
     * @return the SignalRKeysInner object itself.
     */
    public SignalRKeysInner withSecondaryConnectionString(String secondaryConnectionString) {
        this.secondaryConnectionString = secondaryConnectionString;
        return this;
    }

}
