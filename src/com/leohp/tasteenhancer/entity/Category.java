package com.leohp.tasteenhancer.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * JPA entity using annotation
 * creating the table with the name "Category"
 */
@Entity
@Table(name = "Category")
public class Category implements Serializable {

    private static final long serialVersionUID = -3147486974618264158L;
    // id auto generated
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    // many to many relationship, joined table is declared in Ingredient
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "categories")
    private List<Ingredient> ingredients;

    // Constructors
    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }


    // getters and setters
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
