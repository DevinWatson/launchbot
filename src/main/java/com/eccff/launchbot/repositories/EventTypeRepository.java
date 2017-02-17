package com.eccff.launchbot.repositories;

import java.util.List;

import com.eccff.launchbot.models.EventType;
import org.springframework.data.repository.CrudRepository;

public interface EventTypeRepository extends CrudRepository<EventType, Integer> {

    List<EventType> findByName(String name);
}