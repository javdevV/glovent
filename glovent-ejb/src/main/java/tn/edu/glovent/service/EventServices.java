package tn.edu.glovent.service;


import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;

import tn.edu.glovent.persistence.Event;
import tn.edu.glovent.persistence.Organization;
import tn.edu.glovent.persistence.RegistrationForm;


/**
 * Session Bean implementation class EventServices
 */
@Stateless
@LocalBean
public class EventServices implements EventServicesRemote, EventServicesLocal {
	@PersistenceContext
	private EntityManager em;
		
	
	
	
	
	public EventServices() {
		super();
	}





	@Override
	public List<Event> listAllEvents() {
return em.createQuery("select e from Event e ", Event.class)
				
				.getResultList();
	}

	
	
	
	
	@Override
	public List<Event> listAvailableEvents() {
		return em.createQuery("select e from Event e where e.avaibility=true ", Event.class)
				.getResultList();
	}

	@Override
	public boolean checkAvailibility(int id) {
		Event ev=searchEventById(id);
		if (ev.getAvaibility()==true){
			return true;
		}
			return false;	
	}


	@Override
	public List<Event> searchByNameEvent(String nameE) {
		
		return em.createQuery("select e from Event e where e.avaibility = true AND e.nameEvent = :en ", Event.class)
				.setParameter("en",nameE)
				.getResultList();
	}
	
	
	public List<Event> getEventByDate(Date date) {
		return em
				.createQuery("select e from Event e where dateEvent = :d", Event.class)
				.setParameter("d", date, TemporalType.DATE)
				.getResultList();
	}

	@Override
	public List<Event> getEventByPeriod(Date startDate, Date endDate) {
		return  em
				.createQuery("select e from Event e where avaibility = true AND dateEvent BETWEEN :dd AND :ed", Event.class)
				.setParameter("dd",startDate, TemporalType.DATE)
				.setParameter("ed", endDate, TemporalType.DATE)
				.getResultList();
	}
	
	
	@Override
	public Organization searchOrganizationById(int id) {
		
			return em.find(Organization.class, id);
		}
	
	

	@Override
	public List<Event> findEventByOrganization(int id) {
		//Organization org=searchOrganizationById(id);
		return em
				.createQuery("select e from Event e where MyOrganization_id=:ido", Event.class)
				.setParameter("ido",id)
				
				.getResultList();
	}

	
	@Override
	public List<Event> findEventByNameOrganization(String nameOrg) {
//		List<Organization> orgs=new ArrayList<>();
//		List<Integer> ids=new ArrayList<>();
//		
//	
//		orgs=searchOrganizationByName(nameOrg);
//		
		return em
				.createQuery("select e from Event e left join e.MyOrganization as org where org.name=:nameO", Event.class)
				.setParameter("nameO",nameOrg)
				
				.getResultList();	
		
		
	}

	@Override
	public int NumberParticipant(Event event) {
		return em
				.createQuery("select count(*) from listeP p where listeE_idEvent=:idevent", int.class)
				.setParameter("idevent",event.getIdEvent()).getSingleResult();
				
				
	}

	@Override
	public void AddEvent(Event e) {
		em.persist(e);
		
	}





	




	@Override
	public Event searchEventById(int id) {
		
			return em.find(Event.class, id);
		}





	@Override
	public List<Organization> searchOrganizationByName(String name) {
		return em.createQuery("select o from Organization o where o.name= :name ", Organization.class)
				.setParameter("name",name)
				.getResultList();
	}





	@Override
	public void updateEvent(Event e) {
		em.merge(e);
		
	}





	@Override
	public boolean deleteEvent(int id) {
		
			Event e = em.find(Event.class,id);
			if(e !=null){
				em.remove(e);
				return true;
			}else{
			return false;
			}
			
		
		
			
			
			
	}





	

//	@Override
//	public int NumberParticipantByAge(int age,Event event) {
//		return  em
//				.createQuery("select count(listeP_idUser) from events_users  where listeE_idEvent=idd And e.dateEvent BETWEEN :dd AND :ed", Event.class)
//				.setParameter("dd", startDate, TemporalType.DATE)
//				.setParameter("ed", endDate, TemporalType.DATE)
//				.setParameter("idd",event.getIdEvent())
//				.setParameter("age",event.getIdEvent())
//				.getResultList();
//	}
	
	
	
	
	
	
	
	
	

}
