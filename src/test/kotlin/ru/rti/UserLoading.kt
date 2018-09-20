package ru.rti

import org.springframework.web.client.RestTemplate
import java.net.URI
import java.util.*

fun main(args: Array<String>) {
    val url = URI("http://localhost:8080/users")
    for (i in 1..1000) {
        postUser(url)
    }
}

internal fun genUser(): User {
    return User((0L..10000L).shuffled().last(),
            "test-user", "test-user-surname", "123", Date())
}

internal fun postUser(url: URI): Unit {
    val restTemplate = RestTemplate()
    val response = restTemplate.postForEntity(url, genUser(), String::class.java)
    println(response)
}