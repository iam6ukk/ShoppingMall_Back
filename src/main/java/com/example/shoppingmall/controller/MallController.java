package com.example.shoppingmall.controller;

import com.example.shoppingmall.dto.BooksDto;
import com.example.shoppingmall.service.MallService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
    @GetMapping("/books")
    public List<BooksDto> getBooks(){
        return mallService.getBooksList();
    }
}
