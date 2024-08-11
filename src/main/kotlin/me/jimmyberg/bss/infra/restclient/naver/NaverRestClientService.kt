package me.jimmyberg.bss.infra.restclient.naver

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient

@Service
class NaverRestClientService(
    private val naverRestClient: RestClient
) : NaverRestClientAdapter {

    @Value("\${open-api.naver.search-blog.url}")
    private lateinit var searchBlogUrl: String

    override fun searchBlog(request: NaverSearchBlogRequest): NaverSearchBlogResponse? {
        return naverRestClient
            .get()
            .uri("$searchBlogUrl?${request.params()}")
            .retrieve()
            .body(NaverSearchBlogResponse::class.java)
    }
}