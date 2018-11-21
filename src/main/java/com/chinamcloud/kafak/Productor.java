package com.chinamcloud.kafak;

import com.google.gson.Gson;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.protocol.types.Field;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class Productor {

    public static Gson gson = new Gson();

    private static FileRead fileRead = new FileRead();

    public static Properties getProp() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "47.94.97.7:9092");
        properties.put("acks", "all");
        properties.put("group.id", "spark-executor-userTagStream");
        properties.put("retries", 0);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("buffer.memory", 33554432);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        return properties;
    }

    public static BehaviorLog getBehaviour() {
        BehaviorLog behaviorLog = new BehaviorLog();
        behaviorLog.setAct_obj("123");
        behaviorLog.setUser_id("123");
        behaviorLog.setTenant("123");
        return behaviorLog;
    }

    public static void main(String[] args) {
        Producer<String, String> producer = null;
        try {
            producer = new KafkaProducer<String, String>(getProp());
            List<String> list = fileRead.read("item");
            for (String s:
                 list) {
                producer.send(new ProducerRecord<>("webtvlogs", s));
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            producer.close();
        }

    }
}
