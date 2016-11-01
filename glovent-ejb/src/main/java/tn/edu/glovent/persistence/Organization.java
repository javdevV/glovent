package tn.edu.glovent.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Organization
 *
 */
@Entity

public class Organization implements Serializable {

	   
	@Id
	private int id;
	private String name;
	private String type;
	private static final long serialVersionUID = 1L;

	
	@ManyToMany
	private List<User> listUsers ;
	
	
	@OneToOne(mappedBy="MyOrganization")
	private President MyPresident;
	
	
	@OneToMany(mappedBy="MyOrganization")
	private List<Event> MyEvents;
	
	
	
	
	
	
	
	
	public Organization() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
   
}
