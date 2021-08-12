package com.example.shoppingmall.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrdersDto {

    public int orderid;
    public int custnum;
    public int bookid;
    public int orderprice;
    public LocalDateTime orderdate;
}
