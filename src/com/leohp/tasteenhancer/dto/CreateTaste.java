package com.leohp.tasteenhancer.dto;

public class CreateTaste {

    private String name;

    public CreateTaste() {
    }

    public CreateTaste(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
