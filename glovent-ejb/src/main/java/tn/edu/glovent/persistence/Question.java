package tn.edu.glovent.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: Question
 *
 */

//by sourour
@Entity
public class Question implements Serializable {

	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Id
	private int id;
	private String statement;
	private static final long serialVersionUID = 1L;
	
	
	@ManyToOne
	private Survey survey;
	@JsonIgnore
	@OneToMany(mappedBy ="quest",cascade=CascadeType.ALL)// fetch = FetchType.LAZY 
	private List<Answer> answers=new ArrayList<Answer>();
	

	public Question() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getStatement() {
		return this.statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}
	public Survey getSurvey() {
		return survey;
	}
	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
   
}
