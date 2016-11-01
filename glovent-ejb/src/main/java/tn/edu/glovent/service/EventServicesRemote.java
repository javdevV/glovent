package tn.edu.glovent.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import tn.edu.glovent.persistence.Event;
import tn.edu.glovent.persistence.Organization;
import tn.edu.glovent.persistence.RegistrationForm;

@Remote
public interface EventServicesRemote {
	void AddEvent(Event e);
	void updateEvent(Event e);
	boolean deleteEvent(int id);
	List<Event> listAllEvents();
	List<Event> listAvailableEvents();
	boolean checkAvailibility(int id);
	List<Event> getEventByDate(Date date);
	List<Event> getEventByPeriod(Date startDate, Date endDate);
//	int NumberParticipantByAge(int age,Event event);
	List<Event> searchByNameEvent(String nameE);
	
	List<Event> findEventByOrganization(int id);
	List<Event> findEventByNameOrganization(String nameOrg);
	int NumberParticipant(Event event);
	Event searchEventById(int id);
	Organization searchOrganizationById(int id);
	List<Organization> searchOrganizationByName(String name);
	List<RegistrationForm> listAll();
	
}
