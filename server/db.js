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

con.connect(function(err){
    if(err){
        console.log('Error connecting to Db' + err);
        return;
    }
    console.log('Connection established');
});

module.exports = {
    saveLaunch: function (launch) {
        var parsedLaunch = parselaunch(launch);
        con.query('INSERT INTO launches.launch SET ?', parsedLaunch, function(err,res){
            if(err) throw err;

            console.log('Last insert ID:', res.insertId);
        });
    }
}

//TODO TW: Not sure that saving '' is the right choice when something isn't there.
function parselaunch(launch){
    return {"id": launch.id,
        "name":"'"+launch.name+"'",
        "isostart":"'"+launch.isostart+"'",
        "isoend":"'"+launch.isoend+"'",
        "isonet":"'"+launch.isonet+"'",
        "status":launch.status,
        "tbddate":launch.tbddate,
        "probability":launch.probability,
        "inhold":launch.inhold,
        "vidURLs":"'"+launch.vidURLs+"'",
        "infoURLs":"'"+launch.infoURLs+"'",
        "holdreason":"'"+launch.holdreason+"'",
        "failreason":"'"+launch.failreason+"'",
        "hashtag":"'"+launch.hashtag+"'"};
}