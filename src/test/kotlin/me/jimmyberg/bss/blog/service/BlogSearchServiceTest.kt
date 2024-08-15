package me.jimmyberg.bss.blog.service

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import me.jimmyberg.bss.blog.service.domain.BlogMapper
import me.jimmyberg.bss.infra.restclient.kakao.FakeKakaoRestClientService
import me.jimmyberg.bss.infra.restclient.naver.FakeNaverRestClientService

class BlogSearchServiceTest : BehaviorSpec({

    val mapper = BlogMapper()
    val kakaoRestClientService = FakeKakaoRestClientService()
    val naverRestClientService = FakeNaverRestClientService()
    val blogSearchService = BlogSearchService(mapper, kakaoRestClientService, naverRestClientService)

    given("'카카오뱅크' 검색어로 블로그 조회 요청하여") {
        val text = "카카오뱅크"
        val page = 0
        val size = 10

        `when`("Kakao 블로그 조회 API 요청하여 정상 결과인 경우") {
            val result = blogSearchService.searchKakaoBlogs(text, page, size)

            then("$size 건 결과 응답 확인한다") {
                result.size shouldBe size
            }
        }

        `when`("Naver 블로그 조회 API 요청하여 정상 결과인 경우") {
            val result = blogSearchService.searchNaverBlogs(text, page, size)

            then("$size 건 결과 응답 확인한다") {
                result.size shouldBe size
            }
        }
    }

})