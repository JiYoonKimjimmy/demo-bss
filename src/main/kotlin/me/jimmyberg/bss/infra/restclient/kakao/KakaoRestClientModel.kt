package me.jimmyberg.bss.infra.restclient.kakao

import com.fasterxml.jackson.annotation.JsonProperty

data class KakaoSearchBlogRequest(
    private val query: String,
    private val page: Int,
    private val size: Int
) {
    fun params(): String {
        return "query=$query&page=$page&size=$size"
    }
}

data class KakaoSearchBlogResponse(
    val meta: Meta,
    val documents: List<Document>
) {
    data class Meta(
        @field:JsonProperty("is_end")
        val isEnd: Boolean,
        @field:JsonProperty("pageable_count")
        val pageableCount: Int,
        @field:JsonProperty("total_count")
        val totalCount: Int
    )
    data class Document(
        val blogname: String,
        val contents: String,
        val datetime: String,
        val thumbnail: String,
        val title: String,
        val url: String,
    )
}