package com.leohp.tasteenhancer.dto;

public class CreateRecipe {

    private String name;

    public CreateRecipe() {
    }

    public CreateRecipe(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
