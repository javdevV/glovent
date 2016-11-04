package tn.edu.glovent.ressources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.edu.glovent.persistence.Galerie;
import tn.edu.glovent.service.EventServicesRemote;
import tn.edu.glovent.service.GalerieEjbRemote;
import tn.edu.glovent.service.ImageEjbRemote;
import tn.edu.glovent.service.UserServicesRemote;
import tn.edu.glovent.service.VideoEjbRemote;



@Path("/galerie")
@RequestScoped
public class GalerieRessource {
	@EJB
	VideoEjbRemote metier1;
	@EJB
	GalerieEjbRemote metier;
	@EJB
	UserServicesRemote metier2;
	@EJB
	ImageEjbRemote metier3;
	@EJB
	EventServicesRemote metier4;
	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllGalerie(){
		return Response.ok(metier.findAllGalerie()).build();
	}
	@POST
	@Path("add/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addGalerie(Galerie galerie,@PathParam("id") int id){
		galerie.setEvent(metier4.searchEventById(id));
		
		metier.addGalerie(galerie);
		return Response.ok("tehani etzed").build();
	}
	@GET
	@Path("find/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findGalerieById(@PathParam("id")int id){
		return Response.ok("galerie est" + metier.findGalerieById(id)).build();
	}
	@DELETE
	@Path("delet/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteImage(@PathParam("id")int id){
		metier.deleteGalerie(id);
		return Response.ok("galerie est effacer" ).build();
	}

	@PUT
	@Path("update/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateGalerie(Galerie galerie,@PathParam("id") int id){
		galerie.setEvent(metier4.searchEventById(id));
		metier.updateGalerie(galerie);
		return Response.ok("galerie est modifier" ).build();
	}
	
}
