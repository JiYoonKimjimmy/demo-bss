package me.jimmyberg.bss.api.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Bean
    fun openAPI(): OpenAPI = OpenAPI().info(info())

    private fun info(): Info =
        Info()
            .title("Blog 검색 서비스")
            .description("Open-API 활용한 Blog 검색 서비스 API 문서")

}
