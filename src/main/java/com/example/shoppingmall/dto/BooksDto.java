package com.example.shoppingmall.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BooksDto {

    public int bookid;
    public String bookname;
    public String publisher;
    public String author;
    public int price;
    public String bookurl;
    public String description;
    public LocalDateTime publishdate;

}
