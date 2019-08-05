// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.storage.file.models;

import com.azure.core.implementation.DateTimeRfc1123;
import com.azure.core.implementation.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.time.OffsetDateTime;

/**
 * Defines headers for SetMetadata operation.
 */
@JacksonXmlRootElement(localName = "File-SetMetadata-Headers")
@Fluent
public final class FileSetMetadataHeaders {
    /*
     * The ETag contains a value which represents the version of the file, in
     * quotes.
     */
    @JsonProperty(value = "ETag")
    private String eTag;

    /*
     * This header uniquely identifies the request that was made and can be
     * used for troubleshooting the request.
     */
    @JsonProperty(value = "x-ms-request-id")
    private String requestId;

    /*
     * Indicates the version of the File service used to execute the request.
     */
    @JsonProperty(value = "x-ms-version")
    private String version;

    /*
     * A UTC date/time value generated by the service that indicates the time
     * at which the response was initiated.
     */
    @JsonProperty(value = "Date")
    private DateTimeRfc1123 dateProperty;

    /*
     * The value of this header is set to true if the contents of the request
     * are successfully encrypted using the specified algorithm, and false
     * otherwise.
     */
    @JsonProperty(value = "x-ms-request-server-encrypted")
    private Boolean isServerEncrypted;

    /*
     * The errorCode property.
     */
    @JsonProperty(value = "x-ms-error-code")
    private String errorCode;

    /**
     * Get the eTag property: The ETag contains a value which represents the
     * version of the file, in quotes.
     *
     * @return the eTag value.
     */
    public String eTag() {
        return this.eTag;
    }

    /**
     * Set the eTag property: The ETag contains a value which represents the
     * version of the file, in quotes.
     *
     * @param eTag the eTag value to set.
     * @return the FileSetMetadataHeaders object itself.
     */
    public FileSetMetadataHeaders eTag(String eTag) {
        this.eTag = eTag;
        return this;
    }

    /**
     * Get the requestId property: This header uniquely identifies the request
     * that was made and can be used for troubleshooting the request.
     *
     * @return the requestId value.
     */
    public String requestId() {
        return this.requestId;
    }

    /**
     * Set the requestId property: This header uniquely identifies the request
     * that was made and can be used for troubleshooting the request.
     *
     * @param requestId the requestId value to set.
     * @return the FileSetMetadataHeaders object itself.
     */
    public FileSetMetadataHeaders requestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    /**
     * Get the version property: Indicates the version of the File service used
     * to execute the request.
     *
     * @return the version value.
     */
    public String version() {
        return this.version;
    }

    /**
     * Set the version property: Indicates the version of the File service used
     * to execute the request.
     *
     * @param version the version value to set.
     * @return the FileSetMetadataHeaders object itself.
     */
    public FileSetMetadataHeaders version(String version) {
        this.version = version;
        return this;
    }

    /**
     * Get the dateProperty property: A UTC date/time value generated by the
     * service that indicates the time at which the response was initiated.
     *
     * @return the dateProperty value.
     */
    public OffsetDateTime dateProperty() {
        if (this.dateProperty == null) {
            return null;
        }
        return this.dateProperty.dateTime();
    }

    /**
     * Set the dateProperty property: A UTC date/time value generated by the
     * service that indicates the time at which the response was initiated.
     *
     * @param dateProperty the dateProperty value to set.
     * @return the FileSetMetadataHeaders object itself.
     */
    public FileSetMetadataHeaders dateProperty(OffsetDateTime dateProperty) {
        if (dateProperty == null) {
            this.dateProperty = null;
        } else {
            this.dateProperty = new DateTimeRfc1123(dateProperty);
        }
        return this;
    }

    /**
     * Get the isServerEncrypted property: The value of this header is set to
     * true if the contents of the request are successfully encrypted using the
     * specified algorithm, and false otherwise.
     *
     * @return the isServerEncrypted value.
     */
    public Boolean isServerEncrypted() {
        return this.isServerEncrypted;
    }

    /**
     * Set the isServerEncrypted property: The value of this header is set to
     * true if the contents of the request are successfully encrypted using the
     * specified algorithm, and false otherwise.
     *
     * @param isServerEncrypted the isServerEncrypted value to set.
     * @return the FileSetMetadataHeaders object itself.
     */
    public FileSetMetadataHeaders isServerEncrypted(Boolean isServerEncrypted) {
        this.isServerEncrypted = isServerEncrypted;
        return this;
    }

    /**
     * Get the errorCode property: The errorCode property.
     *
     * @return the errorCode value.
     */
    public String errorCode() {
        return this.errorCode;
    }

    /**
     * Set the errorCode property: The errorCode property.
     *
     * @param errorCode the errorCode value to set.
     * @return the FileSetMetadataHeaders object itself.
     */
    public FileSetMetadataHeaders errorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }
}
