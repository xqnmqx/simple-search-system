package ru.rti

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
internal class UserController(private val userService: UserService) {

    @GetMapping("/users")
    fun getAll(): List<User> {
        return userService.findAll()
    }

    @GetMapping("/users/search")
    fun search(text: String): List<User> {
        return userService.search(text)
    }
}