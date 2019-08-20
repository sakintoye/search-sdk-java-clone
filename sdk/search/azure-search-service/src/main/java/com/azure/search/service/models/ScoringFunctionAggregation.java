/**
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.azure.search.service.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for ScoringFunctionAggregation.
 */
public enum ScoringFunctionAggregation {
    /**
     * Enum value sum.
     */
    SUM("sum"),

    /**
     * Enum value average.
     */
    AVERAGE("average"),

    /**
     * Enum value minimum.
     */
    MINIMUM("minimum"),

    /**
     * Enum value maximum.
     */
    MAXIMUM("maximum"),

    /**
     * Enum value firstMatching.
     */
    FIRST_MATCHING("firstMatching");

    /**
     * The actual serialized value for a ScoringFunctionAggregation instance.
     */
    private String value;

    ScoringFunctionAggregation(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a ScoringFunctionAggregation instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed ScoringFunctionAggregation object, or null if unable to parse.
     */
    @JsonCreator
    public static ScoringFunctionAggregation fromString(String value) {
        ScoringFunctionAggregation[] items = ScoringFunctionAggregation.values();
        for (ScoringFunctionAggregation item : items) {
            if (item.toString().equalsIgnoreCase(value)) {
                return item;
            }
        }
        return null;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}