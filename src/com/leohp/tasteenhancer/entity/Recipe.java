package com.leohp.tasteenhancer.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * JPA entity using annotation
 * creating the table with the name "Recipe"
 */
@Entity
@Table(name = "Recipe")
public class Recipe implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 4653427093390849431L;
    // id is auto generated
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    // Many to many relationship : a recipe as many ingredients and an ingredient as many recipes, the link is made via a table matching the ids
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "recipe_ingredient",
            joinColumns = @JoinColumn(name = "recipe_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id"))
    private List<Ingredient> ingredients;

    // Constructors
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
