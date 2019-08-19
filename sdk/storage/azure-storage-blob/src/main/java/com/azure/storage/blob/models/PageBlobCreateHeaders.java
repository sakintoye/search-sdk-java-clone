// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.storage.blob.models;

import com.azure.core.implementation.DateTimeRfc1123;
import com.azure.core.implementation.annotation.Fluent;
import com.azure.core.implementation.util.ImplUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.time.OffsetDateTime;

/**
 * Defines headers for Create operation.
 */
@JacksonXmlRootElement(localName = "PageBlob-Create-Headers")
@Fluent
public final class PageBlobCreateHeaders {
    /*
     * The ETag contains a value that you can use to perform operations
     * conditionally. If the request version is 2011-08-18 or newer, the ETag
     * value will be in quotes.
     */
    @JsonProperty(value = "ETag")
    private String eTag;

    /*
     * Returns the date and time the container was last modified. Any operation
     * that modifies the blob, including an update of the blob's metadata or
     * properties, changes the last-modified time of the blob.
     */
    @JsonProperty(value = "Last-Modified")
    private DateTimeRfc1123 lastModified;

    /*
     * If the blob has an MD5 hash and this operation is to read the full blob,
     * this response header is returned so that the client can check for
     * message content integrity.
     */
    @JsonProperty(value = "Content-MD5")
    private byte[] contentMD5;

    /*
     * If a client request id header is sent in the request, this header will
     * be present in the response with the same value.
     */
    @JsonProperty(value = "x-ms-client-request-id")
    private String clientRequestId;

    /*
     * This header uniquely identifies the request that was made and can be
     * used for troubleshooting the request.
     */
    @JsonProperty(value = "x-ms-request-id")
    private String requestId;

    /*
     * Indicates the version of the Blob service used to execute the request.
     * This header is returned for requests made against version 2009-09-19 and
     * above.
     */
    @JsonProperty(value = "x-ms-version")
    private String version;

    /*
     * UTC date/time value generated by the service that identifies a version
     * of the blob. This header is returned for requests made against version
     * 2018-11-09 and above.
     */
    @JsonProperty(value = "x-ms-version-id")
    private String versionId;

    /*
     * UTC date/time value generated by the service that indicates the time at
     * which the response was initiated
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
     * The SHA-256 hash of the encryption key used to encrypt the blob. This
     * header is only returned when the blob was encrypted with a
     * customer-provided key.
     */
    @JsonProperty(value = "x-ms-encryption-key-sha256")
    private String encryptionKeySha256;

    /*
     * The encryption scope used to encrypt the blob. This header is only
     * returned when the blob was encrypted with customer specified encryption.
     */
    @JsonProperty(value = "x-ms-encryption-scope")
    private String encryptionScope;

    /*
     * The errorCode property.
     */
    @JsonProperty(value = "x-ms-error-code")
    private String errorCode;

    /**
     * Get the eTag property: The ETag contains a value that you can use to
     * perform operations conditionally. If the request version is 2011-08-18
     * or newer, the ETag value will be in quotes.
     *
     * @return the eTag value.
     */
    public String eTag() {
        return this.eTag;
    }

    /**
     * Set the eTag property: The ETag contains a value that you can use to
     * perform operations conditionally. If the request version is 2011-08-18
     * or newer, the ETag value will be in quotes.
     *
     * @param eTag the eTag value to set.
     * @return the PageBlobCreateHeaders object itself.
     */
    public PageBlobCreateHeaders eTag(String eTag) {
        this.eTag = eTag;
        return this;
    }

    /**
     * Get the lastModified property: Returns the date and time the container
     * was last modified. Any operation that modifies the blob, including an
     * update of the blob's metadata or properties, changes the last-modified
     * time of the blob.
     *
     * @return the lastModified value.
     */
    public OffsetDateTime lastModified() {
        if (this.lastModified == null) {
            return null;
        }
        return this.lastModified.dateTime();
    }

    /**
     * Set the lastModified property: Returns the date and time the container
     * was last modified. Any operation that modifies the blob, including an
     * update of the blob's metadata or properties, changes the last-modified
     * time of the blob.
     *
     * @param lastModified the lastModified value to set.
     * @return the PageBlobCreateHeaders object itself.
     */
    public PageBlobCreateHeaders lastModified(OffsetDateTime lastModified) {
        if (lastModified == null) {
            this.lastModified = null;
        } else {
            this.lastModified = new DateTimeRfc1123(lastModified);
        }
        return this;
    }

    /**
     * Get the contentMD5 property: If the blob has an MD5 hash and this
     * operation is to read the full blob, this response header is returned so
     * that the client can check for message content integrity.
     *
     * @return the contentMD5 value.
     */
    public byte[] contentMD5() {
        return ImplUtils.clone(this.contentMD5);
    }

    /**
     * Set the contentMD5 property: If the blob has an MD5 hash and this
     * operation is to read the full blob, this response header is returned so
     * that the client can check for message content integrity.
     *
     * @param contentMD5 the contentMD5 value to set.
     * @return the PageBlobCreateHeaders object itself.
     */
    public PageBlobCreateHeaders contentMD5(byte[] contentMD5) {
        this.contentMD5 = ImplUtils.clone(contentMD5);
        return this;
    }

    /**
     * Get the clientRequestId property: If a client request id header is sent
     * in the request, this header will be present in the response with the
     * same value.
     *
     * @return the clientRequestId value.
     */
    public String clientRequestId() {
        return this.clientRequestId;
    }

    /**
     * Set the clientRequestId property: If a client request id header is sent
     * in the request, this header will be present in the response with the
     * same value.
     *
     * @param clientRequestId the clientRequestId value to set.
     * @return the PageBlobCreateHeaders object itself.
     */
    public PageBlobCreateHeaders clientRequestId(String clientRequestId) {
        this.clientRequestId = clientRequestId;
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
     * @return the PageBlobCreateHeaders object itself.
     */
    public PageBlobCreateHeaders requestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    /**
     * Get the version property: Indicates the version of the Blob service used
     * to execute the request. This header is returned for requests made
     * against version 2009-09-19 and above.
     *
     * @return the version value.
     */
    public String version() {
        return this.version;
    }

    /**
     * Set the version property: Indicates the version of the Blob service used
     * to execute the request. This header is returned for requests made
     * against version 2009-09-19 and above.
     *
     * @param version the version value to set.
     * @return the PageBlobCreateHeaders object itself.
     */
    public PageBlobCreateHeaders version(String version) {
        this.version = version;
        return this;
    }

    /**
     * Get the versionId property: UTC date/time value generated by the service
     * that identifies a version of the blob. This header is returned for
     * requests made against version 2018-11-09 and above.
     *
     * @return the versionId value.
     */
    public String versionId() {
        return this.versionId;
    }

    /**
     * Set the versionId property: UTC date/time value generated by the service
     * that identifies a version of the blob. This header is returned for
     * requests made against version 2018-11-09 and above.
     *
     * @param versionId the versionId value to set.
     * @return the PageBlobCreateHeaders object itself.
     */
    public PageBlobCreateHeaders versionId(String versionId) {
        this.versionId = versionId;
        return this;
    }

    /**
     * Get the dateProperty property: UTC date/time value generated by the
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
     * Set the dateProperty property: UTC date/time value generated by the
     * service that indicates the time at which the response was initiated.
     *
     * @param dateProperty the dateProperty value to set.
     * @return the PageBlobCreateHeaders object itself.
     */
    public PageBlobCreateHeaders dateProperty(OffsetDateTime dateProperty) {
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
     * @return the PageBlobCreateHeaders object itself.
     */
    public PageBlobCreateHeaders isServerEncrypted(Boolean isServerEncrypted) {
        this.isServerEncrypted = isServerEncrypted;
        return this;
    }

    /**
     * Get the encryptionKeySha256 property: The SHA-256 hash of the encryption
     * key used to encrypt the blob. This header is only returned when the blob
     * was encrypted with a customer-provided key.
     *
     * @return the encryptionKeySha256 value.
     */
    public String encryptionKeySha256() {
        return this.encryptionKeySha256;
    }

    /**
     * Set the encryptionKeySha256 property: The SHA-256 hash of the encryption
     * key used to encrypt the blob. This header is only returned when the blob
     * was encrypted with a customer-provided key.
     *
     * @param encryptionKeySha256 the encryptionKeySha256 value to set.
     * @return the PageBlobCreateHeaders object itself.
     */
    public PageBlobCreateHeaders encryptionKeySha256(String encryptionKeySha256) {
        this.encryptionKeySha256 = encryptionKeySha256;
        return this;
    }

    /**
     * Get the encryptionScope property: The encryption scope used to encrypt
     * the blob. This header is only returned when the blob was encrypted with
     * customer specified encryption.
     *
     * @return the encryptionScope value.
     */
    public String encryptionScope() {
        return this.encryptionScope;
    }

    /**
     * Set the encryptionScope property: The encryption scope used to encrypt
     * the blob. This header is only returned when the blob was encrypted with
     * customer specified encryption.
     *
     * @param encryptionScope the encryptionScope value to set.
     * @return the PageBlobCreateHeaders object itself.
     */
    public PageBlobCreateHeaders encryptionScope(String encryptionScope) {
        this.encryptionScope = encryptionScope;
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
     * @return the PageBlobCreateHeaders object itself.
     */
    public PageBlobCreateHeaders errorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }
}
