package com.likelion.rockjpa.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Review {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String patientName;
    // 리뷰는 많고 병원은 하나니까
    // 리뷰 입장에서 테이블 매핑.
    // 많은 리뷰가 하나인 병원에게 가게 설정한다.
    // 테이블 매핑은 Long 타입으로는 안된다.
    // 타입을 객체를 넣어야한다 Hospital
    @ManyToOne
    @JoinColumn(name = "hospital_id")
    // Review에 hostpital_id가 생긴다!
    private Hospital hospital;

//    @ManyToOne
//    private Long hospital_id;
}
