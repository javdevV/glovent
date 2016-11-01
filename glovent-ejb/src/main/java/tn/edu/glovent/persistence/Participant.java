package tn.edu.glovent.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Participant
 *
 */
@Entity

public class Participant extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="MyPatricipant")
	private List<Ticket> MyTickets;
	
	
	
	

	public Participant() {
		super();
	}
   
}
