package com.eccff.launchbot.repositories;

import java.util.List;

import com.eccff.launchbot.models.MissionType;
import org.springframework.data.repository.CrudRepository;

public interface MissionTypeRepository extends CrudRepository<MissionType, Integer> {

    List<MissionType> findByName(String name);
}