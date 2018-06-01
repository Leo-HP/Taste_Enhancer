package com.leohp.tasteenhancer.service;

import com.leohp.tasteenhancer.dao.OriginDao;
import com.leohp.tasteenhancer.entity.Origin;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@Stateless
public class OriginServiceImpl implements OriginService {

    @EJB
    private OriginDao originDao;

    private DataModel origins;

    @Override
    public DataModel getOrigins() {
        if (origins == null) {
            origins = new ListDataModel();
            origins.setWrappedData(originDao.findAll());
        }
        return origins;
    }

    @Override
    public void addOrigin(Origin origin) {
        originDao.create(origin);
        origins.setWrappedData(originDao.findAll());
    }

    @Override
    public String updateOrigin(Origin origin) {
        originDao.update(origin);
        origins.setWrappedData(originDao.findAll());
        return "origin-list";
    }

    @Override
    public String deleteOrigin(Origin origin) {
        originDao.remove(origin);
        origins.setWrappedData(originDao.findAll());
        return "origin-list";
    }

    public void setOrigins(DataModel origins) {
        this.origins = origins;
    }
}
