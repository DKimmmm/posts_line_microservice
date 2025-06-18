package com.example.postsline.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.*;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

@Slf4j
public class KafkaListener {
    public static void main(String[] args) {
        // Настройки консьюмера
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "my-group");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("auto.offset.reset", "earliest"); // Читать с начала топика
        props.put("enable.auto.commit", "false"); // Ручное подтверждение смещений

        // Создание консьюмера
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        try {
            // Подписка на топик
            consumer.subscribe(Collections.singletonList("my-topic"));

            // Основной цикл
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    log.info("begging pool");
                    ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(5000));
                    for (ConsumerRecord<String, String> record : records) {
                        System.out.printf("Получено: key=%s, value=%s, partition=%d, offset=%d%n",
                                record.key(), record.value(), record.partition(), record.offset());
                        // Обработка сообщения
                    }
                    // Ручное подтверждение смещений
                    if (!records.isEmpty()) {
                        consumer.commitSync();
                    }
                } catch (Exception e) {
                    System.err.println("Consumer error: " + e.getMessage());
                }
            }
        } finally {
            consumer.close();
        }
    }
}
