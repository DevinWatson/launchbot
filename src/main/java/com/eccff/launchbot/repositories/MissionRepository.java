package com.eccff.launchbot.repositories;

import java.util.List;

import com.eccff.launchbot.models.Mission;
import org.springframework.data.repository.CrudRepository;

public interface MissionRepository extends CrudRepository<Mission, Integer> {

    List<Mission> findByName(String name);
}