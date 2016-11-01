package tn.edu.glovent.persistence;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: Answer
 *
 */

//by sourour
//va être util pour les statistiques
@Entity
public class Answer implements Serializable {
	@EmbeddedId
	private AnswerId id;
	@Enumerated(EnumType.STRING)
	private Options reply;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="id_user",referencedColumnName="idUser",
			insertable=false, updatable=false)
	private User user;
 
	@ManyToOne
	@JoinColumn(name="id_question",referencedColumnName="id",
			insertable=false, updatable=false)
	private Question quest;
		
	

	public Answer() {
		super();
	}   
	
	public Answer( Options reply, User user, Question quest) {
		super();
		this.id = new AnswerId(user.getIdUser(),quest.getId());
		this.reply = reply;
		this.user = user;
		this.quest = quest;
	}

	public AnswerId getId() {
		return this.id;
	}

	public void setId(AnswerId id) {
		this.id = id;
	}
	public Options getReply() {
		return reply;
	}
	public void setReply(Options reply) {
		this.reply = reply;
	}
	@JsonIgnore
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@JsonIgnore
	public Question getQuest() {
		return quest;
	}
	public void setQuest(Question quest) {
		this.quest = quest;
	}   
	
   
}
