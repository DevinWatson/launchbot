"use strict";

class Pad {

    constructor (id, name, padType, latitude, longitude, mapURL, retired, locationid, agencies, wikiURL, infoURLs) {
        this.id = id;
        this.name = name;
        this.padType = padType;
        this.latitude = latitude;
        this.longitude = longitude;
        this.mapURL = mapURL;
        this.retired = retired;
        this.locationid = locationid;
        this.agencies = agencies;
        this.wikiURL = wikiURL;
        this.infoURLs = infoURLs;
    }

    static fromJSON (json) {
        let x = JSON.parse(json);
        return new Pad(x.id, x.padType, x.latitude, x.longitude, x.mapURL, x.retired, x.locationid, x.agencies, x.wikiURL, x.infoURLs)
    }
}