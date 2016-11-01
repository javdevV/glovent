package tn.edu.glovent.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
//by sourour
@Embeddable
public class AnswerId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="id_question")
	private int QuestionId;
	@Column(name="id_user")
	private int UserId;
	
	
	
	public AnswerId() {
		super();
	}
	public AnswerId( int userId, int questionId) {
		super();
		QuestionId = questionId;
		UserId = userId;
	}
	
	public int getQuestionId() {
		return QuestionId;
	}
	public void setQuestionId(int questionId) {
		QuestionId = questionId;
	}
	
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + QuestionId;
		result = prime * result + UserId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnswerId other = (AnswerId) obj;
		if (QuestionId != other.QuestionId)
			return false;
		if (UserId != other.UserId)
			return false;
		return true;
	}
	
	
	

}
