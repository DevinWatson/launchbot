package com.eccff.launchbot.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

/**
 * https://launchlibrary.net/1.2/agency
 */

@Data
@Entity
public class Agency {

    @Id
    private int id;
    private String name;
    private String abbrev;
    private int type;
    @Column(length=512) // Necessary for potential long list of country codes
    private String countryCode;
    private String wikiURL;
    @ElementCollection(targetClass=String.class)
    private List<String> infoURLs;

}
