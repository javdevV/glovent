package tn.edu.glovent.ressources;

import java.util.ArrayList;
import java.util.List;

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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import tn.edu.glovent.persistence.User;
import tn.edu.glovent.service.UserServicesLocal;

@Path("/user")
@RequestScoped
public class UsersRessource {

	
	@EJB
	UserServicesLocal metier;
	
	
	 
	

	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Registration(User user, @Context UriInfo uriInfo){
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		metier.Registration(user);
		builder.path(Integer.toString(user.getIdUser()));
		return Response.created(builder.build()).entity(user).build();
	}
	
	
	@PUT
	@Path("/modify")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(User user){
		
		metier.updateAccount(user);
		return Response.status(Status.ACCEPTED).entity("User successfully Updated").build();
	}
	
	
	@DELETE
	@Path("/{id}/remove")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response remove(@PathParam("id")Integer id){
		metier.deleteAccount(id);
		return Response.status(Status.NO_CONTENT).entity("user Successfully deleted ").build();
	}
	
	
	@PUT
	@Path("/accountstate")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response ChangeAccountState(@QueryParam("state") int state,User user ) {
		if(state == 0){
			metier.activateAccount(user.getIdUser());
			return Response.status(Status.ACCEPTED).entity("account disabled").build();
		}
		else if(state == 1){
			metier.disableAccount(user.getIdUser());
			return Response.status(Status.ACCEPTED).entity("account activated").build();	
		}else{
			return Response.status(Status.NOT_FOUND).entity("User account not found").build();
		}
	}
	
	
	
	
	
	@PUT
	@Path("/activateaccount")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response ActivateAccount(@QueryParam("state") int state,User user ) {
		if(state == 0){
			metier.activateAccount(user.getIdUser());
			return Response.status(Status.ACCEPTED).entity("account enabled").build();
		}
		else{
			return Response.status(Status.NOT_FOUND).entity("User account not found").build();
		}
	}
	
	
	
	
	
	@PUT
	@Path("/disableaccount")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response DisableAccount(@QueryParam("state") int state,User user ) {
		if(state == 0){
			metier.disableAccount(user.getIdUser());
			return Response.status(Status.ACCEPTED).entity("account disabled").build();
		}
		else{
			return Response.status(Status.NOT_FOUND).entity("User account not found").build();
		}
	}
	
	
	
	
	
	@GET 
	@Path("/search/{id}") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultUserById(@PathParam("id")Integer id){
		User user = metier.searchUserById(id);
		if(user != null){
			return Response.ok(user).build();
		}else{
			return Response.status(Status.NOT_FOUND).entity("No users Found").build();
		}
	}
	
	
	@GET 
	@Path("/searchemail/{email}") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultUserByEmail(@PathParam("email")String email){
		User user = metier.searchUserByEmail(email);
		if(user != null){
			return Response.ok(user).build();
		}else{
			return Response.status(Status.NOT_FOUND).entity("No users Found").build();
		}
	}	
	
	
	
	
	@GET 
	@Path("/searchname/{name}") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultUserByname(@PathParam("name")String name){
		List<User> users=new ArrayList<>();
		 users = metier.searchUserByName(name);
		if(users != null){
			return Response.ok(users).build();
		}else{
			return Response.status(Status.NOT_FOUND).entity("No users Found").build();
		}
	}	
	
	
	
	
	
	@GET 
	@Path("/searchage/{age}") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultUserByAge(@PathParam("age")int age){
		List<User> users=new ArrayList<>();
		 users = metier.getUserByAge(age);
		 
			return Response.ok(users).build();
		
		
	}
	
	
	
	
	
	
	
	
	@GET 
	@Path("/authentif/{login}/{password}") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response authentif(@PathParam("login")String login,@PathParam("password") String password){
		User res = metier.authentification(login, password);
		if (res==null)
			return Response.status(Status.NOT_FOUND).build();
		else
			return Response.ok("Successful").build();
	}
	
	
	
	
	
	
	
	
	
	
}
