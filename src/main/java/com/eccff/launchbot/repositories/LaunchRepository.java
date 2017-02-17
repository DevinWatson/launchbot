package com.eccff.launchbot.repositories;

import java.util.List;

import com.eccff.launchbot.models.Launch;
import org.springframework.data.repository.CrudRepository;

public interface LaunchRepository extends CrudRepository<Launch, Integer> {

    List<Launch> findByName(String name);
}