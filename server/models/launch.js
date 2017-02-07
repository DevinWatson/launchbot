const moment = require('moment');
"use strict";

class Launch {

    constructor (id, name, net, tbddate, tbdtime, status, windowstart, windowend, isostart, isoend, isonet,
                 wsstamp, westamp, netstamp, infoURLs, vidURLs, holdreason, failreason, probability, hashtag,
                 location, rocket, missions) {
        this.id = id;
        this.name = name;
        this.net = net;
        this.tbddate = tbddate;
        this.tbdtime = tbdtime;
        this.status = status;
        this.windowstart = windowstart;
        this.windowend = windowend;
        this.isostart = isostart;
        this.isoend = isoend;
        this.isonet = isonet;
        this.wsstamp = wsstamp;
        this.westamp = westamp;
        this.netstamp = netstamp;
        this.infoURLs = infoURLs;
        this.vidURLs = vidURLs;
        this.holdreason = holdreason;
        this.failreason = failreason;
        this.probability = probability;
        this.hashtag = hashtag;
        this.location = location;
        this.rocket = rocket;
        this.missions = missions;

    }

    static fromJSON (json) {
        let x = JSON.parse(json);
        let tbddate = !!x.tbddate;
        let tbdtime = !!x.tbdtime;
        let isostart = tbddate ? null : moment.utc(x.isostart);
        let isoend = tbddate ? null : moment.utc(x.isoend);
        let isonet = tbddate ? null : moment.utc(x.isonet);
        let wsstamp = tbddate ? null : moment.utc(x.wsstamp, 'x');
        let westamp = tbddate ? null : moment.utc(x.westamp, 'x');
        let netstamp = tbddate ? null : moment.utc(x.netstamp, 'x');
        let location = Location.fromJSON(x.location);
        let rocket = Rocket.fromJSON(x.rocket);
        let missions = Mission.fromJSON(x.missions);

        return new Launch(x.id, x.name, x.net, tbddate, tbdtime, x.status, x.windowstart, x.windowend, isostart, isoend,
            isonet, wsstamp, westamp, netstamp, x.vidURLs, x.infoURLs, x.holdreason, x.failreason, x.probability, x.hashtag,
            location, rocket, missions)
    }
}