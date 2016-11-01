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
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import tn.edu.glovent.persistence.Field;
import tn.edu.glovent.service.FieldServiceRemote;

@Path("fields")
@RequestScoped
public class FieldRessource {

	// @Inject
	@EJB
	FieldServiceRemote fs;

	@POST
	@Path("/addf")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addField(Field f, @Context UriInfo uriInfo) {
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		fs.addField(f);
		builder.path(Integer.toString(f.getId()));
		return Response.created(builder.build()).entity(f).build();
	}
	@DELETE
	@Path("/{id}")
	public Response deteteField(@PathParam("id") int id) {
		fs.deleteField(id);
		return Response.status(Status.NO_CONTENT).entity("Field Successfully deleted ").build();
	}
	@PUT
	@Path("modify")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateField(Field f) {
		fs.updateField(f);
		return Response.status(Status.ACCEPTED).entity("Field successfully Updated").build();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("findbyname/{name}")
	public Response findFieldByName(@PathParam("name") String name) {
		return Response.ok(fs.findFieldByName(name)).build();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getall")
	public Response getAllFields() {
		return Response.ok(fs.getAllFields()).build();
	}
}
