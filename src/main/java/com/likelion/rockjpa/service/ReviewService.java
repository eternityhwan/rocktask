package com.likelion.rockjpa.service;

import com.likelion.rockjpa.domain.Hospital;
import com.likelion.rockjpa.domain.Review;
import com.likelion.rockjpa.model.ReviewCreateRequest;
import com.likelion.rockjpa.model.ReviewCreateResponse;
import com.likelion.rockjpa.repository.HospitalRepository;
import com.likelion.rockjpa.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    // hospital 을 조회해야하니까 리포지토리를 가져온다!
    private final HospitalRepository hospitalRepository;

    // Review도 조회해야하니까 리포지토리를 가져온다.
    private final ReviewRepository reviewRepository;

    // DI를 해준다.
    public ReviewService(HospitalRepository hospitalRepository, ReviewRepository reviewRepository) {
        this.hospitalRepository = hospitalRepository;
        this.reviewRepository = reviewRepository;
    }

    // 리뷰를 생성하는 서비스 생성성
   public ReviewCreateResponse createReview(
        ReviewCreateRequest dto) {

        // 1. hospital을 먼저 찾는다.
       Optional<Hospital> hospitalOptional = hospitalRepository.findById(dto.getHospitalId());

       // 2. dto를 Entity로 바꿔준다. 그래야 DB에 저장가능
       // dto 상태에서는 db로 못넘긴다다
      // Review 클래스를 review 객체로 선언.
       // 중요한건 hospital을 넣어줘야한다.
       Review review = Review.builder()
           .title(dto.getTitle())
           .content(dto.getContent())
           .patientName(dto.getUserName())
           .hospital(hospitalOptional.get())
           .build();

       // 3. 레파지토리를 사용해서 review 엔티티를 DB에 저장을 한다.
       Review savedReview = reviewRepository.save(review);

        return ReviewCreateResponse.builder()
            .userName(savedReview.getPatientName())
            .title(savedReview.getTitle())
            .content(savedReview.getContent())
            .message("리뷰 등록이 완료되었습니다")
            .build();
    }
}
