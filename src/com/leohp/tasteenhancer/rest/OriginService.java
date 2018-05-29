package com.leohp.tasteenhancer.rest;

import com.leohp.tasteenhancer.dao.OriginDao;
import com.leohp.tasteenhancer.dto.*;
import com.leohp.tasteenhancer.entity.Origin;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Path("/origins")
public class OriginService {

    @EJB
    private OriginDao originDao;

    @Context
    UriInfo uriInfo;


    public OriginService() {

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrigins() {

        List<Origin> origins = originDao.findAll();
        List<OriginDto> originDtos = new ArrayList<OriginDto>();
        for (Origin o : origins) {
            originDtos.add(OriginMapper.INSTANCE.originToOriginDto(o));
        }
        return Response.ok(originDtos).build();

    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getSpecificOrigin(@PathParam("id") Long id) {

        Origin o = originDao.findById(id);

        DetailedOriginDto detailedOriginDto = DetailedOriginMapper.INSTANCE.originToDetailedOriginDto(o);
        return Response.ok(detailedOriginDto).status(Response.Status.OK).build();

    }

    @POST
    @Path("/add_origin")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCategory(CreateOrigin co) {
        Origin origin = new Origin(co.getName());
        originDao.create(origin);
        UriBuilder uriBuilder = UriBuilder.fromUri(uriInfo.getRequestUri() + "/" + String.valueOf(origin.getId()));
        return Response.ok().status(Response.Status.CREATED).build();
    }
}
