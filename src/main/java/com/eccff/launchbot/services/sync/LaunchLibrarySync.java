package com.eccff.launchbot.services.sync;

import com.eccff.launchbot.ServerApplication;
import com.eccff.launchbot.models.*;
import com.eccff.launchbot.repositories.*;
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
    AgencyTypeRepository agencyTypeRepository;
    @Autowired
    EventTypeRepository eventTypeRepository;
    @Autowired
    LaunchRepository launchRepository;
    @Autowired
    LaunchStatusRepository launchStatusRepository;
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    MissionRepository missionRepository;
    @Autowired
    MissionTypeRepository missionTypeRepository;
    @Autowired
    PadRepository padRepository;
    @Autowired
    RocketFamilyRepository rocketFamilyRepository;
    @Autowired
    RocketRepository rocketRepository;
    @Autowired
    ObjectMapper objectMapper;

    public void sync() {
        syncAgencies(0);
        syncAgencyTypes(0);
        syncEventTypes(0);
        syncLaunches(0);
        syncLaunchStatuses(0);
        syncLocations(0);
        syncMissions(0);
        syncMissionTypes(0);
        syncPads(0);
        syncRocketFamilies(0);
        syncRockets(0);
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

    private void syncAgencyTypes(int offset) {
        HashMap agencyTypePayload = restTemplate.getForObject(LAUNCH_LIBRARY_URL + "agencytype?mode=verbose&offset=" + offset, HashMap.class);
        List<AgencyType> agencyTypes = objectMapper.convertValue(agencyTypePayload.get("types"), new TypeReference<List<AgencyType>>() { });
        agencyTypeRepository.save(agencyTypes);
        offset = offset + (int)agencyTypePayload.get("count");
        if(offset != (int)agencyTypePayload.get("total")) {
            syncAgencyTypes(offset);
        } else {
            log.info("done syncing agency types");
        }
    }

    private void syncEventTypes(int offset) {
        HashMap eventTypePayload = restTemplate.getForObject(LAUNCH_LIBRARY_URL + "eventtype?mode=verbose&offset=" + offset, HashMap.class);
        List<EventType> eventTypes = objectMapper.convertValue(eventTypePayload.get("types"), new TypeReference<List<EventType>>() { });
        eventTypeRepository.save(eventTypes);
        offset = offset + (int)eventTypePayload.get("count");
        if(offset != (int)eventTypePayload.get("total")) {
            syncEventTypes(offset);
        } else {
            log.info("done syncing event types");
        }
    }

    // TODO: Launch events need to be synced manually by ID

    private void syncLaunches(int offset) {
        HashMap launchPayload = restTemplate.getForObject(LAUNCH_LIBRARY_URL + "launch?mode=verbose&offset=" + offset, HashMap.class);
        List<Launch> launches = objectMapper.convertValue(launchPayload.get("launches"), new TypeReference<List<Launch>>() { });
        launchRepository.save(launches);
        offset = offset + (int)launchPayload.get("count");
        if(offset != (int)launchPayload.get("total")) {
            syncLaunches(offset);
        } else {
            log.info("done syncing launches");
        }
    }

    private void syncLaunchStatuses(int offset) {
        HashMap launchStatusPayload = restTemplate.getForObject(LAUNCH_LIBRARY_URL + "launchstatus?mode=verbose&offset=" + offset, HashMap.class);
        List<LaunchStatus> launchStatuses = objectMapper.convertValue(launchStatusPayload.get("types"), new TypeReference<List<LaunchStatus>>() { });
        launchStatusRepository.save(launchStatuses);
        offset = offset + (int)launchStatusPayload.get("count");
        if(offset != (int)launchStatusPayload.get("total")) {
            syncLaunchStatuses(offset);
        } else {
            log.info("done syncing launch statuses");
        }
    }

    private void syncLocations(int offset) {
        HashMap locationPayload = restTemplate.getForObject(LAUNCH_LIBRARY_URL + "location?mode=verbose&offset=" + offset, HashMap.class);
        List<Location> locations = objectMapper.convertValue(locationPayload.get("locations"), new TypeReference<List<Location>>() { });
        locationRepository.save(locations);
        offset = offset + (int)locationPayload.get("count");
        if(offset != (int)locationPayload.get("total")) {
            syncLocations(offset);
        } else {
            log.info("done syncing locations");
        }
    }

    // TODO: Mission events need to be synced manually by ID

    private void syncMissions(int offset) {
        HashMap missionPayload = restTemplate.getForObject(LAUNCH_LIBRARY_URL + "mission?mode=verbose&offset=" + offset, HashMap.class);
        List<Mission> missions = objectMapper.convertValue(missionPayload.get("missions"), new TypeReference<List<Mission>>() { });
        missionRepository.save(missions);
        offset = offset + (int)missionPayload.get("count");
        if(offset != (int)missionPayload.get("total")) {
            syncMissions(offset);
        } else {
            log.info("done syncing missions");
        }
    }

    private void syncMissionTypes(int offset) {
        HashMap missionTypePayload = restTemplate.getForObject(LAUNCH_LIBRARY_URL + "missiontype?mode=verbose&offset=" + offset, HashMap.class);
        List<MissionType> missionTypes = objectMapper.convertValue(missionTypePayload.get("types"), new TypeReference<List<MissionType>>() { });
        missionTypeRepository.save(missionTypes);
        offset = offset + (int)missionTypePayload.get("count");
        if(offset != (int)missionTypePayload.get("total")) {
            syncMissionTypes(offset);
        } else {
            log.info("done syncing mission types");
        }
    }

    private void syncPads(int offset) {
        HashMap padPayload = restTemplate.getForObject(LAUNCH_LIBRARY_URL + "pad?mode=verbose&offset=" + offset, HashMap.class);
        List<Pad> pads = objectMapper.convertValue(padPayload.get("pads"), new TypeReference<List<Pad>>() { });
        padRepository.save(pads);
        offset = offset + (int)padPayload.get("count");
        if(offset != (int)padPayload.get("total")) {
            syncMissionTypes(offset);
        } else {
            log.info("done syncing pads");
        }
    }

    // TODO: Rocket events need to be synced manually by ID

    private void syncRocketFamilies(int offset) {
        HashMap rocketFamilyPayload = restTemplate.getForObject(LAUNCH_LIBRARY_URL + "rocketfamily?mode=verbose&offset=" + offset, HashMap.class);
        List<RocketFamily> rocketFamilies = objectMapper.convertValue(rocketFamilyPayload.get("RocketFamilies"), new TypeReference<List<RocketFamily>>() { });
        rocketFamilyRepository.save(rocketFamilies);
        offset = offset + (int)rocketFamilyPayload.get("count");
        if(offset != (int)rocketFamilyPayload.get("total")) {
            syncMissionTypes(offset);
        } else {
            log.info("done syncing rocket families");
        }
    }

    private void syncRockets(int offset) {
        HashMap rocketPayload = restTemplate.getForObject(LAUNCH_LIBRARY_URL + "rocketfamily?mode=verbose&offset=" + offset, HashMap.class);
        List<Rocket> rockets = objectMapper.convertValue(rocketPayload.get("rockets"), new TypeReference<List<Rocket>>() { });
        rocketRepository.save(rockets);
        offset = offset + (int)rocketPayload.get("count");
        if(offset != (int)rocketPayload.get("total")) {
            syncMissionTypes(offset);
        } else {
            log.info("done syncing rockets");
        }
    }
}
