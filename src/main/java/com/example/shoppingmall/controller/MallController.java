package com.example.shoppingmall.controller;

import com.example.shoppingmall.dto.BooksDto;
import com.example.shoppingmall.dto.CustomersDto;
import com.example.shoppingmall.service.MallService;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
        System.out.println("페이징 결과 => " + result);
        return pi;
    } //defaultValue = "1"


    // 도서 상세
    @GetMapping("/books/{bookid}")
    public BooksDto detailBook(@PathVariable int bookid){
        BooksDto detail = mallService.detailBook(bookid);
        System.out.println("도서 상세 조회 => " + detail);
        return detail;
    }

    @Autowired
    private HttpSession httpSession;

    // 로그인 (세션 요청/생성)
    @PostMapping("/books")
    public CustomersDto login(@RequestBody CustomersDto customersDto, HttpServletRequest request){
       System.out.println("전달된 로그인 정보 => " + customersDto);

        CustomersDto LoginUser = mallService.logIn(customersDto);

        httpSession = request.getSession();
        // 세션 객체 생성
//        boolean isNew = httpSession.isNew();
        // 새롭게 생성된 세션인지 확인

       httpSession.setAttribute("SessionKey", LoginUser);
       // 세션 설정

//       httpSession.getAttribute("SessionKey");
//       String LoginUser = (String) httpSession.getAttribute("SessionKey");
       // 세션 받아오기
//       System.out.println("세션 정보 => " + LoginUser);

       return LoginUser;
    }

}
