// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.

package com.azure.search.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a datasource definition in Azure Search, which can be used to
 * configure an indexer.
 */
@Fluent
public final class DataSource {
    /*
     * The name of the datasource.
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    /*
     * The description of the datasource.
     */
    @JsonProperty(value = "description")
    private String description;

    /*
     * The type of the datasource. Possible values include: 'azuresql',
     * 'cosmosdb', 'azureblob', 'azuretable'
     */
    @JsonProperty(value = "type", required = true)
    private DataSourceType type;

    /*
     * Credentials for the datasource.
     */
    @JsonProperty(value = "credentials", required = true)
    private DataSourceCredentials credentials;

    /*
     * The data container for the datasource.
     */
    @JsonProperty(value = "container", required = true)
    private DataContainer container;

    /*
     * The data change detection policy for the datasource.
     */
    @JsonProperty(value = "dataChangeDetectionPolicy")
    private DataChangeDetectionPolicy dataChangeDetectionPolicy;

    /*
     * The data deletion detection policy for the datasource.
     */
    @JsonProperty(value = "dataDeletionDetectionPolicy")
    private DataDeletionDetectionPolicy dataDeletionDetectionPolicy;

    /*
     * The ETag of the DataSource.
     */
    @JsonProperty(value = "@odata.etag")
    private String eTag;

    /**
     * Get the name property: The name of the datasource.
     *
     * @return the name value.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the name property: The name of the datasource.
     *
     * @param name the name value to set.
     * @return the DataSource object itself.
     */
    public DataSource setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the description property: The description of the datasource.
     *
     * @return the description value.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Set the description property: The description of the datasource.
     *
     * @param description the description value to set.
     * @return the DataSource object itself.
     */
    public DataSource setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get the type property: The type of the datasource. Possible values
     * include: 'azuresql', 'cosmosdb', 'azureblob', 'azuretable'.
     *
     * @return the type value.
     */
    public DataSourceType getType() {
        return this.type;
    }

    /**
     * Set the type property: The type of the datasource. Possible values
     * include: 'azuresql', 'cosmosdb', 'azureblob', 'azuretable'.
     *
     * @param type the type value to set.
     * @return the DataSource object itself.
     */
    public DataSource setType(DataSourceType type) {
        this.type = type;
        return this;
    }

    /**
     * Get the credentials property: Credentials for the datasource.
     *
     * @return the credentials value.
     */
    public DataSourceCredentials getCredentials() {
        return this.credentials;
    }

    /**
     * Set the credentials property: Credentials for the datasource.
     *
     * @param credentials the credentials value to set.
     * @return the DataSource object itself.
     */
    public DataSource setCredentials(DataSourceCredentials credentials) {
        this.credentials = credentials;
        return this;
    }

    /**
     * Get the container property: The data container for the datasource.
     *
     * @return the container value.
     */
    public DataContainer getContainer() {
        return this.container;
    }

    /**
     * Set the container property: The data container for the datasource.
     *
     * @param container the container value to set.
     * @return the DataSource object itself.
     */
    public DataSource setContainer(DataContainer container) {
        this.container = container;
        return this;
    }

    /**
     * Get the dataChangeDetectionPolicy property: The data change detection
     * policy for the datasource.
     *
     * @return the dataChangeDetectionPolicy value.
     */
    public DataChangeDetectionPolicy getDataChangeDetectionPolicy() {
        return this.dataChangeDetectionPolicy;
    }

    /**
     * Set the dataChangeDetectionPolicy property: The data change detection
     * policy for the datasource.
     *
     * @param dataChangeDetectionPolicy the dataChangeDetectionPolicy value to
     * set.
     * @return the DataSource object itself.
     */
    public DataSource setDataChangeDetectionPolicy(DataChangeDetectionPolicy dataChangeDetectionPolicy) {
        this.dataChangeDetectionPolicy = dataChangeDetectionPolicy;
        return this;
    }

    /**
     * Get the dataDeletionDetectionPolicy property: The data deletion
     * detection policy for the datasource.
     *
     * @return the dataDeletionDetectionPolicy value.
     */
    public DataDeletionDetectionPolicy getDataDeletionDetectionPolicy() {
        return this.dataDeletionDetectionPolicy;
    }

    /**
     * Set the dataDeletionDetectionPolicy property: The data deletion
     * detection policy for the datasource.
     *
     * @param dataDeletionDetectionPolicy the dataDeletionDetectionPolicy value
     * to set.
     * @return the DataSource object itself.
     */
    public DataSource setDataDeletionDetectionPolicy(DataDeletionDetectionPolicy dataDeletionDetectionPolicy) {
        this.dataDeletionDetectionPolicy = dataDeletionDetectionPolicy;
        return this;
    }

    /**
     * Get the eTag property: The ETag of the DataSource.
     *
     * @return the eTag value.
     */
    public String getETag() {
        return this.eTag;
    }

    /**
     * Set the eTag property: The ETag of the DataSource.
     *
     * @param eTag the eTag value to set.
     * @return the DataSource object itself.
     */
    public DataSource setETag(String eTag) {
        this.eTag = eTag;
        return this;
    }
}