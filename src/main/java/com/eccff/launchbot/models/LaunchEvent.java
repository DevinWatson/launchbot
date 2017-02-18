package com.eccff.launchbot.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * https://launchlibrary.net/1.2/launchevent
 */

@Data
@Entity
public class LaunchEvent {

    @Id
    private int id;
    private String name;
    private int relativeTime;
    private int type;
    private int duration;
    private int description;
    private int parentid;

}