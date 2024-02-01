package com.ericsson.harrykart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result {

    private int position;

    private String horseName;

    @JsonIgnore
    private double time;

}
