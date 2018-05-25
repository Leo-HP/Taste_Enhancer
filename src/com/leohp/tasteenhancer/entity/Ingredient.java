package com.leohp.tasteenhancer.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * @author LeoHP
 *
 */
@Entity
@Table(name="ingredients")
public class Ingredient implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4315148168941618220L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany(mappedBy="ingredients")
    private List<Category> categories;

    @ManyToMany(mappedBy="ingredients")
    private List<Taste> tastes;

    @ManyToMany(mappedBy="ingredients")
    private List<Origin> origins;

    @ManyToMany(mappedBy="ingredients")
    private List<Recipe> recipes;

    @ManyToMany(mappedBy="ingredients")
    private List<Season> seasons;

    public Ingredient() {
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
