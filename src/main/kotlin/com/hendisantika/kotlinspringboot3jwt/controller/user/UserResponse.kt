package com.hendisantika.kotlinspringboot3jwt.controller.user

import java.util.*

/**
 * Created by IntelliJ IDEA.
 * Project : kotlin-spring-boot-3-jwt
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/1/23
 * Time: 11:23
 * To change this template use File | Settings | File Templates.
 */
data class UserResponse(
    val uuid: UUID,
    val email: String,
)
