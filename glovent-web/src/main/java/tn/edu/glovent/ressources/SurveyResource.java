package tn.edu.glovent.ressources;


import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import tn.edu.glovent.persistence.Survey;
import tn.edu.glovent.service.SurveyInterface;


@Path("surveys")
@RequestScoped
public class SurveyResource {

	@EJB
	SurveyInterface metier ;
	
	@POST//tested
	@Path("ajout")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postSurvey(Survey s, @Context UriInfo uriInfo){
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		metier.addSurvey(s);
		builder.path(Integer.toString(s.getId()));
		return Response.created(builder.build()).entity(s).build();
	}
	
	@GET//tested
	@Path("{ids}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOneSurvey(@PathParam(value="ids")int id) {
		return Response.ok(metier.findSurveyById(id)).build();
	}
	@GET//tested
	@Path("event/{ide}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSurveyByEvent(@PathParam(value="ide")int id) {
		return Response.ok(metier.findSurveyByEvent(id)).build();
	}
	@GET//tested
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllSurv() {
		return Response.ok(metier.findAll()).build();
	}
	@DELETE//tested
	@Path("{id}")
	public Response  DeleteSurv(@PathParam("id")int c) {
		metier.deleteSurvey(c);
		return Response.status(Status.NO_CONTENT).entity("survey Successfully deleted ").build();
		 
	}
	@PUT//tested
	@Consumes(MediaType.APPLICATION_JSON)
	public Response UpdateSurv(Survey s) {
		 metier.updateSurvey(s);
		 return Response.status(Status.ACCEPTED).entity("Survey successfully Updated").build();
	}
	
	
}
