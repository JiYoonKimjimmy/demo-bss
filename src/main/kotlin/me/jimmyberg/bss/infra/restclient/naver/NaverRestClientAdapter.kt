package me.jimmyberg.bss.infra.restclient.naver

interface NaverRestClientAdapter {

    fun searchBlog(request: NaverSearchBlogRequest): NaverSearchBlogResponse?

}