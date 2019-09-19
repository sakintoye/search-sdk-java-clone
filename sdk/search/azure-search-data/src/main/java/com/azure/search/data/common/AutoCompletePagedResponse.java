// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.search.data.common;

import com.azure.core.http.HttpHeaders;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.implementation.http.PagedResponseBase;
import com.azure.search.data.generated.models.AutocompleteItem;
import com.azure.search.data.generated.models.AutocompleteResult;

import java.util.stream.Collectors;

public class AutoCompletePagedResponse extends PagedResponseBase<String, AutocompleteItem> {

    /**
     * Constructor
     *
     * @param autoCompleteResponse an http response with the results
     */
    public AutoCompletePagedResponse(SimpleResponse<AutocompleteResult> autoCompleteResponse) {
        super(autoCompleteResponse.request(),
                autoCompleteResponse.statusCode(),
                autoCompleteResponse.headers(),
                autoCompleteResponse.value().results(),
            null,
            deserializeHeaders(autoCompleteResponse.headers()));
    }

    private static String deserializeHeaders(HttpHeaders headers) {
        return headers.toMap().entrySet().stream().map((entry) ->
            entry.getKey() + "," + entry.getValue()
        ).collect(Collectors.joining(","));
    }
}