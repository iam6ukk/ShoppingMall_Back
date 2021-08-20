package com.example.shoppingmall.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrdersDto {

    public Integer orderid;
    public Integer custnum;
    public Integer bookid;
    public Integer orderprice;
    public LocalDateTime orderdate;
}
