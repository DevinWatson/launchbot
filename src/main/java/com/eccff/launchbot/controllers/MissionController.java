package com.eccff.launchbot.controllers;

import com.eccff.launchbot.models.Mission;
import com.eccff.launchbot.repositories.MissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MissionController {

    @Autowired
    private MissionRepository missionRepository;


    @RequestMapping("/create")
    @ResponseBody
    public String create() {
        Mission mission = new Mission();
        mission.setId(1);
        mission.setName("derp");
        missionRepository.save(mission);

        return "";
    }

}
