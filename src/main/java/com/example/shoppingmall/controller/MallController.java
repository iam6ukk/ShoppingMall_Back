package com.example.shoppingmall.controller;

import com.example.shoppingmall.dto.BooksDto;

import com.example.shoppingmall.dto.request.LoginRequestDto;
import com.example.shoppingmall.dto.response.LoginResponseDto;
import com.example.shoppingmall.service.MallService;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

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

    // 도서 목록 + 페이징
    @GetMapping("")
    public PageInfo<BooksDto> getPageBooks(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int page) {
        List<BooksDto> result = mallService.getPageBookList(page, 6);
        PageInfo<BooksDto> pi = new PageInfo<BooksDto>(result);
        System.out.println("페이징 결과 => " + result);
        return pi;
    }


    // 도서 상세
    @GetMapping("/{bookId}")
    public BooksDto detailBook(@PathVariable Integer bookId){
        BooksDto detail = mallService.detailBook(bookId);
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
        System.out.println("response => " + loginResponseDto);

        if(loginResponseDto.getResultCode() == 1){
            httpSession = request.getSession();
            httpSession.setAttribute("LoginUser", loginResponseDto.getCustNum());
            System.out.println("로그인 성공");
        } else {
            System.out.println("로그인 실패");
        }

        return loginResponseDto;

    }
}
