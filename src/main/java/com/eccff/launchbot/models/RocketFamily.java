package com.eccff.launchbot.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

/**
 * https://launchlibrary.net/1.2/rocketfamily
 */

@Data
@Entity
public class RocketFamily {

    @Id
    private int id;
    private String name;
    @ElementCollection(targetClass=Agency.class)
    private List<Agency> agencies;

}