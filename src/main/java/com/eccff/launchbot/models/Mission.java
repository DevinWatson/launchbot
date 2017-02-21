package com.eccff.launchbot.models;

import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.List;

/**
 * https://launchlibrary.net/1.2/mission
 */

@Data
@Entity
public class Mission {

    public Mission() {}

    @Id
    private int id;
    private String name;
    private String description;
    @OneToOne
    private Launch launch;
    private int type;
    private String wikiURL;
    @ElementCollection(targetClass=String.class)
    private List<String> infoURLs;
    @ElementCollection(targetClass=Agency.class)
    private List<Agency> agencies;
    @ElementCollection(targetClass=MissionEvent.class)
    private List<MissionEvent> events;

}
