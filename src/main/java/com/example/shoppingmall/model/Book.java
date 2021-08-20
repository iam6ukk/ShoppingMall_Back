package com.example.shoppingmall.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.LongStream;

@Data
@Entity
@Table(name = "Books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, name = "bookid", nullable = false)
    private int bookid;

    @Column(name="bookname")
    private String bookname;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "author")
    private String author;

    @Column(name = "price")
    private int price;

    @Column(name = "bookurl")
    private String bookurl;

    @Column(name = "description")
    private String description;

    @Column(name = "publishdate")
    private LocalDateTime publishdate;

}
