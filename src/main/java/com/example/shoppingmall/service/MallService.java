package com.example.shoppingmall.service;

import com.example.shoppingmall.dto.BooksDto;
import com.example.shoppingmall.dto.CustomersDto;
import com.example.shoppingmall.dto.request.LoginRequestDto;
import com.example.shoppingmall.dto.request.idCheckRequestDto;
import com.example.shoppingmall.dto.response.LoginResponseDto;
import com.example.shoppingmall.dto.response.idCheckResponseDto;
import com.example.shoppingmall.model.Book;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface MallService {
    // Service는 재사용성과 확장성을 위해 인터페이스와 구현으로 분리함

    // 도서 목록
//    List<BooksDto> getBooksList();

    // 도서 목록 + 페이징 (model)
    List<Book> getPageBookList(int page, int pageSize);

    // 도서 목록 + 페이징 (model -> dto)
//    List<BooksDto> getPageBookList(int page, int pageSize);
//    PageInfo<BooksDto> getPageBookList(int page, int pageSize);


    // 도서 상세
    BooksDto detailBook(int bookid);

    // 로그인
    LoginResponseDto logIn(LoginRequestDto loginRequestDto);

    // 회원가입
    CustomersDto insertCustInfo(CustomersDto customersDto);

    // 아이디 중복 확인
    idCheckResponseDto custIdCheck(idCheckRequestDto checkRequestDto);
}

