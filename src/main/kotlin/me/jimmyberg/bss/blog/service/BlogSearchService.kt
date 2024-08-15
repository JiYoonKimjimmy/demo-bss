package me.jimmyberg.bss.blog.service

import me.jimmyberg.bss.blog.service.domain.Blog
import me.jimmyberg.bss.blog.service.domain.BlogMapper
import me.jimmyberg.bss.infra.restclient.kakao.KakaoRestClientAdapter
import me.jimmyberg.bss.infra.restclient.kakao.KakaoSearchBlogRequest
import me.jimmyberg.bss.infra.restclient.naver.NaverRestClientAdapter
import me.jimmyberg.bss.infra.restclient.naver.NaverSearchBlogRequest
import org.springframework.stereotype.Service

@Service
class BlogSearchService(
    private val mapper: BlogMapper,
    private val kakaoRestClientAdapter: KakaoRestClientAdapter,
    private val naverRestClientAdapter: NaverRestClientAdapter
) : BlogSearchAdapter {

    override fun searchBlogs(text: String): List<Blog> {
        /**
         * [블로그 조회]
         * 1. 'text' 검색어 기준 카카오 블로그 5개 검색
         * 2. 'text' 검색어 기준 네이버 블로그 5개 검색
         * 3. 총 10개의 블로그 검색 결과 반환
         * - 총 결과 10개 미만인 경우, 카카오 > 네이버 순으로 추가 검색
         * - 더이상 검색 결과 없는 경우, 10개 미만 결과 반환
         */

        return emptyList()
    }

    override fun searchKakaoBlogs(text: String, page: Int, size: Int): List<Blog> {
        return kakaoRestClientAdapter.searchBlog(KakaoSearchBlogRequest(text, page, size))
            ?.documents
            ?.map { mapper.kakaoDocumentToBlog(it) }
            ?: emptyList()
    }

    override fun searchNaverBlogs(text: String, page: Int, size: Int): List<Blog> {
        return naverRestClientAdapter.searchBlog(NaverSearchBlogRequest(text, page, size))
            ?.items
            ?.map { mapper.naverItemToBlog(it) }
            ?: emptyList()
    }
}