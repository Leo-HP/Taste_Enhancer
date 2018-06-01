package com.leohp.tasteenhancer.service;

import com.leohp.tasteenhancer.entity.Season;

import javax.ejb.Local;
import javax.faces.model.DataModel;

@Local
public interface SeasonService {

    DataModel getSeasons();

    void addSeason(Season season);

    String updateSeason(Season season);

    String deleteSeason(Season season);
}
