package com.leohp.tasteenhancer.service;

import com.leohp.tasteenhancer.entity.Category;

import javax.ejb.Local;
import javax.faces.model.DataModel;

@Local
public interface CategoryService {

    DataModel getCategories();

    void addCategory(Category category);

    String updateCategory(Category category);

    String deleteCategory(Category category);

    Category findCategoryById(Long id);
}
