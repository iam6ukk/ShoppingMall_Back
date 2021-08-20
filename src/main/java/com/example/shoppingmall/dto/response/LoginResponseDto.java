package com.example.shoppingmall.dto.response;

import lombok.Data;

@Data
public class LoginResponseDto {

    private Integer resultCode = 1; // 성공일 경우
    private Integer custnum;
    private String custname;
    private String custid;
}
