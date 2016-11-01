package tn.edu.glovent.persistence;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Choice
 *
 */
@Entity

public class Choice implements Serializable {

	   
	@Id
	private int id;
	private String Description;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Poll MyPoll;
	
	

	public Choice() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getDescription() {
		return this.Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}
   
}
