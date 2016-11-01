package tn.edu.glovent.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.glovent.persistence.Event;

public class EventService implements  EventInterface {
	@PersistenceContext
	private EntityManager em;
	@Override
	public List<Event> listAllEvents() {
return em.createQuery("select e from Event e ", Event.class)
				
				.getResultList();
	}

	@Override
	public List<Event> listAvailableEvents() {
		return em.createQuery("select e from Event e where e.availability = true ", Event.class)
				
				.getResultList();
	}
	
	
	
	
	
	
	
	
	

}
