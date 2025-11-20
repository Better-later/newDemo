package com.example.newdemo.kafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class KafkaProducerExample {
    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerExample.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建生产者配置
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.ACKS_CONFIG, "all");
        props.put(ProducerConfig.RETRIES_CONFIG, 3);

        // 创建生产者实例
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        // 发送多条消息
        for (int i = 1; i <= 10; i++) {
            String topic = "test-topic";
            String key = "key-" + i;
            String value = "message-" + i;

            // 创建生产者记录
            ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);

            // 异步发送消息
            producer.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    if (exception == null) {
                        logger.info("消息发送成功 - Topic: {}, Partition: {}, Offset: {}, Key: {}",
                                metadata.topic(), metadata.partition(), metadata.offset(), key);
                    } else {
                        logger.error("消息发送失败", exception);
                    }
                }
            });

            // 每隔1秒发送一条消息
            Thread.sleep(1000);
        }

        // 关闭生产者
        producer.close();
    }
}

