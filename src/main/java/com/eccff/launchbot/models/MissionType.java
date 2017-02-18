package com.eccff.launchbot.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * https://launchlibrary.net/1.2/missiontype
 */

@Entity
@Data
public class MissionType {

    @Id
    private int id;
    private String name;

}
