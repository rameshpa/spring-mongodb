/*
 * MIT License 
 * Code created by Ramesh Parameswaran, repo in https://github.com/rameshpa/spring-mongodb
 */

package com.viz.mkt.data;

import com.mongodb.MongoClient;

public enum ConnectionFactory {
    CONNECTION;
    private MongoClient client = null;

    private ConnectionFactory() {
        try {
            client = new MongoClient();
        } catch (Exception e) {
            // Log it.
        }
    }

    public MongoClient getClient() {
        if (client == null)
            throw new RuntimeException();
        return client;
    }
}



