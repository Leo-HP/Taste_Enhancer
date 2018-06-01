package com.leohp.tasteenhancer.rest;

import com.leohp.tasteenhancer.dao.IngredientDao;
import com.leohp.tasteenhancer.dto.CreateIngredient;
import com.leohp.tasteenhancer.dto.IngredientDto;
import com.leohp.tasteenhancer.entity.Ingredient;
import com.leohp.tasteenhancer.mapper.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Stateless
@Path("/ingredients")
public class IngredientService {

    @EJB
    private IngredientDao ingredientDao;

    @Context
    UriInfo uriInfo;


    public IngredientService() {

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIngredients() {

        List<Ingredient> ingredients = ingredientDao.findAll();
        List<IngredientDto> ingredientDtos = IngredientMapper.INSTANCE.ingredientToIngredientDto(ingredients);
        return Response.ok(ingredientDtos).build();

    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getSpecificIngredient(@PathParam("id") Long id) {

        Ingredient ingredient = ingredientDao.findById(id);

        IngredientDto ingredientDto = IngredientMapper.INSTANCE.ingredientToIngredientDto(ingredient);
        return Response.ok(ingredientDto).status(Response.Status.OK).build();

    }

    @POST
    @Path("/add_ingredient")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createIngredient(CreateIngredient createIngredient) {
        Ingredient ingredient = new Ingredient(createIngredient.getName(), CategoryMapper.INSTANCE.categoryDtoToCategory(createIngredient.getCategoryDtoList()), TasteMapper.INSTANCE.tasteDtoToTaste(createIngredient.getTasteDtoList()), OriginMapper.INSTANCE.originDtoToOrigin(createIngredient.getOriginDtoList()), SeasonMapper.INSTANCE.seasonDtoToSeason(createIngredient.getSeasonDtoList()));
        ingredientDao.create(ingredient);
        UriBuilder uriBuilder = UriBuilder.fromUri(uriInfo.getRequestUri() + "/" + String.valueOf(ingredient.getId()));
        return Response.ok().status(Response.Status.CREATED).build();
    }
}
