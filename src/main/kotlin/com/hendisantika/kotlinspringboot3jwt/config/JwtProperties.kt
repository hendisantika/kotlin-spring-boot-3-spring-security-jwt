package com.hendisantika.kotlinspringboot3jwt.config

import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * Created by IntelliJ IDEA.
 * Project : kotlin-spring-boot-3-jwt
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 10/31/23
 * Time: 15:12
 * To change this template use File | Settings | File Templates.
 */
@ConfigurationProperties("jwt")
data class JwtProperties(
    val key: String,
    val accessTokenExpiration: Long,
    val refreshTokenExpiration: Long,
)
