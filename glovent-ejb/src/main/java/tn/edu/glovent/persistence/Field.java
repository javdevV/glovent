package tn.edu.glovent.persistence;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Field
 *
 */
@Entity
public class Field implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String label;
	private String type;
	
	@Enumerated(EnumType.STRING)
	private FieldCategory category ;
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private RegistrationForm MyRf;
	 
	public Field() {
		super();
	}   
	 
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
 	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}   
 	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	} 
	public FieldCategory getCategory() {
		return category;
	}
	public void setCategory(FieldCategory category) {
		this.category = category;
	}
	public RegistrationForm getMyRegistrationField() {
		return MyRf;
	}
	public void setMyRegistrationField(RegistrationForm myRf) {
		MyRf = myRf;
	}
	
	@Override
	public String toString() {
		return "Field [id=" + id + ", label=" + label + ", type=" + type + ", MyRf=" + MyRf + "]";
	}
	 
}
