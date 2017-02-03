
// var mysql = require("mysql");
var http = require('./http');

var basePath = "/1.2/launch";
http.httpGet(basePath).then(function(response) {
    return response.launches;
}, function(error) {
    console.error("Failed!", error);
}). then(function (launches) {
    for (var i = 0, len = launches.length; i < len; i++) {
        console.log("I: " + i + launches[i].toString() + "\n");
        http.httpGet(basePath+"/"+launches[i].id).then(function (response) {
            console.log("Response: " + response + "\n");
        }, function (error) {
            console.error("Failed here!", error);
        });
    }
}).catch(function (error) {
    console.error("Failed, in catch!", error);
});