package ru.rti

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class EchoController {

    val counter = AtomicLong()

    @GetMapping("/")
    fun echo(@RequestParam(value = "name", defaultValue = "World") name: String) = "Search system works"

}