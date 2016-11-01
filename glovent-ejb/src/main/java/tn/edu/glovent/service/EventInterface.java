package tn.edu.glovent.service;

import java.util.List;

import tn.edu.glovent.persistence.Event;

public interface EventInterface {

	List<Event> listAllEvents();
	List<Event> listAvailableEvents();
	
	
	
}
