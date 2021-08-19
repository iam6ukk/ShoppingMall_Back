package com.example.shoppingmall.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Orders")
public class Order{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, name = "orderid", nullable = false)
    private Integer orderId;

    @Column(name = "custnum")
    private Integer custNum;

    @Column(name = "bookid")
    private Integer bookId;

    @Column(name = "orderprice")
    private Integer orderPrice;

    @Column(name = "orderdate")
    private LocalDateTime orderDate;
}
