package com.eccff.launchbot.repositories;

import java.util.List;

import com.eccff.launchbot.models.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Integer> {

    List<Location> findByName(String name);
}