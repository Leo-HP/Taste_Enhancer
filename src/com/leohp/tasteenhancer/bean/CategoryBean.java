package com.leohp.tasteenhancer.bean;

import com.leohp.tasteenhancer.entity.Category;
import com.leohp.tasteenhancer.service.CategoryService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import java.io.Serializable;

@ManagedBean(name = "categoryBean")
@SessionScoped
public class CategoryBean implements Serializable {

    @EJB
    private CategoryService categoryService;
    private DataModel categories;
    private Category category;

    public CategoryBean() {
        this.category = new Category();
    }

    public DataModel getCategories(){
        categories = categoryService.getCategories();
        return categories;
    }

    public String addCategory(){
        category.setId(null);
        categoryService.addCategory(category);
        return "success";
    }

    public void deleteCategory(){
        category = (Category) categories.getRowData();
        categoryService.deleteCategory(category);
    }

    public String editCategory(){
        category = (Category) categories.getRowData();
        return "edit";
    }

    public String updateCategory(){
        categoryService.updateCategory(category);
        return "success";
    }

    public Category findCategoryById(Long id){
        if (id == null){
            throw new IllegalArgumentException("no id provided");
        }
        return categoryService.findCategoryById(id);

    }

    public CategoryService getCategoryService() {
        return categoryService;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public void setCategories(DataModel categories) {
        this.categories = categories;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
