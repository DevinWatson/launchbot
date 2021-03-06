package com.eccff.launchbot.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

/**
 * https://launchlibrary.net/1.2/eventtype
 */

@Data
@Entity
public class EventType {

    @Id
    private int id;
    private String name;

}
