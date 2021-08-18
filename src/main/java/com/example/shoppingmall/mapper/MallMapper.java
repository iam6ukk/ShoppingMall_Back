package com.example.shoppingmall.mapper;

import com.example.shoppingmall.dto.BooksDto;
import com.example.shoppingmall.dto.CustomersDto;
import org.apache.ibatis.annotations.Mapper;

import java.awt.datatransfer.Clipboard;
import java.util.List;
import java.util.Map;

@Mapper
public interface MallMapper {

    // 도서 목록
    List<BooksDto> getBooksList();

    // 도서 목록 + 페이징
    List<BooksDto> getPageBookList();

    // 도서 상세
    BooksDto detailBook(int bookid);

    // 로그인
    CustomersDto logIn(CustomersDto customersDto);
}
