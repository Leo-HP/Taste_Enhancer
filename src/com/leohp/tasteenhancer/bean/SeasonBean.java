package com.leohp.tasteenhancer.bean;

import com.leohp.tasteenhancer.entity.Season;
import com.leohp.tasteenhancer.service.SeasonService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;


@ManagedBean(name = "seasonBean")
@SessionScoped
public class SeasonBean {

    @EJB
    private SeasonService seasonService;
    private DataModel seasons;
    private Season season;

    public SeasonBean() {
        this.season = new Season();
    }

    public DataModel getSeasons() {
        seasons = seasonService.getSeasons();
        return seasons;
    }

    public String addSeason() {
        season.setId(null);
        seasonService.addSeason(season);
        return "success";
    }

    public void deleteSeason() {
        season = (Season) seasons.getRowData();
        seasonService.deleteSeason(season);
    }

    public String editSeason() {
        season = (Season) seasons.getRowData();
        return "edit";
    }

    public String updateSeason() {
        seasonService.updateSeason(season);
        return "success";
    }

    public SeasonService getSeasonService() {
        return seasonService;
    }

    public void setSeasonService(SeasonService seasonService) {
        this.seasonService = seasonService;
    }

    public void setSeasons(DataModel seasons) {
        this.seasons = seasons;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }
}
