/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.recoveryservices;

import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonSubTypes;

/**
 * Certificate details representing the Vault credentials.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "authType")
@JsonTypeName("ResourceCertificateDetails")
@JsonSubTypes({
    @JsonSubTypes.Type(name = "AzureActiveDirectory", value = ResourceCertificateAndAadDetails.class),
    @JsonSubTypes.Type(name = "AccessControlService", value = ResourceCertificateAndAcsDetails.class)
})
public class ResourceCertificateDetails {
    /**
     * The base64 encoded certificate raw data string.
     */
    @JsonProperty(value = "certificate")
    private byte[] certificate;

    /**
     * Certificate friendlyname.
     */
    @JsonProperty(value = "friendlyName")
    private String friendlyName;

    /**
     * Certificate issuer.
     */
    @JsonProperty(value = "issuer")
    private String issuer;

    /**
     * Resource ID of the vault.
     */
    @JsonProperty(value = "resourceId")
    private Long resourceId;

    /**
     * Certificate Subject Name.
     */
    @JsonProperty(value = "subject")
    private String subject;

    /**
     * Certificate thumbprint.
     */
    @JsonProperty(value = "thumbprint")
    private String thumbprint;

    /**
     * Certificate Validity start Date time.
     */
    @JsonProperty(value = "validFrom")
    private DateTime validFrom;

    /**
     * Certificate Validity End Date time.
     */
    @JsonProperty(value = "validTo")
    private DateTime validTo;

    /**
     * Get the certificate value.
     *
     * @return the certificate value
     */
    public byte[] certificate() {
        return this.certificate;
    }

    /**
     * Set the certificate value.
     *
     * @param certificate the certificate value to set
     * @return the ResourceCertificateDetails object itself.
     */
    public ResourceCertificateDetails withCertificate(byte[] certificate) {
        this.certificate = certificate;
        return this;
    }

    /**
     * Get the friendlyName value.
     *
     * @return the friendlyName value
     */
    public String friendlyName() {
        return this.friendlyName;
    }

    /**
     * Set the friendlyName value.
     *
     * @param friendlyName the friendlyName value to set
     * @return the ResourceCertificateDetails object itself.
     */
    public ResourceCertificateDetails withFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * Get the issuer value.
     *
     * @return the issuer value
     */
    public String issuer() {
        return this.issuer;
    }

    /**
     * Set the issuer value.
     *
     * @param issuer the issuer value to set
     * @return the ResourceCertificateDetails object itself.
     */
    public ResourceCertificateDetails withIssuer(String issuer) {
        this.issuer = issuer;
        return this;
    }

    /**
     * Get the resourceId value.
     *
     * @return the resourceId value
     */
    public Long resourceId() {
        return this.resourceId;
    }

    /**
     * Set the resourceId value.
     *
     * @param resourceId the resourceId value to set
     * @return the ResourceCertificateDetails object itself.
     */
    public ResourceCertificateDetails withResourceId(Long resourceId) {
        this.resourceId = resourceId;
        return this;
    }

    /**
     * Get the subject value.
     *
     * @return the subject value
     */
    public String subject() {
        return this.subject;
    }

    /**
     * Set the subject value.
     *
     * @param subject the subject value to set
     * @return the ResourceCertificateDetails object itself.
     */
    public ResourceCertificateDetails withSubject(String subject) {
        this.subject = subject;
        return this;
    }

    /**
     * Get the thumbprint value.
     *
     * @return the thumbprint value
     */
    public String thumbprint() {
        return this.thumbprint;
    }

    /**
     * Set the thumbprint value.
     *
     * @param thumbprint the thumbprint value to set
     * @return the ResourceCertificateDetails object itself.
     */
    public ResourceCertificateDetails withThumbprint(String thumbprint) {
        this.thumbprint = thumbprint;
        return this;
    }

    /**
     * Get the validFrom value.
     *
     * @return the validFrom value
     */
    public DateTime validFrom() {
        return this.validFrom;
    }

    /**
     * Set the validFrom value.
     *
     * @param validFrom the validFrom value to set
     * @return the ResourceCertificateDetails object itself.
     */
    public ResourceCertificateDetails withValidFrom(DateTime validFrom) {
        this.validFrom = validFrom;
        return this;
    }

    /**
     * Get the validTo value.
     *
     * @return the validTo value
     */
    public DateTime validTo() {
        return this.validTo;
    }

    /**
     * Set the validTo value.
     *
     * @param validTo the validTo value to set
     * @return the ResourceCertificateDetails object itself.
     */
    public ResourceCertificateDetails withValidTo(DateTime validTo) {
        this.validTo = validTo;
        return this;
    }

}