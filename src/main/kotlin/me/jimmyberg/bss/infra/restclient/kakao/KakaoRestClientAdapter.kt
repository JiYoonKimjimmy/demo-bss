package me.jimmyberg.bss.infra.restclient.kakao

interface KakaoRestClientAdapter {

    fun searchBlog(request: KakaoSearchBlogRequest): KakaoSearchBlogResponse?

}