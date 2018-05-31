package com.leohp.tasteenhancer.rest;

import com.leohp.tasteenhancer.dao.RecipeDao;
import com.leohp.tasteenhancer.dto.CreateRecipe;
import com.leohp.tasteenhancer.dto.DetailedRecipeDto;
import com.leohp.tasteenhancer.dto.RecipeDto;
import com.leohp.tasteenhancer.entity.Recipe;
import com.leohp.tasteenhancer.mapper.IngredientMapper;
import com.leohp.tasteenhancer.mapper.RecipeMapper;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Stateless
@Path("/recipes")
public class RecipeService {

    @EJB
    private RecipeDao recipeDao;

    @Context
    UriInfo uriInfo;


    public RecipeService() {

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecipes() {

        List<Recipe> recipes = recipeDao.findAll();
        List<RecipeDto> recipeDtos = RecipeMapper.INSTANCE.recipeToRecipeDto(recipes);
        return Response.ok(recipeDtos).build();

    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getSpecificRecipe(@PathParam("id") Long id) {

        Recipe r = recipeDao.findById(id);

        DetailedRecipeDto detailedRecipeDto = RecipeMapper.INSTANCE.recipeToDetailedRecipeDto(r);
        return Response.ok(detailedRecipeDto).status(Response.Status.OK).build();

    }

    @POST
    @Path("/add_recipe")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createRecipe(DetailedRecipeDto createRecipe) {
        Recipe recipe = new Recipe(createRecipe.getName(), IngredientMapper.INSTANCE.recipeIngredientDtoToIngredient(createRecipe.getIngredientList()));
        recipeDao.create(recipe);
        UriBuilder uriBuilder = UriBuilder.fromUri(uriInfo.getRequestUri() + "/" + String.valueOf(recipe.getId()));
        return Response.ok().status(Response.Status.CREATED).build();
    }

}
