package com.leohp.tasteenhancer.service;

import com.leohp.tasteenhancer.entity.Origin;

import javax.ejb.Local;
import javax.faces.model.DataModel;

@Local
public interface OriginService {

    DataModel getOrigins();

    void addOrigin(Origin origin);

    String updateOrigin(Origin origin);

    String deleteOrigin(Origin origin);
}
