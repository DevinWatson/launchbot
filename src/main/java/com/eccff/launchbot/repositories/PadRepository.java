package com.eccff.launchbot.repositories;

import java.util.List;

import com.eccff.launchbot.models.Pad;
import org.springframework.data.repository.CrudRepository;

public interface PadRepository extends CrudRepository<Pad, Integer> {

    List<Pad> findByName(String name);
}