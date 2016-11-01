package tn.edu.glovent.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import tn.edu.glovent.persistence.Event;
import tn.edu.glovent.persistence.Organization;
import tn.edu.glovent.persistence.RegistrationForm;

@Local
public interface EventServicesLocal {
	/**
	 * this method add an event
	 * @param e
	 */
	void AddEvent(Event e);
	/**
	 * this method update an event
	 * @param e
	 */
	void updateEvent(Event e);
	/**
	 * this method delete an event
	 * @param id
	 * @return a boolean
	 */
	boolean deleteEvent(int id);
	/**
	 * this method return the list of all events
	 * @return
	 */
	List<Event> listAllEvents();
	/**
	 * this method return the list of available events
	 * @return
	 */
	List<Event> listAvailableEvents();
	/**
	 * this method check the availability of an event
	 * @param id
	 * @return a boolean
	 */
	boolean checkAvailibility(int id);
	/**
	 * this method return the list of 
	 * @param date
	 * @return
	 */
	List<Event> getEventByDate(Date date);
	List<Event> getEventByPeriod(Date startDate, Date endDate);
	List<Event> searchByNameEvent(String nameE);
	List<Event> findEventByOrganization(int id);
	List<Event> findEventByNameOrganization(String nameOrg);
	int NumberParticipant(Event event);
	Event searchEventById(int id);
	Organization searchOrganizationById(int id);
	List<Organization> searchOrganizationByName(String name);
	List<RegistrationForm> listAll();
	
	
}
