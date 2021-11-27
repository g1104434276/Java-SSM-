package com.southwind.entity;

import lombok.Data;

import java.util.List;

@Data
public class Goods {
    public long id ;
    public String name;
    public List<Customer> customers;
}
