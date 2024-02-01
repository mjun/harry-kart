package com.ericsson.harrykart.service;

import com.ericsson.harrykart.model.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class HarryKartServiceImpl implements HarryKartService {

    private static final double RACE_LENGTH = 1000.0;

    @Override
    public List<Result> getRaceResults(HarryKart race) {
        // helper map to track times
        Map<String, Double> participantTimes = new HashMap<>();

        // Iterate `numberOfLoop` times, starting from 1
        Stream.iterate(1, n -> n + 1).limit(race.getNumberOfLoops()).forEach(currentLoopNumber -> {
            race.getStartList().forEach(participant -> {
                calculateParticipantTime(participant, participantTimes);
                applyPowerUps(participant, currentLoopNumber, race.getPowerUps());
            });
        });

        // add top three results
        AtomicInteger position = new AtomicInteger(1);
        return participantTimes.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(3)
                .map(r -> new Result(position.getAndIncrement(), r.getKey(), r.getValue()))
                .collect(Collectors.toList());
    }

    private void calculateParticipantTime(Participant participant, Map<String, Double> participantTimes) {
        if (!participantTimes.containsKey(participant.getName())) {
            participantTimes.put(participant.getName(), 0.0);
        }

        if (participant.getBaseSpeed() <= 0) {
            // horse is last place, did not finish
            participantTimes.put(
                    participant.getName(),
                    participantTimes.get(participant.getName()) + Double.MAX_VALUE);
        } else {
            participantTimes.put(
                    participant.getName(),
                    participantTimes.get(participant.getName()) + (RACE_LENGTH /participant.getBaseSpeed()));
        }
    }

    private void applyPowerUps(Participant participant, int currentLoopNumber, List<Loop> powerUps) {
        for (Loop loopPowerUps : powerUps) {
            for (Lane lane : loopPowerUps.getLanes()) {
                if (lane.getNumber() == participant.getLane() && loopPowerUps.getNumber() == currentLoopNumber) {
                    participant.applyPowerUp(lane.getPowerUp());
                }
            }
        }
    }

}
