package com.example.newdemo.kafka;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.KafkaFuture;

import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class KafkaAdminExample {

    public static void createTopic(String topicName, int numPartitions, short replicationFactor) {
        Properties props = new Properties();



        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

        try (AdminClient adminClient = AdminClient.create(props)) {
            // 创建主题配置
            CreateTopicsResult result = adminClient.createTopics(
                    Collections.singleton(new NewTopic(topicName, numPartitions, replicationFactor))
            );

            // 等待创建完成
            result.all().get();
            System.out.println("主题 " + topicName + " 创建成功");
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("创建主题失败: " + e.getMessage());
        }
    }

    public static void listTopics() {
        Properties props = new Properties();
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

        try (AdminClient adminClient = AdminClient.create(props)) {
            ListTopicsResult result = adminClient.listTopics();
            KafkaFuture<java.util.Set<String>> names = result.names();

            System.out.println("Kafka 中的主题列表:");
            names.get().forEach(System.out::println);
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("获取主题列表失败: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // 创建测试主题
        createTopic("test-topic", 3, (short) 1);

        // 列出所有主题
        listTopics();
    }
}
