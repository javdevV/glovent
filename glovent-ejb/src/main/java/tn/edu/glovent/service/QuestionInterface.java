package tn.edu.glovent.service;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.glovent.persistence.Options;
import tn.edu.glovent.persistence.Question;
//by sourour
@Remote
public interface QuestionInterface {

	public void addQuestion(Question c);
	public void updateQuestion(Question c);
	public Question findQuestionById(int idc);
	public List<Question> findAll() ;
	public List<Question> QuestionsBySurvey(int ids);
	public int nbQuestionBySurvey(int ids) ;
	public void deleteQuestion(int c);
}
