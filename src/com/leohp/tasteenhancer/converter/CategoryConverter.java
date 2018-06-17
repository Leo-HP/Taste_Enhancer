package com.leohp.tasteenhancer.converter;


import com.leohp.tasteenhancer.bean.CategoryBean;
import com.leohp.tasteenhancer.entity.Category;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "categoryConverter")
public class CategoryConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        ValueExpression valueExpression = facesContext.getApplication().getExpressionFactory().createValueExpression(facesContext.getELContext(), "#{categoryBean}", CategoryBean.class);
        CategoryBean categoryBean = (CategoryBean)valueExpression.getValue(facesContext.getELContext());
        return categoryBean.findCategoryById(Long.valueOf(s));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        return ((Category)o).getId().toString();
    }
}
