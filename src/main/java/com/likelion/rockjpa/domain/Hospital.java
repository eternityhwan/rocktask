package com.likelion.rockjpa.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Hospital {

    @Id
    private Long id;
    private String hospitalName;
    private String roadNameAddress;

    // 병원 정보를 조회하면 리뷰가 나와야하니까.
    // Forign Key가 리뷰에만 있으면 교류가 안돼.
    // 양방향 매핑을 해야한다
    // 병원입장에서 병원은 하나이고 리뷰는 여러개니까
    // oneToMany 다.

    // mappedBy -- hospital
    // fetch 전략은 Lazy가 추천, eager는 안쓰는 것을 권장
    // 양방향 매핑이니까 Review 쪽에도 매핑해줘야한다.
    @OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY)
    private List<Review> reviews;

}
