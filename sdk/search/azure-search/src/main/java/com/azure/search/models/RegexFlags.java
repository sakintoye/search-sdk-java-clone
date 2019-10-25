// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.

package com.azure.search.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for RegexFlags.
 */
public enum RegexFlags {
    /**
     * Enum value CANON_EQ.
     */
    CANON_EQ("CANON_EQ"),

    /**
     * Enum value CASE_INSENSITIVE.
     */
    CASE_INSENSITIVE("CASE_INSENSITIVE"),

    /**
     * Enum value COMMENTS.
     */
    COMMENTS("COMMENTS"),

    /**
     * Enum value DOTALL.
     */
    DOTALL("DOTALL"),

    /**
     * Enum value LITERAL.
     */
    LITERAL("LITERAL"),

    /**
     * Enum value MULTILINE.
     */
    MULTILINE("MULTILINE"),

    /**
     * Enum value UNICODE_CASE.
     */
    UNICODE_CASE("UNICODE_CASE"),

    /**
     * Enum value UNIX_LINES.
     */
    UNIX_LINES("UNIX_LINES");

    /**
     * The actual serialized value for a RegexFlags instance.
     */
    private final String value;

    RegexFlags(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a RegexFlags instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed RegexFlags object, or null if unable to parse.
     */
    @JsonCreator
    public static RegexFlags fromString(String value) {
        RegexFlags[] items = RegexFlags.values();
        for (RegexFlags item : items) {
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