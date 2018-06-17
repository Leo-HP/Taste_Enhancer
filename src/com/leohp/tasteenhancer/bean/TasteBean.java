package com.leohp.tasteenhancer.bean;

import com.leohp.tasteenhancer.entity.Taste;
import com.leohp.tasteenhancer.service.TasteService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;

@ManagedBean(name = "tasteBean")
@SessionScoped
public class TasteBean {

    @EJB
    private TasteService tasteService;
    private DataModel tastes;
    private Taste taste;

    public TasteBean() {
        this.taste = new Taste();
    }

    public DataModel getTastes() {
        tastes = tasteService.getTastes();
        return tastes;
    }

    public String addTaste() {
        taste.setId(null);
        tasteService.addTaste(taste);
        return "success";
    }

    public void deleteTaste() {
        taste = (Taste) tastes.getRowData();
        tasteService.deleteTaste(taste);
    }

    public String editTaste() {
        taste = (Taste) tastes.getRowData();
        return "edit";
    }

    public String updateTaste() {
        tasteService.updateTaste(taste);
        return "success";
    }

    public TasteService getTasteService() {
        return tasteService;
    }

    public void setTasteService(TasteService tasteService) {
        this.tasteService = tasteService;
    }

    public void setTastes(DataModel tastes) {
        this.tastes = tastes;
    }

    public Taste getTaste() {
        return taste;
    }

    public void setTaste(Taste taste) {
        this.taste = taste;
    }
}
