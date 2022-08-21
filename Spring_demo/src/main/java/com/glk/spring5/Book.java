package com.glk.spring5;

public class Book {

    private String name;
    private String bauthor;

    public Book() {
    }

    public Book(String name, String bauthor) {
        this.name = name;
        this.bauthor = bauthor;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }
}
