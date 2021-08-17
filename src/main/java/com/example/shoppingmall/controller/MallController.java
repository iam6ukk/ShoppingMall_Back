package com.example.shoppingmall.controller;

import com.example.shoppingmall.dto.BooksDto;
import com.example.shoppingmall.service.MallService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.awt.print.Book;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
// cors 문제 해결하기 위해
@RequestMapping(value = "/api")
public class MallController {

    @Resource
    private MallService mallService;

    // 테스트
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Object test() {
        return "Hello World";
    }

    // 도서 목록 가져오기
//    @GetMapping("/books")
//    public List<BooksDto> getBooks(){
//        return mallService.getBooksList();
//    }

    // 도서 목록 + 페이징
    @GetMapping("/books")
    public PageInfo<BooksDto> getPageBooks(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int page) {
        List<BooksDto> result = mallService.getPageBookList(page, 6);
        PageInfo<BooksDto> pi = new PageInfo<BooksDto>(result);
        System.out.println("reuslt => " + result);
        return pi;
    } //defaultValue = "1"


    // 도서 상세
    @GetMapping("/books/{bookid}")
    public BooksDto detailBook(@PathVariable int bookid){
        BooksDto detail = mallService.detailBook(bookid);
        System.out.println("detail => " + detail);
        return detail;
    }

    // 로그인 



}
