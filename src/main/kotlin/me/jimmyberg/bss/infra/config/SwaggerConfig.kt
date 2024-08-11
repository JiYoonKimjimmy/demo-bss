package me.jimmyberg.bss.infra.config

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.context.annotation.Configuration

@OpenAPIDefinition(
    info = Info(
        title = "Blog 검색 서비스",
        description = "OpenAPI 활용한 Blog 컨텐츠 검색 서비스"
    )
)
@Configuration
class SwaggerConfig