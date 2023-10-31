package com.hendisantika.kotlinspringboot3jwt.repository

import com.hendisantika.kotlinspringboot3jwt.model.Role
import com.hendisantika.kotlinspringboot3jwt.model.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Repository
import java.util.*

/**
 * Created by IntelliJ IDEA.
 * Project : kotlin-spring-boot-3-jwt
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 10/31/23
 * Time: 15:16
 * To change this template use File | Settings | File Templates.
 */
@Repository
class UserRepository(
    private val encoder: PasswordEncoder
) {
    private val users = mutableSetOf(
        User(
            id = UUID.randomUUID(),
            email = "email-1@gmail.com",
            password = encoder.encode("pass1"),
            role = Role.USER,
        ),
        User(
            id = UUID.randomUUID(),
            email = "email-2@gmail.com",
            password = encoder.encode("pass2"),
            role = Role.ADMIN,
        ),
        User(
            id = UUID.randomUUID(),
            email = "email-3@gmail.com",
            password = encoder.encode("pass3"),
            role = Role.USER,
        ),
    )

    fun save(user: User): Boolean {
        val updated = user.copy(password = encoder.encode(user.password))

        return users.add(updated)
    }

    fun findByEmail(email: String): User? =
        users
            .firstOrNull { it.email == email }

    fun findAll(): Set<User> =
        users
}
