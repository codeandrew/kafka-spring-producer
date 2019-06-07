package com.kafka.producer.config

import com.kafka.producer.model.User
import org.apache.kafka.clients.producer.ProducerConfig
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG
import org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.ProducerFactory
import org.springframework.kafka.support.serializer.JsonSerializer
import java.util.HashMap;
import java.util.Map;


@Configuration
class KakfaConfiguration {

    @Bean
    fun producerFactory(): ProducerFactory<String, User> {
        val config = mutableMapOf<String, Any>()

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092")
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer::class.java)
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer::class.java)

        return DefaultKafkaProducerFactory<String, User>(config)
    }


    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, User> {
        return KafkaTemplate<String, User>(producerFactory())
    }


}