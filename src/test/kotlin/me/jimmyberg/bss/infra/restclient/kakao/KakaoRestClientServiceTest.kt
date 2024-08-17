package me.jimmyberg.bss.infra.restclient.kakao

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class KakaoRestClientServiceTest @Autowired constructor(
    private val kakaoRestClientService: KakaoRestClientService
) : BehaviorSpec({

    given("'카카오뱅크' 검색어 조건 기준") {
        val request = KakaoSearchBlogRequest(query = "카카오뱅크", page = 1, size = 10)

        `when`("카카오 블로그 조회 요청하여") {
            val response = kakaoRestClientService.searchBlog(request)

            then("정상 응답 확인한다") {
                response shouldNotBe null
                response!!.meta.isEnd shouldBe false
                response.documents.size shouldBe 10
            }
        }

        `when`("카카오 블로그 조회 요청 3회 시도하여") {
            val response = kakaoRestClientService.searchBlogWithRetry(request)

            then("정상 응답 확인한다") {
                response shouldNotBe null
                response!!.meta.isEnd shouldBe false
                response.documents.size shouldBe 10
            }
        }
    }

})