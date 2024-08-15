package me.jimmyberg.bss.blog.service.domain

import me.jimmyberg.bss.infra.restclient.kakao.KakaoSearchBlogResponse
import me.jimmyberg.bss.infra.restclient.naver.NaverSearchBlogResponse
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class BlogMapper {

    fun kakaoDocumentToBlog(document: KakaoSearchBlogResponse.Document): Blog {
        return Blog(
            blogName = document.blogname,
            title = document.title,
            contents = document.contents,
            link = document.url,
            created = LocalDateTime.parse(document.datetime),
        )
    }

    fun naverItemToBlog(item: NaverSearchBlogResponse.Item): Blog {
        return Blog(
            blogName = item.bloggername,
            title = item.title,
            contents = item.description,
            link = item.link,
            created = LocalDateTime.parse(item.postdate),
        )
    }

}