package com.example.shoppingmall.service.impl;

import com.example.shoppingmall.dto.BooksDto;
import com.example.shoppingmall.dto.CustomersDto;
import com.example.shoppingmall.dto.request.LoginRequestDto;
import com.example.shoppingmall.dto.request.idCheckRequestDto;
import com.example.shoppingmall.dto.response.LoginResponseDto;
import com.example.shoppingmall.dto.response.idCheckResponseDto;
import com.example.shoppingmall.mapper.MallMapper;
import com.example.shoppingmall.model.Book;
import com.example.shoppingmall.model.Customer;
import com.example.shoppingmall.service.MallService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.catalina.util.CustomObjectInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

@Service("mallService")
public class MailServiceImpl implements MallService {


    @Resource
    private MallMapper mallMapper;

    // 도서 목록
//    @Override
//    public List<BooksDto> getBooksList(){
//        return mallMapper.getBooksList();
//    }

    // 도서 목록 + 페이징 (model)
    @Override
    public List<Book> getPageBookList(int page, int pageSize){

        List<Book> result = new ArrayList<>();

        try{
            PageHelper.startPage(page, pageSize);
            PageHelper.orderBy("bookid ASC");
            result = mallMapper.getPageBookList();

//            PageInfo<Book> = new PageInfo<>(resultList);

//            List<Book> resultList = mallMapper.getPageBookList();
//            resultList.forEach(book -> result.add(new BooksDto().builder()
//                            .bookid(book.getBookid())
//                            .bookname(book.getBookname())
//                            .bookurl(book.getBookurl())
//                            .publisher(book.getPublisher())
//                            .price(book.getPrice())
//                            .author(book.getAuthor())
//                            .description(book.getDescription())
//                            .publishdate(book.getPublishdate())
//                            .build()));

        } catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

//    // 도서 목록 + 페이징 (model -> dto)
//    @Override
//    public List<BooksDto> getPageBookList(int page, int pageSize){
////        List<Book> resultList = new ArrayList<Book>();
//
//        List<Book> result = new ArrayList<>();
//        PageInfo<BooksDto> resultBooks = new PageInfo<>();
//
//        try{
//            PageHelper.startPage(page, pageSize);
//            PageHelper.orderBy("bookid ASC");
//            // mapper 실행 후 후 처리 함
//
//            result = mallMapper.getPageBookList();
//            // Mapper 함수 호츨 결과 값 result에
//
//
//            PageInfo<BooksDto> resultBooks = new PageInfo<BooksDto>(result.forEach(book -> resultBooks.add(new BooksDto().builder()
//                        .bookid(book.getBookid())
//                        .bookname(book.getBookname())
//                        .bookurl(book.getBookurl())
//                        .publishdate(book.getPublishdate())
//                        .description(book.getDescription())
//                        .author(book.getAuthor())
//                        .price(book.getPrice())
//                        .publishdate(book.getPublishdate())
//                        .build())));
//
//            result.forEach(book -> resultBooks.add(new BooksDto().builder()
//                            .bookid(book.getBookid())
//                            .bookname(book.getBookname())
//                            .bookurl(book.getBookurl())
//                            .publisher(book.getPublisher())
//                            .price(book.getPrice())
//                            .author(book.getAuthor())
//                            .description(book.getDescription())
//                            .publishdate(book.getPublishdate())
//                            .build()));
//
//
//        } catch(Exception e){
//            e.printStackTrace();
//        }
//        return resultBooks;
//    }

    // 도서 상세
    @Override
    public BooksDto detailBook(int bookid){
        Book result = null;
        BooksDto resultDto = new BooksDto();

        result = mallMapper.detailBook(bookid);
        return new BooksDto().builder()
                .bookid(result.getBookid())
                .bookname(result.getBookname())
                .bookurl(result.getBookurl())
                .publisher(result.getPublisher())
                .price(result.getPrice())
                .author(result.getAuthor())
                .description(result.getDescription())
                .publishdate(result.getPublishdate())
                .build();
    }


    // 로그인
    @Override
    public LoginResponseDto logIn(LoginRequestDto loginRequestDto) {
        LoginResponseDto l = mallMapper.logIn(loginRequestDto);
        System.out.println("Impl 실행 결과 => " + l);

        if (l == null) {
            l.setResultCode(-1);
            System.out.println("l =>" + l.getResultCode());
        }

        return l;
    }

    //회원가입
    @Override
    public CustomersDto insertCustInfo(CustomersDto customersDto){
        return mallMapper.insertCustInfo(customersDto);
    }

    // 아이디 중복확인
    @Override
    public idCheckResponseDto custIdCheck(idCheckRequestDto checkRequestDto) {
        return mallMapper.custIdCheck(checkRequestDto);
    }
}
