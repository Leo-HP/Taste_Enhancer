package com.leohp.tasteenhancer.converter;

import com.leohp.tasteenhancer.bean.IngredientBean;
import com.leohp.tasteenhancer.entity.Ingredient;
import com.leohp.tasteenhancer.service.IngredientService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.faces.convert.Converter;

@FacesConverter(forClass = Ingredient.class)
@Stateless
public class IngredientConverter implements Converter  {



    public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
        if (modelValue == null) {
            return "";
        }

        if (modelValue instanceof Ingredient) {
            return String.valueOf(((Ingredient) modelValue).getId());
        } else {
            throw new ConverterException(new FacesMessage(modelValue + " is not a valid Ingredient"));
        }
    }

    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {

        IngredientBean ingredientBean = context.getApplication().evaluateExpressionGet(context, "#{ingredientBean}", IngredientBean.class);
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }

        try {
            return ingredientBean.getIngredientService().findIngredientById(Long.valueOf(submittedValue));
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(submittedValue + " is not a valid Ingredient ID"), e);
        }
    }
}
