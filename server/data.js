
var db = require('./db');
var http = require('./http');

var basePath = "/1.2/launch";
http.httpGet(basePath).then(function(response) {
    return response.launches;
}, function(error) {
    console.error("Failed!", error);
}). then(function (launches) {
    for (var i = 0, len = launches.length; i < len; i++) {
        var path = basePath+"/"+launches[i].id;
        http.httpGet(path).then(function (response) {
            db.saveLaunch(response.launches[0]);
        }, function (error) {
            console.error("Failed getting launch data for launch " + launches[i].id, error);
        });
    }
}).catch(function (error) {
    console.error("Failed, in catch.", error);
});