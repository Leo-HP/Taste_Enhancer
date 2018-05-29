package com.leohp.tasteenhancer.rest;

import com.leohp.tasteenhancer.dao.SeasonDao;
import com.leohp.tasteenhancer.dto.*;
import com.leohp.tasteenhancer.entity.Season;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Path("/seasons")
public class SeasonService {


    @EJB
    private SeasonDao seasonDao;

    @Context
    UriInfo uriInfo;


    public SeasonService() {

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSeasons() {

        List<Season> seasons = seasonDao.findAll();
        List<SeasonDto> seasonDtos = new ArrayList<>();
        for (Season s : seasons) {
            seasonDtos.add(SeasonMapper.INSTANCE.seasonToSeasonDto(s));
        }
        return Response.ok(seasonDtos).build();

    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getSpecificSeason(@PathParam("id") Long id) {

        Season s = seasonDao.findById(id);

        DetailedSeasonDto detailedSeasonDto = DetailedSeasonMapper.INSTANCE.seasonToDetailedSeasonDto(s);
        return Response.ok(detailedSeasonDto).status(Response.Status.OK).build();

    }

    @POST
    @Path("/add_season")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createSeason(CreateSeason createSeason) {
        Season season = new Season(createSeason.getName());
        seasonDao.create(season);
        UriBuilder uriBuilder = UriBuilder.fromUri(uriInfo.getRequestUri() + "/" + String.valueOf(season.getId()));
        return Response.ok().status(Response.Status.CREATED).build();
    }

}

