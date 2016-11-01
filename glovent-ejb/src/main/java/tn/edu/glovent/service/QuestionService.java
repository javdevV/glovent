package tn.edu.glovent.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.glovent.persistence.Answer;
import tn.edu.glovent.persistence.Options;
import tn.edu.glovent.persistence.Question;
import tn.edu.glovent.persistence.Survey;
//by sourour
@Stateless
public class QuestionService implements QuestionInterface {

	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public QuestionService() {

    }
	@Override
	public void addQuestion(Question c) {
		em.persist(c);

	}

	@Override
	public void deleteQuestion(int c) {
		
		Question u = em.find(Question.class,c);
		//*******
		if(u.getAnswers().size()==0)
		
				em.remove(u);
				
			
	}

	@Override
	public void updateQuestion(Question c) {
		em.merge(c);

	}

	@Override
	public Question findQuestionById(int idc) {
		return em.find(Question.class, idc);
		
	}

	@Override
	public List<Question> findAll() {
		return em.createQuery("SELECT c FROM Question c ",Question.class).getResultList(); 
		
	}
//	***********
	@Override
	public List<Question> QuestionsBySurvey(int ids) {
		return em.createQuery("SELECT c FROM Question c "
				+ "WHERE c.survey.id=?1",Question.class).setParameter(1, ids).getResultList(); 
		
	}
	@Override
	public int nbQuestionBySurvey(int ids) {
		return this.QuestionsBySurvey(ids).size();
	}
	
	
	
	

}
