package com.eccff.launchbot.repositories;

import java.util.List;

import com.eccff.launchbot.models.MissionEvent;
import org.springframework.data.repository.CrudRepository;

public interface MissionEventRepository extends CrudRepository<MissionEvent, Integer> {

    List<MissionEvent> findByName(String name);
}