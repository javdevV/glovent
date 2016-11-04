package tn.edu.glovent.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: RegistrationForm
 *
 */
@Entity
 public class RegistrationForm implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;

	private static final long serialVersionUID = 1L;

	@OneToOne(mappedBy = "MyRegistrationForm",fetch=FetchType.LAZY)
	private Event MyEvent;
	 

	@OneToMany(mappedBy = "MyRf", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Field> MyFields = new ArrayList<Field>();
	
	public RegistrationForm() {
		super();
	}

 	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
 	public String getTitle() {
		return this.title;
	}

	public Event getMyEvent() {
		return MyEvent;
	}

	public void setMyEvent(Event myEvent) {
		MyEvent = myEvent;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@JsonIgnore
	public List<Field> getMyFields() {
		return MyFields;
	}

	public void setMyFields(List<Field> myFields) {
		MyFields = myFields;
	}

	
	
	public void addFieldToForm(List<Field> listeFields) {
		for (Field x : listeFields) {
			x.setMyRegistrationField(this);
		}
		this.setMyFields(listeFields);
	}

	@Override
	public String toString() {
		return "RegistrationForm [id=" 	+ id + ", title=" + title + "]";
	}

}
