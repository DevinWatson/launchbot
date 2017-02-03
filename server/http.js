"use strict";
var http = require('http');


module.exports = {
    httpGet: function(path) {
        // Return a new promise.
        return new Promise(function(resolve, reject) {
            console.log(path);

            var options = {
                host: 'launchlibrary.net',
                path: path,
                method: 'GET',
                headers: {
                    "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
                    "Accept-Encoding": "gzip, deflate, sdch, br",
                    "Accept-Language": "en-US,en;q=0.8",
                    "Cache-Control": "no-cache",
                    "Connection": "keep-alive",
                    "Host": "launchlibrary.net",
                    "Pragma": "no-cache",
                    "Upgrade-Insecure-Requests": "1",
                    "User-Agent": "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36"
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
                    reject(Error(error));
                    return;
                }

                res.setEncoding('utf8');
                let rawData = '';
                res.on('data', (chunk) => rawData += chunk);
                res.on('end', () => {
                    try {
                        resolve(JSON.parse(rawData));
                    } catch (e) {
                        console.log(e.message);
                        reject(Error(e));
                    }
                });
            }).on('error', (e) => {
                console.log(`Got error: ${e.message}`);
                reject(Error(e));
            });
        });
    }
}