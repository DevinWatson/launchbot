var mysql = require("mysql");

var PropertiesReader = require('properties-reader');
var properties = PropertiesReader('../resources/properties.ini');
userName = properties.get('main.mysql.db.user.name');
password = properties.get('main.mysql.db.password');
hostIn = properties.get('main.mysql.db.host');

var con = mysql.createConnection({
    host: hostIn,
    user: userName,
    password: password
});

con.connect(function (err) {
    if (err) {
        console.log('Error connecting to Db' + err);
        return;
    }
    console.log('Connection established');
});

module.exports = {
    saveLaunch: function (launch) {
        con.query('INSERT INTO launches.launch SET ?', parselaunch(launch), function (err, res) {
            if (err) throw err;

            console.log('Last insert ID:', res.insertId);
        });
    }

}

function STR_TO_DATE(dateString) {
    return new Date(dateString).toISOString().substring(0, 19).replace('T', ' ');
}

//TODO TW: Not sure that saving '' is the right choice when something isn't there.
function parselaunch(launch) {
    return {
        "id": launch.id,
        "name": "'" + launch.name + "'",
        "isostart": (STR_TO_DATE(launch.windowstart, '%Y%m%dT%H%i%fZ')),
        "isoend": (STR_TO_DATE(launch.windowend, '%Y%m%dT%H%i%fZ')),
        "isonet": (STR_TO_DATE(launch.net, '%Y%m%dT%H%i%fZ')),
        "status": launch.status,
        "tbddate": launch.tbddate,
        "probability": launch.probability,
        "inhold": launch.inhold,
        "vidURLs": "'" + launch.vidURLs + "'",
        "infoURLs": "'" + launch.infoURLs + "'",
        "holdreason": "'" + launch.holdreason + "'",
        "failreason": "'" + launch.failreason + "'",
        "hashtag": "'" + launch.hashtag + "'"
    };
}