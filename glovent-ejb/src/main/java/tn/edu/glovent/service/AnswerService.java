package tn.edu.glovent.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.glovent.persistence.Answer;
import tn.edu.glovent.persistence.AnswerId;
import tn.edu.glovent.persistence.Options;

@Stateless
public class AnswerService implements AnswerInterface {


	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public AnswerService() {

    }
	@Override
	public void addAnswer(Answer c) {
		em.persist(c);
	}

	@Override
	public boolean deleteAnswer(int idq,int idu) {
		Answer u = this.findAnswerById( idq, idu);
		if(u !=null){
			em.remove(u);
			return true;
		}else{
		return false;
		}

	}

	@Override
	public void updateAnswer(Answer c) {
		em.merge(c);

	}

	@Override
	public Answer findAnswerById(int idq,int idu) {
		AnswerId idc= new AnswerId(idu,idq);
		return em.find(Answer.class, idc);
	}

	@Override
	public List<Answer> findAll() {
		return em.createQuery("SELECT c FROM Answer c",Answer.class).getResultList(); 

	}
	@Override
	public int nbRepliesByQuestion(int idq,Options o) {
		
		return em.createQuery("SELECT c FROM Answer c "
				+ "WHERE c.reply=?1 and c.id.QuestionId=?2" ,Answer.class)
				.setParameter(1,o).setParameter(2,idq)
				.getResultList().size(); 
		
	}
}
