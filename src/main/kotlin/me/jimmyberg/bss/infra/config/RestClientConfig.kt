package me.jimmyberg.bss.infra.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.SimpleClientHttpRequestFactory
import org.springframework.web.client.RestClient
import java.time.Duration

@Configuration
class RestClientConfig {

    @Bean
    fun kakaoRestClient(
        @Value("\${open-api.kakao.host}") host: String,
        @Value("\${open-api.kakao.authorization}") authorization: String,
    ): RestClient {
        return RestClient
            .builder()
            .baseUrl(host)
            .requestFactory(simpleClientHttpRequestFactory())
            .defaultHeaders {
                it["Authorization"] = authorization
            }
            .build()
    }

    @Bean
    fun naverRestClient(
        @Value("\${open-api.naver.host}") host: String,
        @Value("\${open-api.naver.client-id}") clientId: String,
        @Value("\${open-api.naver.client-secret}") clientSecret: String,
    ): RestClient {
        return RestClient
            .builder()
            .baseUrl(host)
            .requestFactory(simpleClientHttpRequestFactory())
            .defaultHeaders {
                it["X-Naver-Client-id"] = clientId
                it["X-Naver-Client-Secret"] = clientSecret
            }
            .build()
    }

    private fun simpleClientHttpRequestFactory(): SimpleClientHttpRequestFactory {
        return SimpleClientHttpRequestFactory().apply {
            this.setConnectTimeout(Duration.ofSeconds(5))
            this.setReadTimeout(Duration.ofSeconds(10))
        }
    }

}