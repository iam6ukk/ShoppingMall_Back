package com.example.shoppingmall.mapper;

import com.example.shoppingmall.dto.BooksDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MallMapper {

    List<BooksDto> getBooksList();
}
