package com.leohp.tasteenhancer.dto;

public class CreateCategory {

    private String name;

    public CreateCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
