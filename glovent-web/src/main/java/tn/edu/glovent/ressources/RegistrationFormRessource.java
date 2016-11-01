package tn.edu.glovent.ressources;

import java.util.List;
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

import tn.edu.glovent.persistence.RegistrationForm;
import tn.edu.glovent.service.RegistrationFormServiceRemote;

@Path("regform")
@RequestScoped
public class RegistrationFormRessource {

//	@Inject
	@EJB
	RegistrationFormServiceRemote regf;
	
	@POST
	@Path("addrf")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createRf(RegistrationForm rf, @Context UriInfo uriInfo){
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		regf.addRegistrationForm(rf);
		builder.path(Integer.toString(rf.getId()));
		return Response.status(Status.ACCEPTED).entity("Registration form  successfully created").build();
	}
	@PUT
	@Path("modify")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateRegistrationForm(RegistrationForm rf){
		regf.updateRegistrationForm(rf);
		return Response.status(Status.ACCEPTED).entity("Registration form  successfully Updated").build();
	}
	@DELETE
	@Path("{id}")
	public Response deleteRegistrationForm(@PathParam("id")int id ){
		regf.deleteRegistrationForm(id);
		return Response.status(Status.NO_CONTENT).entity("Registration Form Successfully deleted ").build();
	}
	@GET
	@Path("getall")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllRegForm(){
		return Response.ok(regf.getAllRegForm()).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getbyint/{id}")
	public RegistrationForm getRegFormById(@PathParam("id") int id){
		return regf.getRegFormById(id);
	}	
	@GET
	@Path("getbyname/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRegFormByName(@PathParam("name") String name){
		return Response.ok(regf.getRegFormbyName(name)).build();
	}
	
}
