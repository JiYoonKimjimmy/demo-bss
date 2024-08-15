package me.jimmyberg.bss.blog.service

import me.jimmyberg.bss.blog.service.domain.Blog

interface BlogSearchAdapter {

    fun searchBlogs(text: String): List<Blog>

    fun searchKakaoBlogs(text: String, page: Int, size: Int): List<Blog>

    fun searchNaverBlogs(text: String, page: Int, size: Int): List<Blog>

}