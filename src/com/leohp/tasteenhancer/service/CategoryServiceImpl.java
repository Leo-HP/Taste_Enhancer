package com.leohp.tasteenhancer.service;

import com.leohp.tasteenhancer.dao.CategoryDao;
import com.leohp.tasteenhancer.entity.Category;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@Stateless
public class CategoryServiceImpl implements CategoryService {

    @EJB
    private CategoryDao categoryDao;

    private DataModel categories;

    @Override
    public DataModel getCategories() {
        if (categories == null) {
            categories = new ListDataModel();
            categories.setWrappedData(categoryDao.findAll());
        }
        return categories;
    }

    @Override
    public void addCategory(Category category) {
        categoryDao.create(category);
        categories.setWrappedData(categoryDao.findAll());
    }

    @Override
    public String updateCategory(Category category) {
        categoryDao.update(category);
        categories.setWrappedData(categoryDao.findAll());
        return "category-list";
    }

    @Override
    public String deleteCategory(Category category) {
        categoryDao.remove(category);
        categories.setWrappedData(categoryDao.findAll());
        return "category-list";
    }

    @Override
    public Category findCategoryById(Long id){
        Category category = categoryDao.findById(id);
        return category;
    }

    public void setCategories(DataModel categories) {
        this.categories = categories;
    }
}
