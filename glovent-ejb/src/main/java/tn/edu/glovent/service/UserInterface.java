package tn.edu.glovent.service;

import java.util.List;

import tn.edu.glovent.persistence.Event;
import tn.edu.glovent.persistence.User;

public interface UserInterface {

	
	User authentification(String login,String password);
	void Registration(User u);
	void updateAccount(User u);
	boolean deleteAccount(Integer id);
	void disableAccount(User u);
	void activateAccount(User u);
	User searchUserById(Integer id);
	void participatEvent(Event e,User u);
	List<Event> searchByNameEvent(String nameE);
	List<Event> consultParticipatedEvent(User u);
	
	
	
}
