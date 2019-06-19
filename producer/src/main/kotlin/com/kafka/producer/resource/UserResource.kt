package com.kafka.producer.resource

import com.kafka.producer.model.User
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.beans.factory.annotation.Autowired



@RestController
@RequestMapping("producer")
class UserResource {

    @Autowired
    private val kafkaMessage: KafkaTemplate<String, String>? = null

    @Autowired
    private val kafkaTemplate: KafkaTemplate<String, User>? = null

    @GetMapping("/publish/s/{name}")
    fun publish(@PathVariable("name") name: String): String {

        kafkaMessage!!.send(TOPIC1, name)
        println("produced message: $name")
        return "Published successfully: $name"
    }

    @GetMapping("/publish/o/{object}")
    fun publishJson(@PathVariable("object") name: String): String {
        val user = User(name, "Technology", 12000L)
        kafkaTemplate!!.send(TOPIC2, user)
        println("produced message: $user")
        return "Published successfully : $user"
    }

    companion object {
        private val TOPIC1 = "test"
        private val TOPIC2 = "test_json"
    }
}
