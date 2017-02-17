package com.eccff.launchbot.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
@Builder
public class Pad {

    @Id
    private int id;
    private String name;
    private int padType;
    private String latitude;
    private String longitude;
    private String mapURL;
    private boolean retired;
    private int locationid;
    private List<Agency> agencies;
    private String wikiURL;
    private List<String> infoURLs;

}