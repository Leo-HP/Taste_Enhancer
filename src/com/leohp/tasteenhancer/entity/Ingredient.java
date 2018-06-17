package com.leohp.tasteenhancer.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * JPA entity using annotation
 * creating the table with the name "Ingredient"
 */
@Entity
@Table(name = "Ingredient")
public class Ingredient implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4315148168941618220L;
    // id is auto generated
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    // Many to many relationship : an ingredient as many categories and a category as many ingredients, the link is made via a table matching the ids
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ingredient_category",
            joinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    private List<Category> categories;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ingredient_taste",
            joinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "taste_id", referencedColumnName = "id"))
    private List<Taste> tastes;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ingredient_origin",
            joinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "origin_id", referencedColumnName = "id"))
    private List<Origin> origins;

    // Many to many relationship mapped in the Recipe class
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "ingredients")
    private List<Recipe> recipes;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ingredient_season",
            joinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "season_id", referencedColumnName = "id"))
    private List<Season> seasons;

    // Constructors
    public Ingredient() {
    }

    public Ingredient(String name, List<Category> categories, List<Taste> tastes, List<Origin> origins, List<Season> seasons) {
        this.name = name;
        this.categories = categories;
        this.tastes = tastes;
        this.origins = origins;
        this.seasons = seasons;
    }

    // override of hascode method for making possible the use of converters
    @Override
    public int hashCode() {
        return Objects.hash(id, name, categories, origins, recipes, seasons, tastes);
    }

    // override of equals method for making possible the use of converters
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Ingredient)) return false;

        Ingredient other = (Ingredient) obj;
        return Objects.equals(id, other.id) && Objects.equals(name, other.name);// && Objects.equals(categories, other.categories) && Objects.equals(origins, other.origins) && Objects.equals(recipes, other.recipes) && Objects.equals(seasons, other.seasons) && Objects.equals(tastes, other.tastes);
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Taste> getTastes() {
        return tastes;
    }

    public void setTastes(List<Taste> tastes) {
        this.tastes = tastes;
    }

    public List<Origin> getOrigins() {
        return origins;
    }

    public void setOrigins(List<Origin> origins) {
        this.origins = origins;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public List<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }


}
