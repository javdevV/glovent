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

import tn.edu.glovent.persistence.Thread;
import tn.edu.glovent.persistence.Options;
import tn.edu.glovent.service.ThreadInterfaceLocal;
import tn.edu.glovent.service.ThreadService;

@Path("threads")
@RequestScoped
public class ThreadResource {

	@EJB
	ThreadInterfaceLocal metier ;
	
	@POST//tested
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postThread(Thread s, @Context UriInfo uriInfo){
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		metier.createThread(s);
		//builder.path(Integer.toString(s.getId());
		return Response.created(builder.build()).entity(s).build();
	}
	@GET//tested
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllThreads() {
		return Response.ok(metier.listAllThreads()).build();
	}
	
	@GET//tested
	@Path("find/title/{title}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByTitle(@PathParam(value="title")String title) {
		return Response.ok(metier.findByTitle(title)).build();
	}
	@GET//tested
	@Path("find/user/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByUser(@PathParam(value="username")String username) {
		return Response.ok(metier.findByPostingUser(username)).build();
	}
	@GET//tested
	@Path("find/term/{term}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByTerm(@PathParam(value="term")String term) {
		return Response.ok(metier.findBySearchTerm(term)).build();
	}

	@DELETE//tested
	@Path("delete/{id}")
	public Response DeleteThread(@PathParam(value="id")int id) {
		 metier.deleteThread(id);
		 return Response.status(Status.NO_CONTENT).entity("Thread Successfully deleted ").build();
	}
	
	
}
	
