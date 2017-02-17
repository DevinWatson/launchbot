package com.eccff.launchbot.repositories;

import java.util.List;

import com.eccff.launchbot.models.Rocket;
import org.springframework.data.repository.CrudRepository;

public interface RocketRepository extends CrudRepository<Rocket, Integer> {

    List<Rocket> findByName(String name);
}