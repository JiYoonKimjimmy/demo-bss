package me.jimmyberg.bss.infra.restclient.naver

data class NaverSearchBlogRequest(
    private val query: String,
    private val start: Int,
    private val display: Int
) {
    fun params(): String {
        return "query=$query&start=$start&display=$display"
    }
}

data class NaverSearchBlogResponse(
    val lastBuildDate: String,
    val total: Int,
    val start: Int,
    val display: Int,
    val items: List<Item>
) {
    data class Item(
        val title: String,
        val link: String,
        val description: String,
        val bloggername: String,
        val bloggerlink: String,
        val postdate: String,
    )
}