package com.hendisantika.kotlinspringboot3jwt.service

import com.hendisantika.kotlinspringboot3jwt.config.JwtProperties
import com.hendisantika.kotlinspringboot3jwt.repository.RefreshTokenRepository

/**
 * Created by IntelliJ IDEA.
 * Project : kotlin-spring-boot-3-jwt
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 10/31/23
 * Time: 15:22
 * To change this template use File | Settings | File Templates.
 */
@Service
class AuthenticationService(
    private val authManager: AuthenticationManager,
    private val userDetailsService: CustomUserDetailsService,
    private val tokenService: TokenService,
    private val jwtProperties: JwtProperties,
    private val refreshTokenRepository: RefreshTokenRepository,
)
