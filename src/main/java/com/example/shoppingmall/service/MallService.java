package com.example.shoppingmall.service;

import com.example.shoppingmall.dto.BooksDto;

import java.awt.datatransfer.Clipboard;
import java.util.List;

public interface MallService {

    // 도서 목록
    List<BooksDto> getBooksList();

    // 도서 목록 + 페이징
    List<BooksDto> getPageBookList(int page, int pageSize);

    //도서 상세
    BooksDto detailBook(int bookid);
}
