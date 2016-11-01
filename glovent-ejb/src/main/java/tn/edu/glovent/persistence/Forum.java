package tn.edu.glovent.persistence;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Forum implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String name;
	private String description;
	private ArrayList<Thread> threads =new ArrayList<>(); 
	//Navigation attributes:
	private User initiator;
	
	
//	private ArrayList<User> involvedUsers =new ArrayList<>();
	
	
	public Forum(){
		System.out.println("Forum constructor fired : zero-argument [DEV][OK]");
	}
	public Forum(String name, String description){
		this.name=name;
		this.description=description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<Thread> getThreads() {
		return threads;
	}
	public void setThreads(ArrayList<Thread> threads) {
		this.threads = threads;
	}
	public User getInitiator() {
		return initiator;
	}
	public void setInitiator(User initiator) {
		this.initiator = initiator;
	}
//	public ArrayList<User> getInvolvedUsers() {
//		return involvedUsers;
//	}
//	public void setInvolvedUsers(ArrayList<User> involvedUsers) {
//		this.involvedUsers = involvedUsers;
//	} 
	 
	
}
