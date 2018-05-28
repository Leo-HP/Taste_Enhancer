package com.leohp.tasteenhancer.dao.jpa;

import com.leohp.tasteenhancer.dao.CategoryDao;
import com.leohp.tasteenhancer.entity.Category;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

@Stateless
public class JpaCategoryDao implements CategoryDao {


    @PersistenceContext(name="PU")
    private EntityManager entityManager;

    public JpaCategoryDao() {
    }

    @Override
    public void create(Category object) {
            entityManager.persist(object);
    }

    @Override
    public Category findById(Long id) {
        Category category = entityManager.find(Category.class, id);
        return category;
    }

    @Override
    public List<Category> findAll() {
        Query query = entityManager.createQuery("Select categories from Category categories");
        List<Category> results = query.getResultList();
        return results;
    }

    @Override
    public void update(Category object) {
        Query query = entityManager.createQuery("update Category cat set cat.name=:name, cat.ingredients=:ingredients where cat.id=:id");
        query.setParameter("name", object.getName());
        query.setParameter("id", object.getId());
        query.setParameter("ingredients", object.getIngredients());
        query.executeUpdate();
    }

    @Override
    public void remove(Long id) {

        Category category = entityManager.find(Category.class, id);
        entityManager.remove(category);
    }

    @Override
    public void remove(Category object) {

            Category category = entityManager.find(Category.class, object.getId());
            entityManager.remove(category);

    }
}
