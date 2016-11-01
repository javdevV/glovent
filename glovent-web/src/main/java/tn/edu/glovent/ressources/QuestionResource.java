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
import tn.edu.glovent.persistence.Question;
import tn.edu.glovent.service.QuestionInterface;
import tn.edu.glovent.service.QuestionService;

@Path("questions")
@RequestScoped
public class QuestionResource {
	
	@EJB
	QuestionInterface metier;
	
	
	
	@POST//tested
	@Path("ajout")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postQuest(Question s, @Context UriInfo uriInfo) {
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		metier.addQuestion(s);
		builder.path(Integer.toString(s.getId()));
		return Response.created(builder.build()).entity(s).build();
	}

	@GET//tested
	@Path("{ids}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOneQuestion(@PathParam(value = "ids") int id) {
		return Response.ok(metier.findQuestionById(id)).build();
	}

	@GET//tested
	@Path("surv/{ids}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestBySurv(@PathParam(value = "ids") int id) {
		return Response.ok(metier.QuestionsBySurvey(id)).build();
	}

	@GET//tested
	@Path("nbQest/{ids}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response nbQuestBySurv(@PathParam(value = "ids") int ids) {
		return Response.ok(metier.nbQuestionBySurvey(ids)).build();
	}

	@GET//tested
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllQuest() {
		return Response.ok(metier.findAll()).build();
	}

	@DELETE
	@Path("delete/{s}")
	public Response DeleteQuest(@PathParam(value = "s")int s) {
		metier.deleteQuestion(s);
		return Response.status(Status.NO_CONTENT).entity("question Successfully deleted ").build();
	}

	@PUT//tested
	@Consumes(MediaType.APPLICATION_JSON)
	public Response UpdateQuest(Question s) {
		metier.updateQuestion(s);
		 return Response.status(Status.ACCEPTED).entity("question successfully Updated").build();

	}

}
