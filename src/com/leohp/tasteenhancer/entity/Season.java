package com.leohp.tasteenhancer.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="seasons")
public class Season implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 7435802340771144323L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(name="season_ingredient",
            joinColumns=@JoinColumn(name="season_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="ingredient_id", referencedColumnName="id"))
    private List<Ingredient> ingredients;

    public Season() {
        // TODO Auto-generated constructor stub
    }

    public Season(String name) {
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

