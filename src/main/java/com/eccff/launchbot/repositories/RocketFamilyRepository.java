package com.eccff.launchbot.repositories;

import java.util.List;

import com.eccff.launchbot.models.RocketFamily;
import org.springframework.data.repository.CrudRepository;

public interface RocketFamilyRepository extends CrudRepository<RocketFamily, Integer> {

    List<RocketFamily> findByName(String name);
}