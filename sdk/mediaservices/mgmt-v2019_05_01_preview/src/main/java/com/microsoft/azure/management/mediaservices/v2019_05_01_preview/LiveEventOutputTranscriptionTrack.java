/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.mediaservices.v2019_05_01_preview;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes a transcription track in the output of a Live Event, generated
 * using speech-to-text transcription.
 */
public class LiveEventOutputTranscriptionTrack {
    /**
     * The output track name.
     */
    @JsonProperty(value = "trackName", required = true)
    private String trackName;

    /**
     * Get the output track name.
     *
     * @return the trackName value
     */
    public String trackName() {
        return this.trackName;
    }

    /**
     * Set the output track name.
     *
     * @param trackName the trackName value to set
     * @return the LiveEventOutputTranscriptionTrack object itself.
     */
    public LiveEventOutputTranscriptionTrack withTrackName(String trackName) {
        this.trackName = trackName;
        return this;
    }

}
