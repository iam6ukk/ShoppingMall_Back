package com.example.shoppingmall.mapper;


import com.example.shoppingmall.dto.CustomersDto;
import com.example.shoppingmall.dto.request.idCheckRequestDto;
import com.example.shoppingmall.model.Book;
import com.example.shoppingmall.dto.request.LoginRequestDto;

import com.example.shoppingmall.dto.response.LoginResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MallMapper {

    // 도서 목록s
//    List<Book> getBooksList();

    // 도서 목록 + 페이징 (model)
    List<Book> getPageBookList();

    // 도서 목록 + 페이징 (dto)
//        List<BooksDto> getPageBookList();

    // 도서 상세
    Book detailBook(int bookid);

    // 로그인
    LoginResponseDto logIn(LoginRequestDto loginRequestDto);

    // 회원가입
    CustomersDto insertCustInfo(CustomersDto customersDto);

    // 아이디 중복 검사
    int custIdCheck(String custid);

}
