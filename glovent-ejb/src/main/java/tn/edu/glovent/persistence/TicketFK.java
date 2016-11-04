package tn.edu.glovent.persistence;

import java.io.Serializable;
import javax.persistence.*;




@Embeddable

public class TicketFK implements Serializable {

	   
	
	private int idEvent;
	private int idUser;
	private static final long serialVersionUID = 1L;

	public TicketFK() {
		super();
	}

	public TicketFK(int idEvent, int idUser) {
		super();
		this.idEvent = idEvent;
		this.idUser = idUser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEvent;
		result = prime * result + idUser;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TicketFK other = (TicketFK) obj;
		if (idEvent != other.idEvent)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}   
	
	
	
   
}
