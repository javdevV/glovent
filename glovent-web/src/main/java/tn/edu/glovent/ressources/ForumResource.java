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
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import tn.edu.glovent.persistence.Forum;
import tn.edu.glovent.service.ForumInterfaceLocal;

@Path("forum")
@RequestScoped
public class ForumResource {

	@EJB
	ForumInterfaceLocal metier ;
	
	@POST//tested
	@Consumes(MediaType.APPLICATION_JSON)
	public Response newForum(Forum s, @Context UriInfo uriInfo){
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		metier.createForum(s);
		//builder.path(Integer.toString(s.getId());
		return Response.created(builder.build()).entity(s).build();
	}
	@GET//tested
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllForums() {
		return Response.ok(metier.getAllForums()).build();
	}
	

	@DELETE//tested
	@Path("delete/{id}")
	public Response DeleteForum(@PathParam(value="id")String id){
		 metier.deleteForum(id);
		 return Response.status(Status.NO_CONTENT).entity("Forum Successfully deleted ").build();
	}
	@PUT//tested
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("update/{id}")
	public Response updateDescription(@PathParam(value="id")String id,String description) {
		 
		 return Response.status(Status.ACCEPTED).entity(metier.updateForumDescription(id, description)).build();
	}
}
	
