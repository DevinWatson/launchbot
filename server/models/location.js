"use strict";

class Location {

    constructor (id, name, countrycode, wikiURL, infoURLs) {
        this.id = id;
        this.name = name;
        this.countrycode = countrycode;
        this.wikiURL = wikiURL;
        this.infoURLs = infoURLs;
    }

    static fromJSON (json) {
        let x = JSON.parse(json);
        return new Location(x.id, x.name, x.countrycode, x.wikiURL, x.infoURLs)
    }
}