package com.eccff.launchbot.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Builder
public class Mission {

    @Id
    private Long id;
    private String name;
    private String description;
    private String launch;
    private String type;
    private String wikiURL;
    private String infoURLs;
    private String agencies;
    private String events;

}
