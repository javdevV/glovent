package tn.edu.glovent.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.edu.glovent.persistence.Event;
import tn.edu.glovent.persistence.User;

public class UserService implements UserInterface {
	@PersistenceContext
	private EntityManager em;
	@Override
	public User authentification(String login, String password) {
		User found = null;
		String jpql ="select u from Users u where u.login = :l and u.pwd = :p";
		
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("l", login);
		query.setParameter("p", password);
		try {
			found = query.getSingleResult();
		} catch (NoResultException e) {			
			Logger.getLogger(getClass().getName())
			.log(Level.INFO, "no user with this login"+login);
		}
		return found;
	}
	@Override
	public void Registration(User u) {
		em.persist(u);
	}
	

	@Override
	public void updateAccount(User u) {
		em.merge(u);
		
	}

	@Override
	public boolean deleteAccount(Integer id) {
		User u = em.find(User.class,id);
		if(u !=null){
			em.remove(u);
			return true;
		}else{
		return false;
		}
	}

	@Override
	public void disableAccount(User u) {
		User us = searchUserById(u.getIdUser());
		u.setAccountState(false);
		em.merge(us);
		
	}

	@Override
	public void activateAccount(User u) {
		User us = searchUserById(u.getIdUser());
		u.setAccountState(true);
		em.merge(us);
		
	}

	@Override
	public User searchUserById(Integer id) {
		return em.find(User.class, id);
	}
	@Override
	public void participatEvent(Event e, User u) {
		e.getListeP().add(u);
		
	}
	@Override
	public List<Event> searchByNameEvent(String nameE) {
		
		return em.createQuery("select e from Event e where e.availability = true AND e.nameEvent = :en ", Event.class)
				.setParameter("en",nameE)
				.getResultList();
	}
	@Override
	public List<Event> consultParticipatedEvent(User u) {
		return u.getListeE();
		
		
		
	}



	

}
