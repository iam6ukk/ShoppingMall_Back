package com.example.shoppingmall.service.impl;

import com.example.shoppingmall.dto.BooksDto;
import com.example.shoppingmall.mapper.MallMapper;
import com.example.shoppingmall.service.MallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("mallService")
public class MailServiceImpl implements MallService {

    @Resource
    private MallMapper mallMapper;

    @Override
    public List<BooksDto> getBooksList(){
        return mallMapper.getBooksList();
    }

    @Override
    public BooksDto detailBook(int bookid){
        BooksDto resultBook = mallMapper.detailBook(bookid);

        return resultBook;
    }

}
