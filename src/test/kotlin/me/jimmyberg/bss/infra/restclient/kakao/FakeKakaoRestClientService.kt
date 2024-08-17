package me.jimmyberg.bss.infra.restclient.kakao

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class FakeKakaoRestClientService : KakaoRestClientAdapter {

    override fun searchBlogWithRetry(request: KakaoSearchBlogRequest): KakaoSearchBlogResponse? {
        TODO("Not yet implemented")
    }

    override fun searchBlog(request: KakaoSearchBlogRequest): KakaoSearchBlogResponse? {
        return KakaoSearchBlogResponse(
            meta = KakaoSearchBlogResponse.Meta(
                isEnd = true,
                pageableCount = request.size,
                totalCount = request.size
            ),
            documents = generateDocuments(request.size)
        )
    }

    private fun generateDocuments(size: Int): MutableList<KakaoSearchBlogResponse.Document> {
        val documents = mutableListOf<KakaoSearchBlogResponse.Document>()
        for (i in 1..size) {
            documents += KakaoSearchBlogResponse.Document(
                blogname = "blogname$i",
                contents = "contents$i",
                datetime = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                thumbnail = "thumbnail$i",
                title = "title$i",
                url = "url$i",
            )
        }
        return documents
    }

}