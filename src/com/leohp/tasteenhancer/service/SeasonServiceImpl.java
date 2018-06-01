package com.leohp.tasteenhancer.service;

import com.leohp.tasteenhancer.dao.SeasonDao;
import com.leohp.tasteenhancer.entity.Season;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@Stateless
public class SeasonServiceImpl implements SeasonService {

    @EJB
    private SeasonDao seasonDao;

    private DataModel seasons;

    @Override
    public DataModel getSeasons() {
        if (seasons == null) {
            seasons = new ListDataModel();
            seasons.setWrappedData(seasonDao.findAll());
        }
        return seasons;
    }

    @Override
    public void addSeason(Season season) {
        seasonDao.create(season);
        seasons.setWrappedData(seasonDao.findAll());
    }

    @Override
    public String updateSeason(Season season) {
        seasonDao.update(season);
        seasons.setWrappedData(seasonDao.findAll());
        return "season-list";
    }

    @Override
    public String deleteSeason(Season season) {
        seasonDao.remove(season);
        seasons.setWrappedData(seasonDao.findAll());
        return "season-list";
    }
}
