package me.jimmyberg.bss.infra.restclient.naver

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class NaverRestClientServiceTest(
    private val naverRestClientService: NaverRestClientService
) : BehaviorSpec({

    given("'카카오뱅크' 검색어 조건 기준") {
        val request = NaverSearchBlogRequest(query = "카카오뱅크", start = 1, display = 10)

        `when`("네이버 블로그 조회 요청하여") {
            val response = naverRestClientService.searchBlog(request)

            then("정상 응답 확인한다") {
                response shouldNotBe null
                response!!.start shouldBe 1
                response.items.size shouldBe 10
            }
        }
    }

})