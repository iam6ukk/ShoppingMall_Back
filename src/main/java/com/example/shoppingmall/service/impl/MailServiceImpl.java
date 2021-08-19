package com.example.shoppingmall.service.impl;

import com.example.shoppingmall.dto.BooksDto;
import com.example.shoppingmall.dto.request.LoginRequestDto;
import com.example.shoppingmall.dto.response.LoginResponseDto;
import com.example.shoppingmall.mapper.MallMapper;
import com.example.shoppingmall.model.Book;
import com.example.shoppingmall.service.MallService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("mallService")
public class MailServiceImpl implements MallService {


    @Resource
    private MallMapper mallMapper;

    // 도서 목록
//    @Override
//    public List<BooksDto> getBooksList(){
//        return mallMapper.getBooksList();
//    }

    // 도서 목록 + 페이징
    @Override
    public List<BooksDto> getPageBookList(int page, int pageSize){
        List<Book> result = null;

//        BooksDto resultDto = new BooksDto();
        List<BooksDto> resultList = new ArrayList<>();
        try{
            PageHelper.startPage(page, pageSize);
            PageHelper.orderBy("bookId ASC");
            result = mallMapper.getPageBookList();
            result.stream()
                    .forEach(book -> resultList.add(new BooksDto().builder()
                            .bookId(book.getBookId())
                            .bookName(book.getBookName())
                            .bookUrl(book.getBookUrl())
                            .publisher(book.getPublisher())
                            .price(book.getPrice())
                            .author(book.getAuthor())
                            .description(book.getDescription())
                            .publishDate(book.getPublishDate())
                            .build()));
        } catch(Exception e){
            e.printStackTrace();
        }
        return resultList;
    }

    // 도서 상세
    @Override
    public BooksDto detailBook(Integer bookId){
        Book result = null;
        BooksDto resultDto = new BooksDto();

        result = mallMapper.detailBook(bookId);
        return new BooksDto().builder()
                .bookId(result.getBookId())
                .bookName(result.getBookName())
                .author(result.getAuthor())
                .bookUrl(result.getBookUrl())
                .publisher(result.getPublisher())
                .price(result.getPrice())
                .description(result.getDescription())
                .publishDate(result.getPublishDate())
                .build();
    }

    // 로그인
    @Override
    public LoginResponseDto logIn(LoginRequestDto loginRequestDto){

//        CustomersDto c = new CustomersDto();
//        c = mallMapper.logIn(loginRequestDto);

//        if (c == null)  l.setResultCode(-1);
//        LoginResponseDto l = new LoginResponseDto();

        LoginResponseDto l = mallMapper.logIn(loginRequestDto);
        System.out.println("Impl 실행 결과 => " + l);

        if(l == null){
            l.setResultCode(-1);
            System.out.println("l =>" + l);
        }
        return l;
    }
}
