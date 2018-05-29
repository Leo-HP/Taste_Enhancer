package com.leohp.tasteenhancer.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="recipes")
public class Recipe implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 4653427093390849431L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(name="recipe_ingredient",
            joinColumns=@JoinColumn(name="recipe_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="ingredient_id", referencedColumnName="id"))
    private List<Ingredient> ingredients;

    public Recipe() {
        // TODO Auto-generated constructor stub
    }

    public Recipe(String name) {
        this.name = name;
    }

    public Recipe(String name, List<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }



}
