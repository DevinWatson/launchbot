package com.eccff.launchbot.repositories;

import java.util.List;

import com.eccff.launchbot.models.LaunchEvent;
import org.springframework.data.repository.CrudRepository;

public interface LaunchEventRepository extends CrudRepository<LaunchEvent, Integer> {

    List<LaunchEvent> findByName(String name);
}