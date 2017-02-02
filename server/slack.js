var Slack = require('slack-node');
var PropertiesReader = require('properties-reader');
var properties = PropertiesReader('../resources/properties.ini');

webhookUri = properties.get('main.slack.webhook.uri');

slack = new Slack();
slack.setWebhook(webhookUri);

slack.webhook({
    channel: "#general",
    username: "webhookbot",
    text: "This is a launch alert"
}, function(err, response) {
    console.log(response);
});
