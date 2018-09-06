package ru.rti

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
internal class UserController(@Autowired val userService: UserService) {

    @GetMapping("/users")
    fun getAll(): List<User> {
        return userService.findAll()
    }

    @GetMapping("/users/search")
    fun search(text: String): List<User> {
        return userService.search(text)
    }
}