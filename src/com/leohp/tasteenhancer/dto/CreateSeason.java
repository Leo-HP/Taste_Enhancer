package com.leohp.tasteenhancer.dto;

public class CreateSeason {
    private String name;

    public CreateSeason() {
    }

    public CreateSeason(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
