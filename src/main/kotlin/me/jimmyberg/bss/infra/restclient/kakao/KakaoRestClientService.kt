package me.jimmyberg.bss.infra.restclient.kakao

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient

@Service
class KakaoRestClientService(
    private val kakaoRestClient: RestClient
) : KakaoRestClientAdapter {

    @Value("\${open-api.kakao.search-blog.url}")
    private lateinit var searchBlogUrl: String

    override fun searchBlog(request: KakaoSearchBlogRequest): KakaoSearchBlogResponse? {
        return kakaoRestClient
            .get()
            .uri("$searchBlogUrl?${request.params()}")
            .retrieve()
            .body(KakaoSearchBlogResponse::class.java)
    }

}