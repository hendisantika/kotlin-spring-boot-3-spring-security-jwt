package com.hendisantika.kotlinspringboot3jwt.config

import com.hendisantika.kotlinspringboot3jwt.service.CustomUserDetailsService
import com.hendisantika.kotlinspringboot3jwt.service.TokenService
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

/**
 * Created by IntelliJ IDEA.
 * Project : kotlin-spring-boot-3-jwt
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 10/31/23
 * Time: 15:44
 * To change this template use File | Settings | File Templates.
 */
@Component
class JwtAuthenticationFilter(
    private val userDetailsService: CustomUserDetailsService,
    private val tokenService: TokenService,
) : OncePerRequestFilter()
