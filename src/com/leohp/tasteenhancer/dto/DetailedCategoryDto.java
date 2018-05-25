package com.leohp.tasteenhancer.dto;

import java.io.Serializable;

public class DetailedCategoryDto implements Serializable {

    private Long id;
    private String name;

    private List<CategoryProductDTO> productList;
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

    public List<CategoryIngredientDto> getProductList() {
        return productList;
    }

    public void setProductList(List<CategoryIngredientDto> productList) {
        this.productList = productList;
    }

    public DetailedCategoryDto() {

    }

    private DetailedCategoryDto(Long id, String name, List<CategoryIngredientDto> productList) {
        this.id = id;
        this.name = name;
        this.productList = productList;
    }

    public static DetailedCategoryDto categoryToDTO(Category category){
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
    }
}
