package com.eccff.launchbot.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

/**
 * https://launchlibrary.net/1.2/agency
 */

@Data
@Entity
@Builder
public class Agency {

    @Id
    private int id;
    private String name;
    private String abbrev;
    private int type;
    private String countryCode;
    private String wikiURL;
    private List<String> infoURLs;

}
