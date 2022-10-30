package com.example.tddreststudy.controller;

import com.example.tddreststudy.service.ReviewService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class ReviewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ReviewService reviewService;

    @Test
    @DisplayName("후기 조회 성공 (Controller)")
    void success_view() throws Exception {
        // 준비

        // 실행
        ResultActions perform = mockMvc.perform(get("/reviews/1"));

        // 검증
        perform
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("content").value(1))
                .andExpect(jsonPath("phoneNumber").value(1))
        ;
    }

}