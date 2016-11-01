package tn.edu.glovent.service;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.glovent.persistence.Answer;
import tn.edu.glovent.persistence.AnswerId;
import tn.edu.glovent.persistence.Options;

//by sourour
@Remote
public interface AnswerInterface {
	
	public void addAnswer(Answer c);

	void updateAnswer(Answer c);

	Answer findAnswerById(int idq, int idu);

	boolean deleteAnswer(int idq, int idu);

	List<Answer> findAll();

	int nbRepliesByQuestion(int idq, Options o);
}
