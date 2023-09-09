package com.example.member.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor // 생성자 자동 생성
@AllArgsConstructor // 모든 필드를 매개변수로 하는 생성자 생성
// 회원정보에 필요한 정보를 필드로 정의
public class MemberDTO {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
}
