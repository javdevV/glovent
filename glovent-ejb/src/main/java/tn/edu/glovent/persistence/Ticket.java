package tn.edu.glovent.persistence;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Ticket
 *
 */
@Entity

public class Ticket implements Serializable {	
	@EmbeddedId
	private TicketFK ticketfk;
	private double prix;
	private int discount;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="idEvent",referencedColumnName="idEvent",insertable=false,updatable=false)
	 Event event;
	
	@ManyToOne
	@JoinColumn(name="idUser",referencedColumnName="idUser",insertable=false,updatable=false)
	 User participant;
	public TicketFK getTicketfk() {
		return ticketfk;
	}
	
	public Ticket() {
		super();
	}   
	 
	public double getPrix() {
		return this.prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}   
	public int getDiscount() {
		return this.discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}




	public User getParticipant() {
		return participant;
	}




	public void setParticipant(User participant) {
		this.participant = participant;
	}




	public void setTicketfk(TicketFK ticketfk) {
		this.ticketfk = ticketfk;
	}

	
   
}
