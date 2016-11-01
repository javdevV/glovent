package tn.edu.glovent.persistence;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Events")
public class Event {
    @Id
	private int idEvent;
	private String localisation;
	private boolean avaibility;
	private Date dateEvent;
	private String theme;
	private String nameEvent;
	@ManyToMany
	private List<User> listeP;
	
	@OneToMany(mappedBy="MyEvent")
	private List<Task> Tasks;
	
	@ManyToOne
	private Organization MyOrganization;
	
	@ManyToOne
	private Category MyCategory;
	
	@OneToMany(mappedBy="MyEvent")
	private List<Ticket> MyTickets;
	
	
	@OneToOne
	private RegistrationForm MyRegistrationForm;
	
	
	
	
	public Event() {
		super();
	}
	public Event(int idEvent, String localisation, boolean avaibility, Date dateEvent, String theme, String nameEvent,
			List<User> listeP) {
		super();
		this.idEvent = idEvent;
		this.localisation = localisation;
		this.avaibility = avaibility;
		this.dateEvent = dateEvent;
		this.theme = theme;
		this.nameEvent = nameEvent;
		this.listeP = listeP;
	}
	public int getIdEvent() {
		return idEvent;
	}
	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}
	public String getLocalisation() {
		return localisation;
	}
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	public boolean isAvaibility() {
		return avaibility;
	}
	public void setAvaibility(boolean avaibility) {
		this.avaibility = avaibility;
	}
	public Date getDateEvent() {
		return dateEvent;
	}
	public void setDateEvent(Date dateEvent) {
		this.dateEvent = dateEvent;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getNameEvent() {
		return nameEvent;
	}
	public void setNameEvent(String nameEvent) {
		this.nameEvent = nameEvent;
	}
	public List<User> getListeP() {
		return listeP;
	}
	public void setListeP(List<User> listeP) {
		this.listeP = listeP;
	}
	
	@Override
	public String toString() {
		return "Event [idEvent=" + idEvent + ", localisation=" + localisation + ", avaibility=" + avaibility
				+ ", dateEvent=" + dateEvent + ", theme=" + theme + ", nameEvent=" + nameEvent + ", listeP=" + listeP
				+ "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}