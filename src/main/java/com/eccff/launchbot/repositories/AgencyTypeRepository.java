package com.eccff.launchbot.repositories;

import java.util.List;

import com.eccff.launchbot.models.AgencyType;
import org.springframework.data.repository.CrudRepository;

public interface AgencyTypeRepository extends CrudRepository<AgencyType, Integer> {

    List<AgencyType> findByName(String name);
}