package com.eccff.launchbot.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
@Builder
public class Mission {

    @Id
    private int id;
    private String name;
    private String description;
    private int launch;
    private int type;
    private String wikiURL;
    private List<String> infoURLs;
    private List<Agency> agencies;
    private List<MissionEvent> events;

}
