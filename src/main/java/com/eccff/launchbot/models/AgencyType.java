package com.eccff.launchbot.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * https://launchlibrary.net/1.2/agencytype
 */

@Data
@Entity
public class AgencyType {

    @Id
    private int id;
    private String name;

}
