package tn.edu.glovent.persistence;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Ticket
 *
 */
@Entity

public class Ticket implements Serializable {

	   
	@Id
	private int id;
	private float price;
	private float discount;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Participant MyPatricipant;
	
	@ManyToOne
	private Event MyEvent;
	
	
	

	public Ticket() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}   
	public float getDiscount() {
		return this.discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}
   
}
