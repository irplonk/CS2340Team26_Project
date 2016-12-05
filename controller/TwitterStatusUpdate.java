package controller;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Kevin on 11/7/16
 */
public class TwitterStatusUpdate {

    /**
     * Post a status to twitter page, @2340_Team26
     *
     * @param statusText - Post text
     */
    public static void update(String statusText) {
        try {
            // Set specified twitter keys
            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true)
                    .setOAuthConsumerKey("dOcYLY8klHsqUI8qQ59jjmlLA")
                    .setOAuthConsumerSecret("q1WZdo3ppc7l6n5s3zD5souSDu6tUCtbCw4vd41whBZyM4nPn3")
                    .setOAuthAccessToken("795817580204277760-rHBQEh1lpvO1hw0oxmsYQCapm1B3Nai")
                    .setOAuthAccessTokenSecret("AQwz03MEiYZ11sEpdh1wSngaQQivvVAmAvgXoLJocTc1d");
            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter = tf.getInstance();

            // Update status
            Status status = twitter.updateStatus(statusText);
            System.out.println("Successfully updated the status to [" + status.getText() + "].");

        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get timeline: " + te.getMessage());
        }
    }
}