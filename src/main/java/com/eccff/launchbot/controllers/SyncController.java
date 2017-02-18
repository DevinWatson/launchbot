package com.eccff.launchbot.controllers;

import com.eccff.launchbot.services.sync.LaunchLibrarySync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SyncController {

    @Autowired
    public LaunchLibrarySync launchLibrarySync;

    @RequestMapping("/sync")
    public ResponseEntity sync() {

        launchLibrarySync.sync();

        return ResponseEntity.ok().build();
    }

}
