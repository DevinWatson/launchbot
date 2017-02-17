package com.eccff.launchbot.repositories;

import java.util.List;

import com.eccff.launchbot.models.RocketEvent;
import org.springframework.data.repository.CrudRepository;

public interface RocketEventRepository extends CrudRepository<RocketEvent, Integer> {

    List<RocketEvent> findByName(String name);
}