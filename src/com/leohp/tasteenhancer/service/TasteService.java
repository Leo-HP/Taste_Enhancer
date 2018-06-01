package com.leohp.tasteenhancer.service;

import com.leohp.tasteenhancer.entity.Taste;

import javax.ejb.Local;
import javax.faces.model.DataModel;

@Local
public interface TasteService {

    DataModel getTastes();

    void addTaste(Taste taste);

    String updateTaste(Taste taste);

    String deleteTaste(Taste taste);
}
