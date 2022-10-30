package com.example.tddreststudy;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/*
시나리오
- 리뷰를 조회할 수 있게 해주세요.
- 리뷰 작성자에게 선물하기 기능 추가해주세요.

*후기 조회하기  API*

1. [ ] 후기의 ID를 요청 값으로 받습니다.
2. [ ] 요청 ID에 대한 후기를 찾아 응답값으로 내려줍니다. (200 OK)
3. [ ] 응답에는 반드시 본문을 포함해야 합니다.
4. [ ] 응답에는 반드시 연락처를 포함해야 합니다.
5. [ ] 후기가 존재하지 않는다면 에러를 반환해야 합니다. (404 Not Found)

*후기 작성자에게 선물하기 API*

1. [ ] 후기의 ID를 요청 값으로 받습니다.
2. [ ] 선물은 후기당 한번만 요청할 수 있습니다.
3. [ ] 선물하기에 성공하면 후기의 현재 상태를 반환합니다. (200 OK)
4. [ ] 선물하기엔 아래의 API를 호출하며 수행합니다.
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TddRestStudyApplicationTests {

    @LocalServerPort
    int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("후기 조회에 성공합니다.")
    void success_view() {
        // given, arrange, 준비
        given()
                .accept(MediaType.APPLICATION_JSON_VALUE)

        // when, act, 실행
        .when()
                .get("/reviews/1")

        // then, assert, 검증
        .then()
                .statusCode( HttpStatus.OK.value())
                .assertThat()
                .body("id", equalTo(1))
                .body("content", equalTo("재밌어요"))
                .body("phoneNumber", equalTo("010-1111-2222"));

    }

    @Test
    @DisplayName("후기 조회에 실패합니다.")
    void failed_view() {

    }

    @Test
    @DisplayName("선물하기에 성공합니다.")
    void success_give_gift() {

    }

}
