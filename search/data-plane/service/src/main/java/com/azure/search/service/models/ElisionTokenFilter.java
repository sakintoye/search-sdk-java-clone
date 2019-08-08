/**
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.azure.search.service.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.List;

/**
 * Removes elisions. For example, "l'avion" (the plane) will be converted to
 * "avion" (plane). This token filter is implemented using Apache Lucene.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@odata\\.type")
@JsonTypeName("#Microsoft.Azure.Search.ElisionTokenFilter")
public class ElisionTokenFilter extends TokenFilter {
    /**
     * The set of articles to remove.
     */
    @JsonProperty(value = "articles")
    private List<String> articles;

    /**
     * Get the set of articles to remove.
     *
     * @return the articles value
     */
    public List<String> articles() {
        return this.articles;
    }

    /**
     * Set the set of articles to remove.
     *
     * @param articles the articles value to set
     * @return the ElisionTokenFilter object itself.
     */
    public ElisionTokenFilter withArticles(List<String> articles) {
        this.articles = articles;
        return this;
    }

}