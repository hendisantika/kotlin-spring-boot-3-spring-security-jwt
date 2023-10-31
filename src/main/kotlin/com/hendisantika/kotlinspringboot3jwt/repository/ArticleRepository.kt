package com.hendisantika.kotlinspringboot3jwt.repository

import com.hendisantika.kotlinspringboot3jwt.model.Article
import org.springframework.stereotype.Repository
import java.util.*

/**
 * Created by IntelliJ IDEA.
 * Project : kotlin-spring-boot-3-jwt
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 10/31/23
 * Time: 15:15
 * To change this template use File | Settings | File Templates.
 */
@Repository
class ArticleRepository {

    private val articles = listOf(
        Article(id = UUID.randomUUID(), title = "Article 1", content = "Content 1"),
        Article(id = UUID.randomUUID(), title = "Article 2", content = "Content 2"),
    )

    fun findAll(): List<Article> =
        articles
}
