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
    private int orderid;

    @Column(name = "custnum")
    private int custnum;

    @Column(name = "bookid")
    private int bookid;

    @Column(name = "orderprice")
    private int orderprice;

    @Column(name = "orderdate")
    private LocalDateTime orderdate;
}
