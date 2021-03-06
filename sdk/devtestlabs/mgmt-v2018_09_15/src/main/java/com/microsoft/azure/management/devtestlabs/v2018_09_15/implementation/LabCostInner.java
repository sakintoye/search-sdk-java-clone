/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.devtestlabs.v2018_09_15.implementation;

import com.microsoft.azure.management.devtestlabs.v2018_09_15.TargetCostProperties;
import com.microsoft.azure.management.devtestlabs.v2018_09_15.LabCostSummaryProperties;
import java.util.List;
import com.microsoft.azure.management.devtestlabs.v2018_09_15.LabCostDetailsProperties;
import com.microsoft.azure.management.devtestlabs.v2018_09_15.LabResourceCostProperties;
import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.rest.SkipParentValidation;
import com.microsoft.azure.Resource;

/**
 * A cost item.
 */
@JsonFlatten
@SkipParentValidation
public class LabCostInner extends Resource {
    /**
     * The target cost properties.
     */
    @JsonProperty(value = "properties.targetCost")
    private TargetCostProperties targetCost;

    /**
     * The lab cost summary component of the cost data.
     */
    @JsonProperty(value = "properties.labCostSummary", access = JsonProperty.Access.WRITE_ONLY)
    private LabCostSummaryProperties labCostSummary;

    /**
     * The lab cost details component of the cost data.
     */
    @JsonProperty(value = "properties.labCostDetails", access = JsonProperty.Access.WRITE_ONLY)
    private List<LabCostDetailsProperties> labCostDetails;

    /**
     * The resource cost component of the cost data.
     */
    @JsonProperty(value = "properties.resourceCosts", access = JsonProperty.Access.WRITE_ONLY)
    private List<LabResourceCostProperties> resourceCosts;

    /**
     * The currency code of the cost.
     */
    @JsonProperty(value = "properties.currencyCode")
    private String currencyCode;

    /**
     * The start time of the cost data.
     */
    @JsonProperty(value = "properties.startDateTime")
    private DateTime startDateTime;

    /**
     * The end time of the cost data.
     */
    @JsonProperty(value = "properties.endDateTime")
    private DateTime endDateTime;

    /**
     * The creation date of the cost.
     */
    @JsonProperty(value = "properties.createdDate")
    private DateTime createdDate;

    /**
     * The provisioning status of the resource.
     */
    @JsonProperty(value = "properties.provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private String provisioningState;

    /**
     * The unique immutable identifier of a resource (Guid).
     */
    @JsonProperty(value = "properties.uniqueIdentifier", access = JsonProperty.Access.WRITE_ONLY)
    private String uniqueIdentifier;

    /**
     * Get the target cost properties.
     *
     * @return the targetCost value
     */
    public TargetCostProperties targetCost() {
        return this.targetCost;
    }

    /**
     * Set the target cost properties.
     *
     * @param targetCost the targetCost value to set
     * @return the LabCostInner object itself.
     */
    public LabCostInner withTargetCost(TargetCostProperties targetCost) {
        this.targetCost = targetCost;
        return this;
    }

    /**
     * Get the lab cost summary component of the cost data.
     *
     * @return the labCostSummary value
     */
    public LabCostSummaryProperties labCostSummary() {
        return this.labCostSummary;
    }

    /**
     * Get the lab cost details component of the cost data.
     *
     * @return the labCostDetails value
     */
    public List<LabCostDetailsProperties> labCostDetails() {
        return this.labCostDetails;
    }

    /**
     * Get the resource cost component of the cost data.
     *
     * @return the resourceCosts value
     */
    public List<LabResourceCostProperties> resourceCosts() {
        return this.resourceCosts;
    }

    /**
     * Get the currency code of the cost.
     *
     * @return the currencyCode value
     */
    public String currencyCode() {
        return this.currencyCode;
    }

    /**
     * Set the currency code of the cost.
     *
     * @param currencyCode the currencyCode value to set
     * @return the LabCostInner object itself.
     */
    public LabCostInner withCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    /**
     * Get the start time of the cost data.
     *
     * @return the startDateTime value
     */
    public DateTime startDateTime() {
        return this.startDateTime;
    }

    /**
     * Set the start time of the cost data.
     *
     * @param startDateTime the startDateTime value to set
     * @return the LabCostInner object itself.
     */
    public LabCostInner withStartDateTime(DateTime startDateTime) {
        this.startDateTime = startDateTime;
        return this;
    }

    /**
     * Get the end time of the cost data.
     *
     * @return the endDateTime value
     */
    public DateTime endDateTime() {
        return this.endDateTime;
    }

    /**
     * Set the end time of the cost data.
     *
     * @param endDateTime the endDateTime value to set
     * @return the LabCostInner object itself.
     */
    public LabCostInner withEndDateTime(DateTime endDateTime) {
        this.endDateTime = endDateTime;
        return this;
    }

    /**
     * Get the creation date of the cost.
     *
     * @return the createdDate value
     */
    public DateTime createdDate() {
        return this.createdDate;
    }

    /**
     * Set the creation date of the cost.
     *
     * @param createdDate the createdDate value to set
     * @return the LabCostInner object itself.
     */
    public LabCostInner withCreatedDate(DateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    /**
     * Get the provisioning status of the resource.
     *
     * @return the provisioningState value
     */
    public String provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the unique immutable identifier of a resource (Guid).
     *
     * @return the uniqueIdentifier value
     */
    public String uniqueIdentifier() {
        return this.uniqueIdentifier;
    }

}
