package tn.edu.glovent.ressources;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.*;
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

import tn.edu.glovent.persistence.Event;
import tn.edu.glovent.persistence.Organization;
import tn.edu.glovent.persistence.User;

import tn.edu.glovent.service.EventServicesLocal;

import tn.edu.glovent.service.UserServicesLocal;

@Path("event")
@RequestScoped
public class EventRessource {

	
	
	@EJB
	EventServicesLocal metier;
	
	
	
	@DELETE
	@Path("/{id}/remove")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response remove(@PathParam("id")Integer id){
		metier.deleteEvent(id);
		return Response.status(Status.NO_CONTENT).entity("event Successfully deleted ").build();
	}
	
	
	@PUT
	@Path("/modify")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Event event){
		
		metier.updateEvent(event);
		return Response.status(Status.ACCEPTED).entity("Event successfully Updated").build();
	}
	@GET
	@Path("/searchavailable") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAvailableEvents(){
		
return Response.ok(metier.listAvailableEvents()).build();
	}
	
//		ArrayList al = new ArrayList(); 
//		for(Event e:metier.listAvailableEvents()){
//			al.add(e.getIdEvent());
//			al.add(e.getNameEvent());
//			al.add(e.getTheme()+"////");
//			al.add(e.getAvaibility());
//		}
//		
//		return Response.ok(al).build();
//	}	
	
	
	
	
	@GET
	@Path("/sear") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAvailableeEvents(){
		
	return Response.ok(metier.listAll()).build();
	
	}	
	
	
	
	
	
	
	
	
	@GET 
	@Path("checkavailibility/{id}") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response CheckAvailibility(@PathParam("id")Integer id){
		Boolean result = metier.checkAvailibility(id);
		Event ev=metier.searchEventById(id);
		if (ev==null)
			return Response.status(Status.NOT_FOUND).build();
		else
			return Response.ok(result).build();
	}
	
	
	@GET 
	@Path("/findbyorganization/{id}") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response FindByOrganization(@PathParam("id") int id){
		List<Event> events=new ArrayList<>();
		 events = metier.findEventByOrganization(id);
		if(events != null){
			return Response.ok(events).build();
		}else{
			return Response.status(Status.NOT_FOUND).entity("No events Found").build();
		}
	}	
	
	
	
	@GET 
	@Path("/findbynameorganization/{nameO}") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response FindBynameOrganization(@PathParam("nameO") String nameO){
		List<Event> events=new ArrayList<>();
		 events = metier.findEventByNameOrganization(nameO);
		if(events != null){
			return Response.ok(events).build();
		}else{
			return Response.status(Status.NOT_FOUND).entity("No events Found").build();
		}
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GET 
	@Path("/searchbyid/{id}") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response SearchEventById(@PathParam("id") int id){
		
		Event event = metier.searchEventById(id);
		if(event != null){
			return Response.ok(event).build();
		}else{
			return Response.status(Status.NOT_FOUND).entity("No events Found").build();
		}
	}	
	
	
	
	
	@GET 
	@Path("/consult/{date}/{date2}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultEventByPeriod(@PathParam("date")String d
			,@PathParam("date2")String d2){
		Date startDate = null;
		Date endDate = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		try {
			startDate = formatter.parse(d);
			endDate = formatter.parse(d2);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<Event> events =  metier.getEventByPeriod(startDate, endDate)	;
		if(!events.isEmpty()){
			return Response.ok(events).build();
		}else{
			return Response.status(Status.NO_CONTENT).entity("No users Found").build();
		}
	}
	
	
	
	
	
	
	
	
	@GET 
	@Path("numberofparticipant/{id}") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNumberOfParticipant(@PathParam("id")Integer id){
	Event ev=metier.searchEventById(id);
		int n =metier.NumberParticipant(ev);
		if (ev==null)
			return Response.status(Status.NOT_FOUND).build();
		else
			return Response.ok(n).build();
	}
	
	


	
	@POST
	@Path("/addevent")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response AddEvent(Event event, @Context UriInfo uriInfo){
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		metier.AddEvent(event);
		builder.path(Integer.toString(event.getIdEvent()));
		return Response.created(builder.build()).entity(event).build();
	}
	
	
	
	
	
	
	
	
	@GET
	@Path("/searchbydate/{dateE}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEventByDate(@PathParam("dateE")String d){
		Date dateE = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		try {
			dateE = formatter.parse(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<Event> events =  metier.getEventByDate(dateE);
		if(!events.isEmpty()){
			return Response.ok(events).build();
		}else {
			return Response.status(Status.NO_CONTENT).entity("No").build();
		}	
	}
	
	
	                  	

	
	
	
	@GET
	@Path("/searcheventbyname/{nameE}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchByNameEvent(@PathParam("nameE" )String nameE ){
		List<Event> events = metier.searchByNameEvent(nameE);
		if(!events.isEmpty()){
			return Response.ok(events).build();
		}else {
			return Response.status(Status.NO_CONTENT).entity("No Events Found").build();
		}
		
		
		
		
	}
		
		
		@GET
		@Path("/searchorganizationbyname/{nameO}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response searchByNameOrganization(@PathParam("nameO" )String nameO ){
			List<Organization> orgs = metier.searchOrganizationByName(nameO);
			if(!orgs.isEmpty()){
				return Response.ok(orgs).build();
			}else {
				return Response.status(Status.NO_CONTENT).entity("No Events Found").build();
			}
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}

