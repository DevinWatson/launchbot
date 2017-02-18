package com.eccff.launchbot.services.sync;

import com.eccff.launchbot.ServerApplication;
import com.eccff.launchbot.models.Agency;
import com.eccff.launchbot.repositories.AgencyRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

@Component
public class LaunchLibrarySync {

    private static final Logger log = LoggerFactory.getLogger(ServerApplication.class);

    private static final String LAUNCH_LIBRARY_URL = "https://launchlibrary.net/1.2/";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    AgencyRepository agencyRepository;
    @Autowired
    ObjectMapper objectMapper;

    public void sync() {
        syncAgencies(0);
    }

    private void syncAgencies(int offset) {
        // Grab map of agencies
        HashMap agencyPayload = restTemplate.getForObject(LAUNCH_LIBRARY_URL + "agency?mode=verbose&offset=" + offset, HashMap.class);
        // Add new agencies to
        List<Agency> agencies = objectMapper.convertValue(agencyPayload.get("agencies"), new TypeReference<List<Agency>>() { });
        agencyRepository.save(agencies);
        // Set the offset for the next page
        offset = offset + (int)agencyPayload.get("count");
        // If the offset equals the count, we are done
        if(offset != (int)agencyPayload.get("total")) {
            // Otherwise call another page
            syncAgencies(offset);
        } else {
            log.info("done syncing agencies");
        }
    }

}
