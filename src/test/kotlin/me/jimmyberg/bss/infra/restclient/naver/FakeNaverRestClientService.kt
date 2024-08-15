package me.jimmyberg.bss.infra.restclient.naver

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class FakeNaverRestClientService : NaverRestClientAdapter {

    override fun searchBlog(request: NaverSearchBlogRequest): NaverSearchBlogResponse? {
        return NaverSearchBlogResponse(
            lastBuildDate = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
            total = request.display,
            start = request.start,
            display = request.display,
            items = generateItems(request.display)
        )
    }

    private fun generateItems(size: Int): MutableList<NaverSearchBlogResponse.Item> {
        val items = mutableListOf<NaverSearchBlogResponse.Item>()
        for (i in 1..size) {
            items += NaverSearchBlogResponse.Item(
                title = "title$i",
                link = "link$i",
                description = "description$i",
                bloggername = "bloggername$i",
                bloggerlink = "bloggerlink$i",
                postdate = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
            )
        }
        return items
    }

}