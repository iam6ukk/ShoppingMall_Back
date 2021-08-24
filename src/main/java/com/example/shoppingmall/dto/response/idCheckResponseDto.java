package com.example.shoppingmall.dto.response;

import lombok.Data;

@Data
public class idCheckResponseDto {
    private int resultCode = 1; // 아이디 중복 아닐 경우
    private String custid;
}
