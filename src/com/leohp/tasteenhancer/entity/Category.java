package com.leohp.tasteenhancer.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = -3147486974618264158L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(name="category_ingredient",
            joinColumns=@JoinColumn(name="category_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="ingredient_id", referencedColumnName="id"))
    private List<Ingredient> ingredients;

    public Category() {
    }



    public Category(String name) {
        this.name = name;
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
