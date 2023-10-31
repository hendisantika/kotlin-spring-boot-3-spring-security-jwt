package com.hendisantika.kotlinspringboot3jwt.model

import java.util.*

/**
 * Created by IntelliJ IDEA.
 * Project : kotlin-spring-boot-3-jwt
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 10/31/23
 * Time: 15:13
 * To change this template use File | Settings | File Templates.
 */
data class Article(
    val id: UUID,
    val title: String,
    val content: String,
)
