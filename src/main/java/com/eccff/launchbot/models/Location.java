package com.eccff.launchbot.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
@Builder
public class Location {

    @Id
    private int id;
    private String name;
    private String countrycode;
    private String wikiURL;
    private List<String> infoURLs;

}