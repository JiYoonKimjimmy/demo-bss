package me.jimmyberg.bss.blog.service.domain

import java.time.LocalDateTime

data class Blog(
    val blogName: String,
    val title: String,
    val contents: String,
    val link: String,
    val created: LocalDateTime
)