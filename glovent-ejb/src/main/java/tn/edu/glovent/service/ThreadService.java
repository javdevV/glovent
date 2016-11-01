package tn.edu.glovent.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import tn.edu.glovent.persistence.Thread;

@Path("ThreadService")
@Stateless
public class ThreadService implements ThreadInterfaceLocal {
	@PersistenceContext
	EntityManager em;
	public String createThread(Thread thread) {
		// TODO Auto-generated method stub
		  System.out.println(" Thread creation constructor invoked : [OK] ");
		  em.persist(thread);
		  System.out.println(" Thread :"+thread.getTitle()+" creation status : [OK] ");
		  return("Thread created successfully");
	}

	  
	@Override
	public String updateThreadContent(Thread thread,String threadContent) {
		// TODO Auto-generated method stub
		 thread.setThreadContent(threadContent);
		 em.merge(thread);
		 System.out.println("Thread :"+thread.getTitle()+" have been updated [OK] \n New Thread content is :"+thread.getThreadContent());
		  return "thread updated successfully";
		
	}
	  
	  
	@Override
	public String deleteThread(Integer id) {
		// TODO Auto-generated method stub
		Thread thread=em.find(Thread.class,id);
		  em.remove(thread);
		 System.out.println("Thread :"+thread.getTitle()+" have been removed [OK]");
		  return "thread removed successfully";
	}

	
	@Override
	public List<Thread> listAllThreads() {
		// TODO Auto-generated method stub
		 return em
				.createQuery("select u from Thread u ", Thread.class)
				.getResultList();
	}

	@Override
	public List<Thread> findByTitle(String title) {
		// TODO Auto-generated method stub
		return em
				.createQuery("select u from Thread u where u.title = :title", Thread.class)
				.setParameter("title",title)
				.getResultList();
	}

	@Override
	public List<Thread> findBySearchTerm(String term) {
		// TODO Auto-generated method stub
		return em
				.createQuery("select u from Thread u where u.title = :term OR u.threadContent=:term", Thread.class)
				.setParameter("term",term)
				.getResultList();
	}
	
	@Override
	public List<Thread> findByPostingUser(String commentingUser) {
		// TODO Auto-generated method stub
		return em
				.createQuery("select u from Thread u where u.CommentingUser=:commentingUser", Thread.class)
				.setParameter("commentingUser",commentingUser)
				.getResultList();
	}

	@Override
	public String getThreadData(Thread thread) {
		// TODO Auto-generated method stub
		return em.find(Thread.class, thread.getTitle()).toString();
	}

	


}
