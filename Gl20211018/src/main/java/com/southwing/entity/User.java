package com.southwing.entity;

import lombok.Data;

@Data
public class User {
    private long id ;
    private String name;
    private Address address;
}