package com.example.shoppingmall.service.impl;

import com.example.shoppingmall.dto.BooksDto;
import com.example.shoppingmall.mapper.MallMapper;
import com.example.shoppingmall.service.MallService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.print.Book;
import java.util.List;

@Service("mallService")
public class MailServiceImpl implements MallService {

    @Resource
    private MallMapper mallMapper;

    // 도서 목록
    @Override
    public List<BooksDto> getBooksList(){
        return mallMapper.getBooksList();
    }

    // 도서 목록 + 페이징
    public List<BooksDto> getPageBookList(int page, int pageSize){
        List<BooksDto> result = null;

        try{
            PageHelper.startPage(page, pageSize);
            PageHelper.orderBy("bookid ASC");
            result = mallMapper.getPageBookList();
        } catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    // 도서 상세
    @Override
    public BooksDto detailBook(int bookid){
        BooksDto resultBook = mallMapper.detailBook(bookid);

        return resultBook;
    }

}
