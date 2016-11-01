package tn.edu.glovent.service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Path;

import tn.edu.glovent.persistence.Forum;

@Path("ForumService")
@Stateless
public class ForumService implements ForumInterfaceLocal {
	@PersistenceContext
	EntityManager em;
	public void createForum(Forum forum) {
		// TODO Auto-generated method stub
		  System.out.println(" Forum creation constructor invoked : [OK] ");
		  em.persist(forum);
		  System.out.println(" Forum :"+forum.getName()+" creation status : [OK] ");
	}

	 
	@Override
	public String updateForumDescription(String name,String description) {
		// TODO Auto-generated method stub
		Forum forum=em.find(Forum.class, name);
		 forum.setDescription(description);
		 em.merge(forum);
		 System.out.println("Forum :"+forum.getName()+" have been updated [OK] \n New Forum description is :"+forum.getDescription());
		  return "forum updated successfully";
		
	}
	 
	@Override
	public String deleteForum(String name) {
		// TODO Auto-generated method stub
		  Forum forum=em.find(Forum.class,name);
		  em.remove(forum);
		  System.out.println("Forum :"+forum.getName()+" have been removed [OK]");
		  return "forum removed successfully";
	}

	@Override
	public String removeAllThreads(Forum forum) {
		// TODO Auto-generated method stub
		Forum f=em.find(Forum.class, forum.getName());		
		f.setThreads(new ArrayList<>());
		em.merge(f);
		System.out.println("removing all the threads in forum "+forum.getName()+" have been removed [OK]");
		return "All threads of Forum :"+forum.getName()+" have been removed , the forum is now empty";
	}
	public List<Forum> getAllForums(){		
		return em.createQuery("SELECT f FROM Forum f ",Forum.class).getResultList();

	}


}
