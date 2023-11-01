package com.hendisantika.kotlinspringboot3jwt.controller.user

/**
 * Created by IntelliJ IDEA.
 * Project : kotlin-spring-boot-3-jwt
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/1/23
 * Time: 11:22
 * To change this template use File | Settings | File Templates.
 */
data class UserRequest(
    val email: String,
    val password: String,
)
