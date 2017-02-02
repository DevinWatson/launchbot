"use strict";

var http = require('http');
var https = require('https');
var slackService = require('./slack');
//Create a server
var server = http.createServer(function (request, res) {
    // Set CORS headers
    res.setHeader('Access-Control-Allow-Origin', '*');
    res.setHeader('Access-Control-Request-Method', '*');
    res.setHeader('Access-Control-Allow-Methods', 'OPTIONS, GET');
    res.setHeader('Access-Control-Allow-Headers', '*');

    // console.log(slackService.sendMessage("Test"));
    // response = slackService.sendMessage("Test");
    test();
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

function test(){

        var options = {
        host: 'launchlibrary.net',
        // port: 80,
        path: '/1.2/launch',
        method: 'GET',
        headers: {
            "Accept":"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
            "Accept-Encoding": "gzip, deflate, sdch, br",
            "Accept-Language": "en-US,en;q=0.8",
            "Cache-Control":"no-cache",
            "Connection":"keep-alive",
            "Host":"launchlibrary.net",
            "Pragma":"no-cache",
            "Upgrade-Insecure-Requests":"1"
        }
    };

    http.get(options, (res) => {
        const statusCode = res.statusCode;
        const contentType = res.headers['content-type'];

        let error;
        if (statusCode !== 200) {
            error = new Error(`Request Failed.\n` +
                `Status Code: ${statusCode}`);
        } else if (!/^application\/json/.test(contentType)) {
            error = new Error(`Invalid content-type.\n` +
                `Expected application/json but received ${contentType}`);
        }
        if (error) {
            console.log(error.message);
            // consume response data to free up memory
            res.resume();
            return;
        }

        res.setEncoding('utf8');
        let rawData = '';
        res.on('data', (chunk) => rawData += chunk);
        res.on('end', () => {
            try {
                let parsedData = JSON.parse(rawData);
                console.log(parsedData);
            } catch (e) {
                console.log(e.message);
            }
        });
    }).on('error', (e) => {
        console.log(`Got error: ${e.message}`);
    });
}

// function getData(callback) {
//
//     var req = http.request(options, function(res) {
//         console.log(res.statusCode);
//         res.on('data', function(d) {
//             process.stdout.write(d);
//         });
//     });
//     req.end();
//
//     req.on('error', function(e) {
//         console.error(e);
//     });
// }