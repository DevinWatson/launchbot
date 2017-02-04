
var db = require('./db');
var http = require('./http');
var basePath = "/1.2/launch";

function fetchAndSaveLaunchData(path) {
    return http.httpGet(path).then(function (response) {
        db.saveLaunch(response.launches[0]);
    }, function (error) {
        console.error("Failed getting launch data for launch " + launches[i].id, error);
    });
}


function createPromiseArray(launches) {
    var promiseArray = [];

    for (var i = 0, len = launches.length; i < len; i++) {
        var path = basePath + "/" + launches[i].id;
        promiseArray.push(fetchAndSaveLaunchData(path));
    }
    return promiseArray;
}

http.httpGet(basePath).then(function(response) {
    return response.launches;
}, function(error) {
    console.error("Failed!", error);
}). then(function (launches) {
    var promiseArray = createPromiseArray(launches);
    return Promise.all(promiseArray);
}, function (error) {
    console.error("Failed!", error);
}).catch(function (error) {
    console.error("Failed, in catch.", error);
});