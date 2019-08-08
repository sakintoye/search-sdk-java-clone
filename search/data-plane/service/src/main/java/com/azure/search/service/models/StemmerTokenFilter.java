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
 * Language specific stemming filter. This token filter is implemented using
 * Apache Lucene.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@odata\\.type")
@JsonTypeName("#Microsoft.Azure.Search.StemmerTokenFilter")
public class StemmerTokenFilter extends TokenFilter {
    /**
     * The language to use. Possible values include: 'arabic', 'armenian',
     * 'basque', 'brazilian', 'bulgarian', 'catalan', 'czech', 'danish',
     * 'dutch', 'dutchKp', 'english', 'lightEnglish', 'minimalEnglish',
     * 'possessiveEnglish', 'porter2', 'lovins', 'finnish', 'lightFinnish',
     * 'french', 'lightFrench', 'minimalFrench', 'galician', 'minimalGalician',
     * 'german', 'german2', 'lightGerman', 'minimalGerman', 'greek', 'hindi',
     * 'hungarian', 'lightHungarian', 'indonesian', 'irish', 'italian',
     * 'lightItalian', 'sorani', 'latvian', 'norwegian', 'lightNorwegian',
     * 'minimalNorwegian', 'lightNynorsk', 'minimalNynorsk', 'portuguese',
     * 'lightPortuguese', 'minimalPortuguese', 'portugueseRslp', 'romanian',
     * 'russian', 'lightRussian', 'spanish', 'lightSpanish', 'swedish',
     * 'lightSwedish', 'turkish'.
     */
    @JsonProperty(value = "language", required = true)
    private StemmerTokenFilterLanguage language;

    /**
     * Get the language to use. Possible values include: 'arabic', 'armenian', 'basque', 'brazilian', 'bulgarian',
     * 'catalan', 'czech', 'danish', 'dutch', 'dutchKp', 'english', 'lightEnglish', 'minimalEnglish',
     * 'possessiveEnglish', 'porter2', 'lovins', 'finnish', 'lightFinnish', 'french', 'lightFrench', 'minimalFrench',
     * 'galician', 'minimalGalician', 'german', 'german2', 'lightGerman', 'minimalGerman', 'greek', 'hindi',
     * 'hungarian', 'lightHungarian', 'indonesian', 'irish', 'italian', 'lightItalian', 'sorani', 'latvian',
     * 'norwegian', 'lightNorwegian', 'minimalNorwegian', 'lightNynorsk', 'minimalNynorsk', 'portuguese',
     * 'lightPortuguese', 'minimalPortuguese', 'portugueseRslp', 'romanian', 'russian', 'lightRussian', 'spanish',
     * 'lightSpanish', 'swedish', 'lightSwedish', 'turkish'.
     *
     * @return the language value
     */
    public StemmerTokenFilterLanguage language() {
        return this.language;
    }

    /**
     * Set the language to use. Possible values include: 'arabic', 'armenian', 'basque', 'brazilian', 'bulgarian',
     * 'catalan', 'czech', 'danish', 'dutch', 'dutchKp', 'english', 'lightEnglish', 'minimalEnglish',
     * 'possessiveEnglish', 'porter2', 'lovins', 'finnish', 'lightFinnish', 'french', 'lightFrench', 'minimalFrench',
     * 'galician', 'minimalGalician', 'german', 'german2', 'lightGerman', 'minimalGerman', 'greek', 'hindi',
     * 'hungarian', 'lightHungarian', 'indonesian', 'irish', 'italian', 'lightItalian', 'sorani', 'latvian',
     * 'norwegian', 'lightNorwegian', 'minimalNorwegian', 'lightNynorsk', 'minimalNynorsk', 'portuguese',
     * 'lightPortuguese', 'minimalPortuguese', 'portugueseRslp', 'romanian', 'russian', 'lightRussian', 'spanish',
     * 'lightSpanish', 'swedish', 'lightSwedish', 'turkish'.
     *
     * @param language the language value to set
     * @return the StemmerTokenFilter object itself.
     */
    public StemmerTokenFilter withLanguage(StemmerTokenFilterLanguage language) {
        this.language = language;
        return this;
    }

}