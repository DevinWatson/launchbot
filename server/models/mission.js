"use strict";

class Mission {

    constructor (id, name, description, launch, type, wikiURL, infoURLs, agencies, events) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.launch = launch;
        this.type = type;
        this.wikiURL = wikiURL;
        this.infoURLs = infoURLs;
        this.agencies = agencies;
        this.events = events;
    }

    static fromJSON (json) {
        let x = JSON.parse(json);
        return new Mission(x.id, x.name, x.description, x.launch, x.type, x.wikiURL, x.infoURLs, x.agencies, x.events)
    }
}