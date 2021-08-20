package com.example.shoppingmall.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, name = "custnum", nullable = false)
    private int custnum;

    @Column(name = "custid")
    private String custid;

    @Column(name = "custpwd")
    private String custpwd;

    @Column(name = "custname")
    private String custname;

}
