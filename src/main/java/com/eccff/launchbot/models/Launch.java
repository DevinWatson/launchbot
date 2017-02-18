package com.eccff.launchbot.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.List;

/**
 * https://launchlibrary.net/1.2/launch
 */

@Data
@Entity
public class Launch {

    @Id
    private int id;
    private String name;
    private String net;
    private boolean tbddate;
    private boolean tbdtime;
    private int status;
    private String windowstart;
    private String windowend;
    private Date isostart;
    private Date isoend;
    private Date isonet;
    private int wsstamp;
    private int westamp;
    private int netstamp;
    @ElementCollection(targetClass=String.class)
    private List<String> infoURLs;
    @ElementCollection(targetClass=String.class)
    private List<String> vidURLs;
    private String holdreason;
    private String failreason;
    private int probability;
    private String hashtag;
    @ElementCollection(targetClass=Location.class)
    private List<Location> location;
    @OneToOne
    private Rocket rocket;
    @ElementCollection(targetClass=Mission.class)
    private List<Mission> missions;

}
