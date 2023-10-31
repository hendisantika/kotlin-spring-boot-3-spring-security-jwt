package com.hendisantika.kotlinspringboot3jwt.controller.article

import java.util.*

/**
 * Created by IntelliJ IDEA.
 * Project : kotlin-spring-boot-3-jwt
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 10/31/23
 * Time: 15:52
 * To change this template use File | Settings | File Templates.
 */
data class ArticleResponse(
    val id: UUID,
    val title: String,
    val content: String,
)
