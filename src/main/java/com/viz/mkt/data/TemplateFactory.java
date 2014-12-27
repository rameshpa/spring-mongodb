/*
 * MIT License 
 * Code created by Ramesh Parameswaran, repo in https://github.com/rameshpa/spring-mongodb
 */
package com.viz.mkt.data;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;

public enum TemplateFactory {
    TEMPLATE;
    private MongoOperations mongoOps = null;

    private TemplateFactory() {
        try {
        	MongoClient client = ConnectionFactory.CONNECTION.getClient();
    		mongoOps = new MongoTemplate(client,  Constants.DB_NAME);
        } catch (Exception e) {
            // Log it.
        }
    }

    public MongoOperations getMongoTemplate() {
        if (mongoOps == null)
            throw new RuntimeException();
        return mongoOps;
    }
}
