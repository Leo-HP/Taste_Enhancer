package com.leohp.tasteenhancer.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.leohp.tasteenhancer.dao.CategoryDao;
import com.leohp.tasteenhancer.dao.DaoFactory;
import com.leohp.tasteenhancer.dto.*;
import com.leohp.tasteenhancer.entity.Category;

@Path("/categories")
public class CategoryService {

    private CategoryDao categoryDao;

    @Context
    UriInfo uriInfo;

    public CategoryService() {
        categoryDao = DaoFactory.getCategoryDao();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategories() {

        List<Category> categories = categoryDao.findAll();
        List<CategoryDto> dtoCategories = new ArrayList<CategoryDto>();
        for(Category c : categories) {
            dtoCategories.add(CategoryMapper.INSTANCE.categoryToCategoryDto(c));
        }
        return Response.ok(dtoCategories).build();

    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getSpecificCategory(@PathParam("id") Long id) {

        Category c = categoryDao.findById(id);

        DetailedCategoryDto detailedCategoryDTO = DetailedCategoryMapper.INSTANCE.categoryToCategoryDto(c);
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

