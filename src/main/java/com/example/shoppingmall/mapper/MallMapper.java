package com.example.shoppingmall.mapper;

import com.example.shoppingmall.dto.BooksDto;
import org.apache.ibatis.annotations.Mapper;

import java.awt.datatransfer.Clipboard;
import java.util.List;

@Mapper
public interface MallMapper {

    // 도서 목록
    List<BooksDto> getBooksList();

    // 도서 목록 + 페이징
    List<BooksDto> getPageBookList();

    // 도서 상세
    BooksDto detailBook(int bookid);
}
