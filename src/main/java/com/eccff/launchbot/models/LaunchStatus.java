package com.eccff.launchbot.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Builder
public class LaunchStatus {

    @Id
    private int id;
    private String name;
    private String description;

}