package com.hendisantika.kotlinspringboot3jwt.repository

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Repository

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
)
