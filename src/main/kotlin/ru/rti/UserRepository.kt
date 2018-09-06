package ru.rti

import org.springframework.data.jpa.repository.JpaRepository
import javax.transaction.Transactional

@Transactional(Transactional.TxType.MANDATORY)
internal interface UserRepository: JpaRepository<User, Long>