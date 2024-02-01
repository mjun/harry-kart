package com.ericsson.harrykart.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.util.List;

@Data
@JacksonXmlRootElement(localName = "harryKart")
public class HarryKart {

    private int numberOfLoops;

    private List<Participant> startList;

    private List<Loop> powerUps;

}
