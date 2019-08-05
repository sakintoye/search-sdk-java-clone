// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.storage.blob.models;

import com.azure.core.implementation.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * Additional parameters for a set of operations, such as:
 * PageBlobs_uploadPages, PageBlobs_clearPages, PageBlobs_uploadPagesFromURL.
 */
@JacksonXmlRootElement(localName = "sequence-number-access-conditions")
@Fluent
public final class SequenceNumberAccessConditions {
    /*
     * Specify this header value to operate only on a blob if it has a sequence
     * number less than or equal to the specified.
     */
    @JsonProperty(value = "ifSequenceNumberLessThanOrEqualTo")
    private Long ifSequenceNumberLessThanOrEqualTo;

    /*
     * Specify this header value to operate only on a blob if it has a sequence
     * number less than the specified.
     */
    @JsonProperty(value = "ifSequenceNumberLessThan")
    private Long ifSequenceNumberLessThan;

    /*
     * Specify this header value to operate only on a blob if it has the
     * specified sequence number.
     */
    @JsonProperty(value = "ifSequenceNumberEqualTo")
    private Long ifSequenceNumberEqualTo;

    /**
     * Get the ifSequenceNumberLessThanOrEqualTo property: Specify this header
     * value to operate only on a blob if it has a sequence number less than or
     * equal to the specified.
     *
     * @return the ifSequenceNumberLessThanOrEqualTo value.
     */
    public Long ifSequenceNumberLessThanOrEqualTo() {
        return this.ifSequenceNumberLessThanOrEqualTo;
    }

    /**
     * Set the ifSequenceNumberLessThanOrEqualTo property: Specify this header
     * value to operate only on a blob if it has a sequence number less than or
     * equal to the specified.
     *
     * @param ifSequenceNumberLessThanOrEqualTo the
     * ifSequenceNumberLessThanOrEqualTo value to set.
     * @return the SequenceNumberAccessConditions object itself.
     */
    public SequenceNumberAccessConditions ifSequenceNumberLessThanOrEqualTo(Long ifSequenceNumberLessThanOrEqualTo) {
        this.ifSequenceNumberLessThanOrEqualTo = ifSequenceNumberLessThanOrEqualTo;
        return this;
    }

    /**
     * Get the ifSequenceNumberLessThan property: Specify this header value to
     * operate only on a blob if it has a sequence number less than the
     * specified.
     *
     * @return the ifSequenceNumberLessThan value.
     */
    public Long ifSequenceNumberLessThan() {
        return this.ifSequenceNumberLessThan;
    }

    /**
     * Set the ifSequenceNumberLessThan property: Specify this header value to
     * operate only on a blob if it has a sequence number less than the
     * specified.
     *
     * @param ifSequenceNumberLessThan the ifSequenceNumberLessThan value to
     * set.
     * @return the SequenceNumberAccessConditions object itself.
     */
    public SequenceNumberAccessConditions ifSequenceNumberLessThan(Long ifSequenceNumberLessThan) {
        this.ifSequenceNumberLessThan = ifSequenceNumberLessThan;
        return this;
    }

    /**
     * Get the ifSequenceNumberEqualTo property: Specify this header value to
     * operate only on a blob if it has the specified sequence number.
     *
     * @return the ifSequenceNumberEqualTo value.
     */
    public Long ifSequenceNumberEqualTo() {
        return this.ifSequenceNumberEqualTo;
    }

    /**
     * Set the ifSequenceNumberEqualTo property: Specify this header value to
     * operate only on a blob if it has the specified sequence number.
     *
     * @param ifSequenceNumberEqualTo the ifSequenceNumberEqualTo value to set.
     * @return the SequenceNumberAccessConditions object itself.
     */
    public SequenceNumberAccessConditions ifSequenceNumberEqualTo(Long ifSequenceNumberEqualTo) {
        this.ifSequenceNumberEqualTo = ifSequenceNumberEqualTo;
        return this;
    }
}
