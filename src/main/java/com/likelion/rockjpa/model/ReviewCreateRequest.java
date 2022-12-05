package com.likelion.rockjpa.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ReviewCreateRequest {
    // 사용자가 아래의 요청을 보내면 DB에 기록을 하는 것이다.
    // 이 필드들이 값을 받을 수 있는 변수로 보면 되는 것이지.
    private Long hospitalId;
    private String userName;
    private String title;
    private String content;
}
