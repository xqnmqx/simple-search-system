package ru.rti

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
internal class UserService(
        @Autowired
        val userRepository: UserRepository,
        @Autowired
        val userSearch: UserSearch) {

    fun findAll(): List<User> {
        return userRepository.findAll()
    }

    fun search(text: String): List<User> {
        return userSearch.searchUsers(text)
    }
}