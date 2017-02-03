var Slack = require('slack-node');

var PropertiesReader = require('properties-reader');
var properties = PropertiesReader('../resources/properties.ini');
webhookUri = properties.get('main.slack.webhook.uri');

slack = new Slack();
slack.setWebhook(webhookUri);

module.exports = {
    sendMessage: function (message) {
        return slack.webhook({
            channel: "#general",
            username: "webhookbot",
            text: message
        }, function (err, response) {
            if (err) {
                // console.log("Error sending message: " + err + ". Response: " + response);
                return err;
            } else {
                // console.log(response);
                return response;
            }
        });
    }
};
