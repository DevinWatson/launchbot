package com.eccff.launchbot.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Builder
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