package com.leohp.tasteenhancer.rest;

import com.leohp.tasteenhancer.dao.CategoryDao;
import com.leohp.tasteenhancer.dto.CategoryDto;
import com.leohp.tasteenhancer.dto.CreateCategory;
import com.leohp.tasteenhancer.dto.DetailedCategoryDto;
import com.leohp.tasteenhancer.entity.Category;
import com.leohp.tasteenhancer.mapper.CategoryMapper;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Stateless
@Path("/categories")
public class CategoryService {

    @EJB
    private CategoryDao categoryDao;

    @Context
    UriInfo uriInfo;


    public CategoryService() {

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategories() {

        List<Category> categories = categoryDao.findAll();
        List<CategoryDto> dtoCategories = CategoryMapper.INSTANCE.categoryToCategoryDto(categories);
        return Response.ok(dtoCategories).build();

    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getSpecificCategory(@PathParam("id") Long id) {

        Category c = categoryDao.findById(id);

        DetailedCategoryDto detailedCategoryDTO = CategoryMapper.INSTANCE.categoryToDetailedCategoryDto(c);
        return Response.ok(detailedCategoryDTO).status(Response.Status.OK).build();

    }

    @POST
    @Path("/add_category")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCategory(CreateCategory cc) {
        Category category = new Category(cc.getName());
        categoryDao.create(category);
        UriBuilder uriBuilder = UriBuilder.fromUri(uriInfo.getRequestUri() + "/" + String.valueOf(category.getId()));
        return Response.ok().status(Response.Status.CREATED).build();
    }

}

