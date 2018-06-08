package com.leohp.tasteenhancer.bean;

import com.leohp.tasteenhancer.entity.Origin;
import com.leohp.tasteenhancer.service.OriginService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import java.io.Serializable;

@ManagedBean(name = "originBean")
@SessionScoped
public class OriginBean implements Serializable {

    @EJB
    private OriginService originService;
    private DataModel origins;
    private Origin origin;

    public OriginBean() {
        this.origin = new Origin();
    }

    public DataModel getOrigins() {
        origins = originService.getOrigins();
        return origins;
    }

    public String addOrigin() {
        origin.setId(null);
        originService.addOrigin(origin);
        return "success";
    }

    public void deleteOrigin() {
        origin = (Origin) origins.getRowData();
        originService.deleteOrigin(origin);
    }

    public String editOrigin() {
        origin = (Origin) origins.getRowData();
        return "edit";
    }

    public String updateOrigin() {
        originService.updateOrigin(origin);
        return "success";
    }

    public OriginService getOriginService() {
        return originService;
    }

    public void setOriginService(OriginService originService) {
        this.originService = originService;
    }


    public void setOrigins(DataModel origins) {
        this.origins = origins;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }
}
