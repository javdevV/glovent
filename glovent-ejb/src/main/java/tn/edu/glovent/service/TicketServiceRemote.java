package tn.edu.glovent.service;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.glovent.persistence.Ticket;


@Remote
public interface TicketServiceRemote {
	 void addTicket(Ticket c);
	 List<Ticket> getTicket();
	 Ticket findTicketById(int ide,int idu);
	 void discount(int ide,int idu);
	public void deleteTicket(int ide,int idu);
}
