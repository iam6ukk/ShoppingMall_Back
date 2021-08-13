package com.example.shoppingmall.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BooksDto {

    public int bookid;
    public String bookname;
    public String publisher;
    public String author;
    public int price;
    public String bookurl;
    public String description;
    public String publishdate;

}
