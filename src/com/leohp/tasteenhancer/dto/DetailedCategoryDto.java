package com.leohp.tasteenhancer.dto;

import java.io.Serializable;
import java.util.List;

public class DetailedCategoryDto implements Serializable {

    private Long id;
    private String name;

    private List<CategoryIngredientDto> ingredientDtoList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CategoryIngredientDto> getIngredientDtoListList() {
        return ingredientDtoList;
    }

    public void setIngredientList(List<CategoryIngredientDto> ingredientDtoList) {
        this.ingredientDtoList = ingredientDtoList;
    }

    public DetailedCategoryDto() {

    }

    private DetailedCategoryDto(Long id, String name, List<CategoryIngredientDto> ingredientList) {
        this.id = id;
        this.name = name;
        this.ingredientDtoList = ingredientList;
    }

    /*public static DetailedCategoryDto categoryToDTO(Category category){
        List<Product> pList =  category.getCategoryProducts();
        List<CategoryProductDTO> products = new ArrayList<CategoryProductDTO>();
        for (Product p : pList){
            products.add(CategoryProductDTO.productToDTO(p));
        }
        return new DetailedCategoryDTO(category.getId(), category.getName(), products);
    }

    public static List<DetailedCategoryDTO> categoriesToCategoriesDto(List<Category> categoryList){
        List<DetailedCategoryDTO> detailedCategoryDTOList = new ArrayList<>();
        for (Category c : categoryList){
            detailedCategoryDTOList.add(DetailedCategoryDTO.categoryToDTO(c));
        }
        return detailedCategoryDTOList;
    }*/
}
