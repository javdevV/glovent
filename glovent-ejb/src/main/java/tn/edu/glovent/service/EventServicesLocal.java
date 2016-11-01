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
	 * this method return the list of event by a given date
	 * @param date
	 * @return
	 */
	List<Event> getEventByDate(Date date);
	/**
	 * this method return an event in a given period
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	List<Event> getEventByPeriod(Date startDate, Date endDate);
	/**
	 * this method return list of events by a given name
	 * @param nameE
	 * @return
	 */
	List<Event> searchByNameEvent(String nameE);
	/**
	 * this method return an list of events by organization id
	 * @param id
	 * @return
	 */
	List<Event> findEventByOrganization(int id);
	/**
	 * this method return an list of events by organization name
	 * @param nameOrg
	 * @return
	 */
	List<Event> findEventByNameOrganization(String nameOrg);
	/**
	 * 
	 * @param event
	 * @return
	 */
	int NumberParticipant(Event event);
	/**
	 * 
	 * @param id
	 * @return
	 */
	Event searchEventById(int id);
	/**
	 * this method return an organization by id
	 * @param id
	 * @return
	 */
	Organization searchOrganizationById(int id);
	/**
	 * this method return a list organizations by a given name
	 * @param name
	 * @return
	 */
	List<Organization> searchOrganizationByName(String name);
	
	
	
}
