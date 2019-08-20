/**
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.azure.search.service.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Truncates the terms to a specific length. This token filter is implemented
 * using Apache Lucene.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@odata\\.type")
@JsonTypeName("#Microsoft.Azure.Search.TruncateTokenFilter")
public class TruncateTokenFilter extends TokenFilter {
    /**
     * The length at which terms will be truncated. Default and maximum is 300.
     */
    @JsonProperty(value = "length")
    private Integer length;

    /**
     * Get the length at which terms will be truncated. Default and maximum is 300.
     *
     * @return the length value
     */
    public Integer length() {
        return this.length;
    }

    /**
     * Set the length at which terms will be truncated. Default and maximum is 300.
     *
     * @param length the length value to set
     * @return the TruncateTokenFilter object itself.
     */
    public TruncateTokenFilter withLength(Integer length) {
        this.length = length;
        return this;
    }

}