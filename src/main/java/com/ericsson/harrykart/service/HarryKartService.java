package com.ericsson.harrykart.service;

import com.ericsson.harrykart.model.HarryKart;
import com.ericsson.harrykart.model.Result;

import java.util.List;

public interface HarryKartService {
    List<Result> getRaceResults(HarryKart race);

}
