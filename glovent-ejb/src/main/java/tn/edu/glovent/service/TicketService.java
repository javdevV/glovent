package tn.edu.glovent.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.glovent.persistence.Ticket;
import tn.edu.glovent.persistence.TicketFK;


/**
 * Session Bean implementation class TicketService
 */
@Stateless
@LocalBean
public class TicketService implements TicketServiceRemote, TicketServiceLocal {

	@PersistenceContext
	EntityManager em;
	@EJB
	UserServicesRemote us;
	EventServicesRemote ev;
	ParticipantService pr;
    public TicketService() {
        super();
    }
	@Override
	public Ticket findTicketById(int ide, int idu) {
		   TicketFK tf =new TicketFK(ide,idu);
			return em.find(Ticket.class, tf);
	}
	@Override
	public void addTicket(Ticket c) {
		em.persist(c);
	}
	@Override
	public List<Ticket> getTicket() {
		 return em.createQuery("From Ticket").getResultList();
	}
	@Override
	public void discount(int ide, int idu) {
		
		Ticket tc =new Ticket();
		tc = findTicketById(ide, idu);
		boolean type = tc.getEvent().getChalange().isType();
		if(type==true){
		int dis = pr.countinvit(idu);
		double prix;
		prix = tc.getPrix();
		prix = prix - ((prix * dis)/10);
		tc.setPrix(prix);
		tc.setDiscount(dis);
		em.merge(tc);
		}
		else{
			cadeau(ide, idu);
				
		}
	}
	public int cadeau(int ide, int idu){
		Ticket tc =new Ticket();
		tc = findTicketById(ide, idu);
		int nb = tc.getEvent().getChalange().getNombreParticipant();
		int dis = pr.countinvit(idu);
		if (nb==dis )
			return idu;
			else
		return 0;
		
	}
	
	
	
	@Override
	public void deleteTicket(int ide, int idu) {
		Ticket tc =new Ticket();
		tc = findTicketById(ide, idu);
		em.remove(tc);
		
	}

}
