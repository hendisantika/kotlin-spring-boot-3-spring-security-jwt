package com.hendisantika.kotlinspringboot3jwt.controller.auth

/**
 * Created by IntelliJ IDEA.
 * Project : kotlin-spring-boot-3-jwt
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 10/31/23
 * Time: 15:55
 * To change this template use File | Settings | File Templates.
 */
data class AuthenticationRequest(
    val email: String,
    val password: String,
)
