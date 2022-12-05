package com.likelion.rockjpa.controller;

import com.likelion.rockjpa.model.ReviewCreateRequest;
import com.likelion.rockjpa.model.ReviewCreateResponse;
import com.likelion.rockjpa.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hospitals")
@Slf4j
public class HospitalController {

    // 리뷰 서비스를 DI로 받는다.
    private final ReviewService reviewService;

    public HospitalController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // 컨트롤러는 요청을 받기만하고
    // 받은 요청을 서비스로 보내주고 서비스에서 리턴한 것을
    // 사용자에게 응답시켜줌.
   @PostMapping("/{id}/reviews")
    public ResponseEntity<ReviewCreateResponse> add(
        @RequestBody ReviewCreateRequest reviewCreateRequest) {
        log.info("{}", reviewCreateRequest);
        // 에러처리를 안함 모두 ok로 넘긴다.
        return ResponseEntity.ok().body(reviewService.createReview(reviewCreateRequest));
    }
}
