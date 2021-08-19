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

    public Integer bookId;
    public String bookName;
    public String publisher;
    public String author;
    public Integer price;
    public String bookUrl;
    public String description;
    public LocalDateTime publishDate;

}
