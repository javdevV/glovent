package tn.edu.glovent.service;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ws.rs.Path;

import tn.edu.glovent.persistence.Thread;



@Remote
public interface ThreadInterfaceRemote {
	String createThread(Thread thread);
	String updateThreadContent(Thread thread,String threadContent);
	String deleteThread(Integer id);
	List<Thread> listAllThreads();
	List<Thread> findByTitle(String title);
	List<Thread> findBySearchTerm(String term);
	List<Thread> findByPostingUser(String username);
	String getThreadData(Thread thread);
}
