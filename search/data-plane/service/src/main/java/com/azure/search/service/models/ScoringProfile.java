/**
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.azure.search.service.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Defines parameters for an Azure Search index that influence scoring in
 * search queries.
 */
public class ScoringProfile {
    /**
     * The name of the scoring profile.
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    /**
     * Parameters that boost scoring based on text matches in certain index
     * fields.
     */
    @JsonProperty(value = "text")
    private TextWeights textWeights;

    /**
     * The collection of functions that influence the scoring of documents.
     */
    @JsonProperty(value = "functions")
    private List<ScoringFunction> functions;

    /**
     * A value indicating how the results of individual scoring functions
     * should be combined. Defaults to "Sum". Ignored if there are no scoring
     * functions. Possible values include: 'sum', 'average', 'minimum',
     * 'maximum', 'firstMatching'.
     */
    @JsonProperty(value = "functionAggregation")
    private ScoringFunctionAggregation functionAggregation;

    /**
     * Get the name of the scoring profile.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name of the scoring profile.
     *
     * @param name the name value to set
     * @return the ScoringProfile object itself.
     */
    public ScoringProfile withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get parameters that boost scoring based on text matches in certain index fields.
     *
     * @return the textWeights value
     */
    public TextWeights textWeights() {
        return this.textWeights;
    }

    /**
     * Set parameters that boost scoring based on text matches in certain index fields.
     *
     * @param textWeights the textWeights value to set
     * @return the ScoringProfile object itself.
     */
    public ScoringProfile withTextWeights(TextWeights textWeights) {
        this.textWeights = textWeights;
        return this;
    }

    /**
     * Get the collection of functions that influence the scoring of documents.
     *
     * @return the functions value
     */
    public List<ScoringFunction> functions() {
        return this.functions;
    }

    /**
     * Set the collection of functions that influence the scoring of documents.
     *
     * @param functions the functions value to set
     * @return the ScoringProfile object itself.
     */
    public ScoringProfile withFunctions(List<ScoringFunction> functions) {
        this.functions = functions;
        return this;
    }

    /**
     * Get a value indicating how the results of individual scoring functions should be combined. Defaults to "Sum".
     * Ignored if there are no scoring functions. Possible values include: 'sum', 'average', 'minimum', 'maximum',
     * 'firstMatching'.
     *
     * @return the functionAggregation value
     */
    public ScoringFunctionAggregation functionAggregation() {
        return this.functionAggregation;
    }

    /**
     * Set a value indicating how the results of individual scoring functions should be combined. Defaults to "Sum".
     * Ignored if there are no scoring functions. Possible values include: 'sum', 'average', 'minimum', 'maximum',
     * 'firstMatching'.
     *
     * @param functionAggregation the functionAggregation value to set
     * @return the ScoringProfile object itself.
     */
    public ScoringProfile withFunctionAggregation(ScoringFunctionAggregation functionAggregation) {
        this.functionAggregation = functionAggregation;
        return this;
    }

}