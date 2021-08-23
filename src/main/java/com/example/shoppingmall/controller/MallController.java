package com.example.shoppingmall.controller;

import com.example.shoppingmall.dto.BooksDto;

import com.example.shoppingmall.dto.response.LoginResponseDto;
import com.example.shoppingmall.model.Book;
import com.example.shoppingmall.service.MallService;
import com.github.pagehelper.PageInfo;
import com.example.shoppingmall.dto.request.LoginRequestDto;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
// cors 문제 해결하기 위해
@RequestMapping(value = "/api/books")
public class MallController {

    @Resource
    private MallService mallService;



    // 도서 목록 가져오기
//    @GetMapping("/books")
//    public List<BooksDto> getBooks(){
//        return mallService.getBooksList();
//    }

    // 도서 목록 + 페이징 (model)
    @GetMapping("")
    public PageInfo<Book> getPageBooks(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int page) {
        List<Book> result = mallService.getPageBookList(page, 6);
        PageInfo<Book> pi = new PageInfo<Book>(result);
        return pi;
    }


    // 도서 목록 + 페이징 (model -> dto)
//    @GetMapping("")
//    public PageInfo<BooksDto> getPageBooks(
//            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int page) {
////        List<BooksDto> result = mallService.getPageBookList(page, 6);
////        Page<BooksDto> result = mallService.getPageBookList(page, 6);
////        PageInfo<BooksDto> result = mallService.getPageBookList(page, 6);
//
//        List<BooksDto> result = mallService.getPageBookList(page,  6);
//        PageInfo<BooksDto> pi = new PageInfo<BooksDto>(result);
//
//        return pi;
//    }


    // 도서 상세
    @GetMapping("/{bookid}")
    public BooksDto detailBook(@PathVariable int bookid){
        BooksDto detail = mallService.detailBook(bookid);
        System.out.println("도서 상세 조회 => " + detail);

        return detail;
    }

    @Autowired
    private HttpSession httpSession;

    // 로그인 (세션 요청/생성)
    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto, HttpServletRequest request){
       System.out.println("전달받은 로그인 정보 => " + loginRequestDto);

        LoginResponseDto loginResponseDto = mallService.logIn(loginRequestDto);

        if(loginResponseDto.getResultCode() == 1){
            httpSession = request.getSession(true);
            // 생성된 세션이 있다면 세션 반환, 없다면 세션 생성해 반환
            httpSession.setAttribute("LoginUser", loginResponseDto);
            // 세션 설정
            loginResponseDto = (LoginResponseDto) httpSession.getAttribute("LoginUser");
            // 세션 읽기
            System.out.println("로그인 성공");
        } else {
            System.out.println("로그인 실패");
        }

//        loginResponseDto = (LoginResponseDto) httpSession.getAttribute("LoginUser");

        return loginResponseDto;

    }

    // 로그아웃
    @GetMapping("/logout")
    public void logout(HttpServletRequest request) {

        httpSession = request.getSession();
        httpSession.invalidate();
        if (httpSession == null || !request.isRequestedSessionIdValid()) {
            System.out.println("세션이 무효화 상태입니다.");
        }
    }
}
