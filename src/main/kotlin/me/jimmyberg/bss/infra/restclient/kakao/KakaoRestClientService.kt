package me.jimmyberg.bss.infra.restclient.kakao

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.retry.annotation.Backoff
import org.springframework.retry.annotation.Retryable
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient

@Service
class KakaoRestClientService(
    private val kakaoRestClient: RestClient
) : KakaoRestClientAdapter {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @Value("\${open-api.kakao.search-blog.url}")
    private lateinit var searchBlogUrl: String

    private var retryCount = 0

    @Retryable(
        maxAttempts = 3,
        backoff = Backoff(delay = 1000),
        include = [RuntimeException::class]
    )
    override fun searchBlogWithRetry(request: KakaoSearchBlogRequest): KakaoSearchBlogResponse? {
        retryCount += 1
        logger.info("Try count : $retryCount")

        return if (retryCount % 3 == 0) {
            searchBlog(request)
        } else {
            throw RuntimeException("Failed to search blog")
        }
    }

    override fun searchBlog(request: KakaoSearchBlogRequest): KakaoSearchBlogResponse? {
        return kakaoRestClient
            .get()
            .uri("$searchBlogUrl?${request.params()}")
            .retrieve()
            .body(KakaoSearchBlogResponse::class.java)
    }

}