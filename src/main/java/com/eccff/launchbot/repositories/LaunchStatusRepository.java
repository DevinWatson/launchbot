package com.eccff.launchbot.repositories;

import java.util.List;

import com.eccff.launchbot.models.LaunchStatus;
import org.springframework.data.repository.CrudRepository;

public interface LaunchStatusRepository extends CrudRepository<LaunchStatus, Integer> {

    List<LaunchStatus> findByName(String name);
}