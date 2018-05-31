package com.leohp.tasteenhancer.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author LeoHP
 */
@Entity
@Table(name = "ingredients")
public class Ingredient implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4315148168941618220L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name="ingredient_category",
            joinColumns=@JoinColumn(name="ingredient_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="category_id", referencedColumnName="id"))
    private List<Category> categories;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name="ingredient_taste",
            joinColumns=@JoinColumn(name="ingredient_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="taste_id", referencedColumnName="id"))
    private List<Taste> tastes;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name="ingredient_origin",
            joinColumns=@JoinColumn(name="ingredient_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="origin_id", referencedColumnName="id"))
    private List<Origin> origins;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "ingredients")
    private List<Recipe> recipes;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name="ingredient_season",
            joinColumns=@JoinColumn(name="ingredient_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="season_id", referencedColumnName="id"))
    private List<Season> seasons;

    public Ingredient() {
    }

    public Ingredient(String name, List<Category> categories, List<Taste> tastes, List<Origin> origins, List<Season> seasons) {
        this.name = name;
        this.categories = categories;
        this.tastes = tastes;
        this.origins = origins;
        this.seasons = seasons;
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
