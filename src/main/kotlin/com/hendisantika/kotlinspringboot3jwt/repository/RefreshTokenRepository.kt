package com.hendisantika.kotlinspringboot3jwt.repository

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component

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
@Component
class RefreshTokenRepository {

    private val tokens = mutableMapOf<String, UserDetails>()

    fun findUserDetailsByToken(token: String): UserDetails? =
        tokens[token]

    fun save(token: String, userDetails: UserDetails) {
        tokens[token] = userDetails
    }
}
