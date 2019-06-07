package com.kafka.producer.resource

import com.kafka.producer.model.User
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.beans.factory.annotation.Autowired



@RestController
@RequestMapping("kafka")
class UserResource {

    @Autowired
    private val kafkaTemplate: KafkaTemplate<String, User>? = null

    @GetMapping("/publish/{name}")
    fun post(@PathVariable("name") name: String): String {

        kafkaTemplate!!.send(TOPIC, User(name, "Technology", 12000L))

        return "Published successfully"
    }

    companion object {

        private val TOPIC = "Kafka_Example"
    }
}
