package com.ericsson.harrykart.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "participant")
public class Participant {

    @JacksonXmlProperty
    private int lane;

    @JacksonXmlProperty
    private String name;

    @JacksonXmlProperty
    private int baseSpeed = 10;

    public void applyPowerUp(int value) {
        this.baseSpeed += value;
    }

}
