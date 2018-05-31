package com.leohp.tasteenhancer.rest;

import com.leohp.tasteenhancer.dao.TasteDao;
import com.leohp.tasteenhancer.dto.CreateTaste;
import com.leohp.tasteenhancer.dto.DetailedTasteDto;
import com.leohp.tasteenhancer.dto.TasteDto;
import com.leohp.tasteenhancer.entity.Taste;
import com.leohp.tasteenhancer.mapper.TasteMapper;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Stateless
@Path("/tastes")
public class TasteService {

    @EJB
    private TasteDao tasteDao;

    @Context
    UriInfo uriInfo;


    public TasteService() {

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTastes() {

        List<Taste> tastes = tasteDao.findAll();
        List<TasteDto> tasteDtos = TasteMapper.INSTANCE.tasteToTasteDto(tastes);
        return Response.ok(tasteDtos).build();

    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getSpecificTaste(@PathParam("id") Long id) {

        Taste t = tasteDao.findById(id);

        DetailedTasteDto detailedTasteDto = TasteMapper.INSTANCE.tasteToDetailedTasteDto(t);
        return Response.ok(detailedTasteDto).status(Response.Status.OK).build();

    }

    @POST
    @Path("/add_taste")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTaste(CreateTaste createTaste) {
        Taste taste = new Taste(createTaste.getName());
        tasteDao.create(taste);
        UriBuilder uriBuilder = UriBuilder.fromUri(uriInfo.getRequestUri() + "/" + String.valueOf(taste.getId()));
        return Response.ok().status(Response.Status.CREATED).build();
    }
}
