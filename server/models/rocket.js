"use strict";

class Rocket {

    constructor (id, name, defaultPads, family, wikiURL, infoURLs, imageURL, imageSizes) {
        this.id = id;
        this.name = name;
        this.defaultPads = defaultPads;
        this.family = family;
        this.wikiURL = wikiURL;
        this.infoURLs = infoURLs;
        this.imageURL = imageURL;
        this.imageSizes = imageSizes;
    }

    static fromJSON (json) {
        let x = JSON.parse(json);
        return new Rocket(x.id, x.name, x.defaultPads, x.family, x.wikiURL, x.infoURLs, x.imageURL, x.imageSizes)
    }
}