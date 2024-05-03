package com.hendisantika.kotlinspringboot3jwt.controller.article

import com.hendisantika.kotlinspringboot3jwt.model.Article
import com.hendisantika.kotlinspringboot3jwt.service.ArticleService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by IntelliJ IDEA.
 * Project : kotlin-spring-boot-3-jwt
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 10/31/23
 * Time: 15:50
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/api/articles")
class ArticleController(
    private val articleService: ArticleService
) {
    @GetMapping
    fun listAll(): List<ArticleResponse> =
        articleService.findAll()
            .map { it.toResponse() }

    private fun Article.toResponse(): ArticleResponse =
        ArticleResponse(
            id = this.id,
            title = this.title,
            content = this.content,
        )
}
