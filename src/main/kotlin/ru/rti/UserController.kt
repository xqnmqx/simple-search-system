package ru.rti

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

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

    @PostMapping("/users")
    fun insertUser(@RequestBody user: User): User {
        return userService.saveUser(user)
    }
}