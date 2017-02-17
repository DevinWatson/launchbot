package com.eccff.launchbot.repositories;

import java.util.List;

import com.eccff.launchbot.models.Agency;
import org.springframework.data.repository.CrudRepository;

public interface AgencyRepository extends CrudRepository<Agency, Integer> {

    List<Agency> findByName(String name);
}