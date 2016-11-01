package tn.edu.glovent.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: Survey
 *
 */
//by sourour
@Entity
public class Survey implements Serializable {

	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	@Id
	private int id;
	private String title;
	private String description;
	private static final long serialVersionUID = 1L;
	@JsonIgnore
	@OneToMany(mappedBy="survey",cascade=CascadeType.ALL)
	private List<Question> questions=new ArrayList<Question>();
	
	@OneToOne
	private Event MyEvent;

	public Survey() {
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

	public void setTitle(String title) {
		this.title = title;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Question> getQuestions() {
		return questions;
	}
	
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	public void affectQuestionsToSurvey(List<Question> lquest){
		for (Question c : lquest){
			c.setSurvey(this);
		}
		this.setQuestions(lquest);
	}
	
}
