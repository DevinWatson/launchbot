package com.eccff.launchbot.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Builder
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
    private List<String> infoURLs;
    private List<String> vidURLs;
    private String holdreason;
    private String failreason;
    private int probability;
    private String hashtag;
    private List<Location> location;
    private Object rocket;
    private List<Mission> missions;

}
