package com.hendisantika.kotlinspringboot3jwt.service

import com.hendisantika.kotlinspringboot3jwt.repository.UserRepository
import org.springframework.stereotype.Service

/**
 * Created by IntelliJ IDEA.
 * Project : kotlin-spring-boot-3-jwt
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 10/31/23
 * Time: 15:38
 * To change this template use File | Settings | File Templates.
 */
@Service
class UserService(
    private val userRepository: UserRepository
)
