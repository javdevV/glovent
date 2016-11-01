package tn.edu.glovent.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import tn.edu.glovent.persistence.Event;
import tn.edu.glovent.persistence.User;

@Remote
public interface UserServicesRemote {
	User authentification(String login,String password);
	void Registration(User u);
	void updateAccount(User u);
	boolean deleteAccount(Integer id);
	void disableAccount(int id);
	void activateAccount(int id);
	User searchUserById(Integer id);
	void participatEvent(Event e,User u);
	
	List<Event> consultParticipatedEvent(User u);
	List<User> getAllUsers();
	List<User> searchUserByName(String name);
	User searchUserByEmail(String email);
	List<User> getUserByAge(int age);

}
