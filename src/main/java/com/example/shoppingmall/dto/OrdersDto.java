package com.example.shoppingmall.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrdersDto {

    public Integer orderId;
    public Integer custNum;
    public Integer bookId;
    public Integer orderPrice;
    public String orderDate;
}
