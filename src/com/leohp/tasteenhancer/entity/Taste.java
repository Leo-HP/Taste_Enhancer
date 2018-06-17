package com.leohp.tasteenhancer.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * JPA entity using annotation
 * creating the table with the name "Taste"
 */
@Entity
@Table(name = "Taste")
public class Taste implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 3839969660922031842L;
    // id is auto generated
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    // Many to many relationship mapped in the Ingredient class
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "tastes")
    private List<Ingredient> ingredients;

    // constructors
    public Taste() {
    }

    public Taste(String name) {
        this.name = name;
    }

    // getter and setters
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

