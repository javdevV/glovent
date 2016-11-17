package tn.edu.glovent.service;

import java.util.List;

import javax.ejb.Local;

import tn.edu.glovent.persistence.Ticket;



@Local
public interface TicketServiceLocal {
	 void addTicket(Ticket c);
	 List<Ticket> getTicket();
	 Ticket findTicketById(int ide,int idu);
	 void discount(int ide,int idu);
	public void deleteTicket(int ide,int idu);
}
