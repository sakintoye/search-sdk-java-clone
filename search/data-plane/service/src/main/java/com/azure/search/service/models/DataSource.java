/**
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.azure.search.service.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a datasource definition in Azure Search, which can be used to
 * configure an indexer.
 */
public class DataSource {
    /**
     * The name of the datasource.
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    /**
     * The description of the datasource.
     */
    @JsonProperty(value = "description")
    private String description;

    /**
     * The type of the datasource. Possible values include: 'azuresql',
     * 'cosmosdb', 'azureblob', 'azuretable'.
     */
    @JsonProperty(value = "type", required = true)
    private DataSourceType type;

    /**
     * Credentials for the datasource.
     */
    @JsonProperty(value = "credentials", required = true)
    private DataSourceCredentials credentials;

    /**
     * The data container for the datasource.
     */
    @JsonProperty(value = "container", required = true)
    private DataContainer container;

    /**
     * The data change detection policy for the datasource.
     */
    @JsonProperty(value = "dataChangeDetectionPolicy")
    private DataChangeDetectionPolicy dataChangeDetectionPolicy;

    /**
     * The data deletion detection policy for the datasource.
     */
    @JsonProperty(value = "dataDeletionDetectionPolicy")
    private DataDeletionDetectionPolicy dataDeletionDetectionPolicy;

    /**
     * The ETag of the DataSource.
     */
    @JsonProperty(value = "@odata\\.etag")
    private String eTag;

    /**
     * Get the name of the datasource.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name of the datasource.
     *
     * @param name the name value to set
     * @return the DataSource object itself.
     */
    public DataSource withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the description of the datasource.
     *
     * @return the description value
     */
    public String description() {
        return this.description;
    }

    /**
     * Set the description of the datasource.
     *
     * @param description the description value to set
     * @return the DataSource object itself.
     */
    public DataSource withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get the type of the datasource. Possible values include: 'azuresql', 'cosmosdb', 'azureblob', 'azuretable'.
     *
     * @return the type value
     */
    public DataSourceType type() {
        return this.type;
    }

    /**
     * Set the type of the datasource. Possible values include: 'azuresql', 'cosmosdb', 'azureblob', 'azuretable'.
     *
     * @param type the type value to set
     * @return the DataSource object itself.
     */
    public DataSource withType(DataSourceType type) {
        this.type = type;
        return this;
    }

    /**
     * Get credentials for the datasource.
     *
     * @return the credentials value
     */
    public DataSourceCredentials credentials() {
        return this.credentials;
    }

    /**
     * Set credentials for the datasource.
     *
     * @param credentials the credentials value to set
     * @return the DataSource object itself.
     */
    public DataSource withCredentials(DataSourceCredentials credentials) {
        this.credentials = credentials;
        return this;
    }

    /**
     * Get the data container for the datasource.
     *
     * @return the container value
     */
    public DataContainer container() {
        return this.container;
    }

    /**
     * Set the data container for the datasource.
     *
     * @param container the container value to set
     * @return the DataSource object itself.
     */
    public DataSource withContainer(DataContainer container) {
        this.container = container;
        return this;
    }

    /**
     * Get the data change detection policy for the datasource.
     *
     * @return the dataChangeDetectionPolicy value
     */
    public DataChangeDetectionPolicy dataChangeDetectionPolicy() {
        return this.dataChangeDetectionPolicy;
    }

    /**
     * Set the data change detection policy for the datasource.
     *
     * @param dataChangeDetectionPolicy the dataChangeDetectionPolicy value to set
     * @return the DataSource object itself.
     */
    public DataSource withDataChangeDetectionPolicy(DataChangeDetectionPolicy dataChangeDetectionPolicy) {
        this.dataChangeDetectionPolicy = dataChangeDetectionPolicy;
        return this;
    }

    /**
     * Get the data deletion detection policy for the datasource.
     *
     * @return the dataDeletionDetectionPolicy value
     */
    public DataDeletionDetectionPolicy dataDeletionDetectionPolicy() {
        return this.dataDeletionDetectionPolicy;
    }

    /**
     * Set the data deletion detection policy for the datasource.
     *
     * @param dataDeletionDetectionPolicy the dataDeletionDetectionPolicy value to set
     * @return the DataSource object itself.
     */
    public DataSource withDataDeletionDetectionPolicy(DataDeletionDetectionPolicy dataDeletionDetectionPolicy) {
        this.dataDeletionDetectionPolicy = dataDeletionDetectionPolicy;
        return this;
    }

    /**
     * Get the ETag of the DataSource.
     *
     * @return the eTag value
     */
    public String eTag() {
        return this.eTag;
    }

    /**
     * Set the ETag of the DataSource.
     *
     * @param eTag the eTag value to set
     * @return the DataSource object itself.
     */
    public DataSource withETag(String eTag) {
        this.eTag = eTag;
        return this;
    }

}