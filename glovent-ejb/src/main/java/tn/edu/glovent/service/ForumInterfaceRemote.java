package tn.edu.glovent.service;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ws.rs.Path;

import tn.edu.glovent.persistence.Forum;



@Remote
public interface ForumInterfaceRemote {
	void createForum(Forum forum);
	String updateForumDescription(String name,String description);
	String deleteForum(String name);
	String removeAllThreads(Forum forum);
	List<Forum> getAllForums();

}
