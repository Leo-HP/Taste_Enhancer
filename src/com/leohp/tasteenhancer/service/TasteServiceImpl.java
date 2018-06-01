package com.leohp.tasteenhancer.service;

import com.leohp.tasteenhancer.dao.TasteDao;
import com.leohp.tasteenhancer.entity.Taste;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@Stateless
public class TasteServiceImpl implements TasteService {

    @EJB
    private TasteDao tasteDao;

    private DataModel tastes;

    @Override
    public DataModel getTastes() {
        if (tastes == null) {
            tastes = new ListDataModel();
            tastes.setWrappedData(tasteDao.findAll());
        }
        return tastes;
    }

    @Override
    public void addTaste(Taste taste) {
        tasteDao.create(taste);
        tastes.setWrappedData(tasteDao.findAll());
    }

    @Override
    public String updateTaste(Taste taste) {
        tasteDao.update(taste);
        tastes.setWrappedData(tasteDao.findAll());
        return "taste-list";
    }

    @Override
    public String deleteTaste(Taste taste) {
        tasteDao.remove(taste);
        tastes.setWrappedData(tasteDao.findAll());
        return "taste-list";
    }
}
