package com.eccff.launchbot.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
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
    private String isostart;
    private String isoend;
    private String isonet;
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
//    @ElementCollection(targetClass=Pad.class)
    @OneToOne
    private Location location;
    @OneToOne
    private Rocket rocket;
    @ElementCollection(targetClass=Mission.class)
    private List<Mission> missions;

}
