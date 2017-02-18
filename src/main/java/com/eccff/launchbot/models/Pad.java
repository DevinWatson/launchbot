package com.eccff.launchbot.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

/**
 * https://launchlibrary.net/1.2/pad
 */


@Data
@Entity
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
    @ElementCollection(targetClass=Agency.class)
    private List<Agency> agencies;
    private String wikiURL;
    @ElementCollection(targetClass=String.class)
    private List<String> infoURLs;

}