package tn.edu.glovent.ressources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
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
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import tn.edu.glovent.persistence.Answer;
import tn.edu.glovent.persistence.Options;
import tn.edu.glovent.service.AnswerInterface;
import tn.edu.glovent.service.AnswerService;

@Path("answers")
@RequestScoped
public class AnswerResource {

	@EJB
	AnswerInterface metier ;
	
	@POST//tested
	@Path("ajout")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postAnswer(Answer s, @Context UriInfo uriInfo){
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		metier.addAnswer(s);
		//builder.path(Integer.toString(s.getId());
		return Response.created(builder.build()).entity(s).build();
	}
	@GET//tested
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllAnswers() {
		return Response.ok(metier.findAll()).build();
	}
	
	@GET//tested
	@Path("get/{idq}/{idu}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOneAnswer(@PathParam(value="idq")int idq,@PathParam(value="idu")int idu) {
		return Response.ok(metier.findAnswerById(idq,idu)).build();
	}
	@GET//tested
	@Path("nbAnswer/{idq}/{o}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response nbAnswersByQuest(@PathParam(value="idq")int idq,
			@PathParam(value="o" )Options o) {
		return Response.ok(metier.nbRepliesByQuestion(idq, o)).build();
	}

	@DELETE//tested
	@Path("suppr/{idq}/{idu}")
	public Response DeleteAnswer(@PathParam(value="idq")int idq,@PathParam(value="idu")int idu ) {
		 metier.deleteAnswer(idq,idu);
		 return Response.status(Status.NO_CONTENT).entity("Answer Successfully deleted ").build();
	}
	@PUT//tested
	@Consumes(MediaType.APPLICATION_JSON)
	public Response UpdateQuest(Answer s) {
		 metier.updateAnswer(s);
		 return Response.status(Status.ACCEPTED).entity("Answer successfully Updated").build();
	}
}
	
