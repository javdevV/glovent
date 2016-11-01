package tn.edu.glovent.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Organizer
 *
 */
@Entity

public class Organizer extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	
	@OneToMany(mappedBy="MyOrganizer")
	private List<Task> ListOfTasks;
	
	
	
	
	
	
	
	
	public Organizer() {
		super();
	}
   
}
