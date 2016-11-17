package tn.edu.glovent.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="Events")

public class Event implements Serializable {

	
	
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	//yosra
	@OneToMany(mappedBy="event")
	private List<Ticket> MyTickets;
	private Chalange chalange;
	
	@OneToOne
	private RegistrationForm MyRegistrationForm;
	
	//sourour
		@OneToOne(mappedBy="MyEvent")
		private Survey MySurvey;
	
	
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
	public boolean getAvaibility() {
	return avaibility ;
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
	@JsonIgnore
	public List<User> getListeP() {
		return listeP;
	}
	public void setListeP(List<User> listeP) {
		this.listeP = listeP;
	}
	@Override
	public String toString() {
		return "Event [idEvent=" + idEvent + ", localisation=" + localisation + ", avaibility=" + avaibility
				+ ", dateEvent=" + dateEvent + ", theme=" + theme + ", nameEvent=" + nameEvent + "]";
	}
	public List<Task> getTasks() {
		return Tasks;
	}
	public void setTasks(List<Task> tasks) {
		Tasks = tasks;
	}
	public Organization getMyOrganization() {
		return MyOrganization;
	}
	public void setMyOrganization(Organization myOrganization) {
		MyOrganization = myOrganization;
	}
	public Category getMyCategory() {
		return MyCategory;
	}
	public void setMyCategory(Category myCategory) {
		MyCategory = myCategory;
	}
	public List<Ticket> getMyTickets() {
		return MyTickets;
	}
	public void setMyTickets(List<Ticket> myTickets) {
		MyTickets = myTickets;
	}
	public RegistrationForm getMyRegistrationForm() {
		return MyRegistrationForm;
	}
	public void setMyRegistrationForm(RegistrationForm myRegistrationForm) {
		MyRegistrationForm = myRegistrationForm;
	}
	public Survey getMySurvey() {
		return MySurvey;
	}
	public void setMySurvey(Survey mySurvey) {
		MySurvey = mySurvey;
	}
	public Chalange getChalange() {
		return chalange;
	}
	public void setChalange(Chalange chalange) {
		this.chalange = chalange;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}