package me.jimmyberg.bss.infra.restclient.kakao

interface KakaoRestClientAdapter {

    fun searchBlogWithRetry(request: KakaoSearchBlogRequest): KakaoSearchBlogResponse?

    fun searchBlog(request: KakaoSearchBlogRequest): KakaoSearchBlogResponse?

}