package com.eccff.launchbot.controllers;

import com.eccff.launchbot.models.Mission;
import com.eccff.launchbot.repositories.MissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/mission")
public class MissionController {

    @Autowired
    private MissionRepository missionRepository;

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity create(@RequestBody Mission mission) {
        missionRepository.save(mission);

        return ResponseEntity.ok().build();
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Mission>> listAllMissions() {
        List<Mission> missions = (List<Mission>)missionRepository.findAll();
        return new ResponseEntity<>(missions, HttpStatus.OK);
    }

}
