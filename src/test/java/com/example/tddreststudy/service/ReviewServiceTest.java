package com.example.tddreststudy.service;

import com.example.tddreststudy.dao.Review;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

class ReviewServiceTest {


    @Autowired
    ReviewService reviewService;

    @Test
    @DisplayName("후기 조회 성공 (service)")
    void success_view() {
        // 준비

        // 실행
        Review review = reviewService.getById(1L);

        // 검증
        assertThat(review.getId()).isEqualTo(1);
    }
}