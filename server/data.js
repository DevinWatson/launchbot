var http = require('http');
var slackService = require('./slack');
//Create a server
var server = http.createServer(function (request, res) {
    // Set CORS headers
    res.setHeader('Access-Control-Allow-Origin', '*');
    res.setHeader('Access-Control-Request-Method', '*');
    res.setHeader('Access-Control-Allow-Methods', 'OPTIONS, GET');
    res.setHeader('Access-Control-Allow-Headers', '*');
    console.log(slackService.sendMessage("Test"));
    // response = slackService.sendMessage("Test");
    res.end("hih");
    return res;

});
//Lets define a port we want to listen to
const PORT = 8080;
//Lets start our server
server.listen(PORT, function () {
    console.log("Server listening on: http://localhost:%s", PORT);

    console.log("Sending request to get new data")
    // slackService.sendMessage("test");
});