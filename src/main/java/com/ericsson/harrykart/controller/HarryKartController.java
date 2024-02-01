package com.ericsson.harrykart.controller;

import com.ericsson.harrykart.model.HarryKart;
import com.ericsson.harrykart.model.ResultWrapper;
import com.ericsson.harrykart.service.HarryKartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
public class HarryKartController {

    private final HarryKartService harryKartService;

    @RequestMapping(method = RequestMethod.POST, path = "/", consumes = "application/xml", produces = "application/xml")
    public ResultWrapper startRace(@RequestBody HarryKart input) {
        return new ResultWrapper(harryKartService.getRaceResults(input));
    }

}
