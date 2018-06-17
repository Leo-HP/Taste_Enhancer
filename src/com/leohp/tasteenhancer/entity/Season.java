package com.leohp.tasteenhancer.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * JPA entity using annotation
 * creating the table with the name "Season"
 */
@Entity
@Table(name="Season")
public class Season implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 7435802340771144323L;

    // id is auto generated
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    // Many to many relationship mapped in the Ingredient class
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "seasons")
    private List<Ingredient> ingredients;

    // constructors
    public Season() {
    }

    public Season(String name) {
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

