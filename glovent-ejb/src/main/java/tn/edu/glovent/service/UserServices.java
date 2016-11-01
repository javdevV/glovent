package tn.edu.glovent.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.edu.glovent.persistence.Event;
import tn.edu.glovent.persistence.User;

/**
 * Session Bean implementation class UserServices
 */
@Stateless
@LocalBean
public class UserServices implements UserServicesRemote, UserServicesLocal {
	@PersistenceContext
	private EntityManager em;
	@Override
	public User authentification(String login, String password) {
		User found = null;
		String jpql ="select u from User u where u.login = :l and u.pwd = :p";
		
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
	public void disableAccount(int id) {
		User us = searchUserById(id);
		us.setAccountState(false);
		em.merge(us);
		
	}

	@Override
	public void activateAccount(int id) {
		User us = searchUserById(id);
		us.setAccountState(true);
		em.merge(us);
		
	}

	@Override
	public User searchUserById(Integer id) {
		return em.find(User.class, id);
	}
	@Override
	public void participatEvent(Event e, User u) {
		
		//List<User> lst=new ArrayList<>();
		e.getListeP().add(u);
		
		em.merge(e);
		
//		for(Commentaire c:listCommentaires){
//			Bugs b=this.findById(numBug);
//			c.setMybug(b);
//b.setComments(listCommentaires);			
		}
		
		
	
	
	@Override
	public List<Event> consultParticipatedEvent(User u) {
		return u.getListeE();
		
		
		
	}
	@Override
	public List<User> getAllUsers() {


return em.createQuery("from User", User.class).getResultList();

	}
	@Override
	public List<User> searchUserByName(String name) {
	
			return em
					.createQuery("select u from User u where u.fName = :fn OR u.lName = :ln", User.class)
					.setParameter("fn",name)
					.setParameter("ln",name)
					.getResultList();
		}
	@Override
	public User searchUserByEmail(String email) {
		return em
				.createQuery("select u from User u where u.email = :email", User.class)
				.setParameter("email",email)	
				.getSingleResult();
	}
	@Override
	public List<User> getUserByAge(int age) {
		return em
				.createQuery("select u from User u where u.age = :ag", User.class)
				.setParameter("ag",age)
				
				.getResultList();
	}


}


