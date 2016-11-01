package tn.edu.glovent.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Poll
 *
 */
@Entity

public class Poll implements Serializable {

	   
	@Id
	private int id;
	private String Subject;
	private static final long serialVersionUID = 1L;
	
	
	@ManyToOne
	private President MyPresident;
	
	
	@OneToMany(mappedBy="MyPoll")
	private List<Choice> MyChoices;
	
	
	

	public Poll() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getSubject() {
		return this.Subject;
	}

	public void setSubject(String Subject) {
		this.Subject = Subject;
	}
   
}
