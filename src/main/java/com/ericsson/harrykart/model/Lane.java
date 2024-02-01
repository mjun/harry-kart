package com.ericsson.harrykart.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Data;

@Data
public class Lane {

    @JacksonXmlProperty(isAttribute = true)
    private int number;

    @JacksonXmlText
    private int powerUp;

}
