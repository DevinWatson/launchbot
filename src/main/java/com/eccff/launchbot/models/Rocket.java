package com.eccff.launchbot.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

/**
 * https://launchlibrary.net/1.2/rocket
 */

@Data
@Entity
public class Rocket {

    @Id
    private int id;
    private String name;
    private String defaultPads;
    @ManyToOne(optional = false)
    private RocketFamily family;
    private String wikiURL;
    @ElementCollection(targetClass=String.class)
    private List<String> infoURLs;
    private String imageURL;
    @ElementCollection(targetClass=Integer.class)
    private List<Integer> imageSizes;

}