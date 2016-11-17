package tn.edu.glovent.persistence;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Chalange
 *
 */
@Embeddable

public class Chalange implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private int nombreParticipant;
	private boolean type;
	public Chalange() {
		super();
	}
	public int getNombreParticipant() {
		return nombreParticipant;
	}
	public void setNombreParticipant(int nombreParticipant) {
		this.nombreParticipant = nombreParticipant;
	}
	public boolean isType() {
		return type;
	}
	public void setType(boolean type) {
		this.type = type;
	}
	
   
}
