package com.example.shoppingmall.service.impl;

import com.example.shoppingmall.dto.BooksDto;
import com.example.shoppingmall.mapper.MallMapper;
import com.example.shoppingmall.service.MallService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MailServiceImpl implements MallService {

    @Resource
    private MallMapper mallMapper;

    @Override
    public List<BooksDto> getBooksList(){
        return mallMapper.getBooksList();
    }
}
