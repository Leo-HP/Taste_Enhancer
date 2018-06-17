package com.leohp.tasteenhancer.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * JPA entity using annotation
 * creating the table with the name "Origin"
 */
@Entity
@Table(name="Origin")
public class Origin implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -6763441304028667915L;

    // id is auto generated
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    // Many to many relationship mapped in the Ingredient class
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "origins")
    private List<Ingredient> ingredients;

    // Constructors
    public Origin() {

    }

    public Origin(String name) {
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

