package com.hendisantika.kotlinspringboot3jwt.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

/**
 * Created by IntelliJ IDEA.
 * Project : kotlin-spring-boot-3-jwt
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 10/31/23
 * Time: 15:48
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableWebSecurity
class SecurityConfiguration(
    private val authenticationProvider: AuthenticationProvider
)
