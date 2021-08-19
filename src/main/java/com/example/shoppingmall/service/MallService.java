package com.example.shoppingmall.service;

import com.example.shoppingmall.dto.BooksDto;
import com.example.shoppingmall.dto.CustomersDto;
import com.example.shoppingmall.dto.request.LoginRequestDto;
import com.example.shoppingmall.dto.response.LoginResponseDto;
import com.example.shoppingmall.model.Book;


import java.util.List;

public interface MallService {
    // Service는 재사용성과 확장성을 위해 인터페이스와 구현으로 분리함

    // 도서 목록
//    List<BooksDto> getBooksList();

    // 도서 목록 + 페이징
    List<BooksDto> getPageBookList(int page, int pageSize);

    // 도서 상세
    BooksDto detailBook(Integer bookId);

    // 로그인
    LoginResponseDto logIn(LoginRequestDto loginRequestDto);

}

