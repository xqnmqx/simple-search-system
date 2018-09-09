package ru.rti

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class EchoController {

    val counter = AtomicLong()

    @GetMapping("/")
    fun echo() = "Search system works"

}