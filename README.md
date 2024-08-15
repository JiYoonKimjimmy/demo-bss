# Blog-Search-Service

## 블로그 검색 서비스

- 카카오 OpenAPI 서비스를 활용한 블로그 검색 서비스 시스템 구축
- 검색어에 따른 조회 결과와 정렬, 페이징 기능 추가하여 기본적인 블로그 검색 API 제공
- 검색어 조회 건수를 집계 처리
- 인기 검색어 조회 API 제공

---

## 프로젝트 구성

- Kotlin 2.0.0
- Spring Boot 3.3.2
- Gradle 8.9
- H2 Database
- Exposed

### 프로젝트 Build
1. `git repository` clone or download
   - `url` : https://github.com/JiYoonKimjimmy/blog-search-service.git
2. `gradlew` 을 통한 프로젝트 build
   ```shell
   cd ${WORKSPACE}/blog-search-service
   ./gradle/gradlew build
   ```
3. 프로젝트 `jar` 실행
   ```shell
   cd ${WORKSPACE}/blog-search-service/build/libs
   java -jar blog-search-service-0.0.1.jar 
   ```

---

## 프로젝트 정보

### Server 정보
|      구분      | 정보     |
|:------------:|--------|
|     Port     | `8080` |
| Context-Path | `/bss` |

### API 테스트 방법

1. `Swagger-ui` 이용
   - http://localhost:8080/bss/swagger-ui/index.html
2. `IntelliJ .http` 이용
   - `/http/bss-api-test.http` 파일의 `request` 활용하여 API 테스트 요청

---

## Database 정보
- H2 Database Embedded 환경
- URL : `jdbc:h2:~/h2/bss`

---
