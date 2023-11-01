package com.hendisantika.kotlinspringboot3jwt.controller.user

import com.hendisantika.kotlinspringboot3jwt.service.UserService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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
@RestController
@RequestMapping("/api/user")
class UserController(
    private val userService: UserService
)
