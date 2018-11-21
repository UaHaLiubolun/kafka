package com.chinamcloud.kafak;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Arrays;

public class MongoDB {

    public static void main(String[] args) {
        MongoCredential credential = MongoCredential.createScramSha1Credential("root",
                "admin",
                "Newmed!@s0bey".toCharArray());
        MongoClient mongoClient = new MongoClient(new ServerAddress("localhost", 27017), Arrays.asList(credential));
        MongoDatabase database = mongoClient.getDatabase("spider");
        MongoCollection collection = database.getCollection("test");
        Document doc = new Document("name", "MongoDB")
                .append("type", "database")
                .append("count", 1)
                .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
                .append("info", new Document("x", 203).append("y", 102));
        collection.insertOne(doc);
    }
}
