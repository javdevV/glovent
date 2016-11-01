package tn.edu.glovent.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tn.edu.glovent.persistence.Survey;

//by sourour
@Stateless
public class SurveyService implements SurveyInterface {

	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public SurveyService() {

    }

	@Override
	public void addSurvey(Survey c) {

		em.persist(c);
	}

	@Override
	public boolean deleteSurvey(int c) {
		Survey u = em.find(Survey.class,c);
		if(u !=null){
			em.remove(u);
			return true;
		}else{
		return false;
		}
	}

	@Override
	public void updateSurvey(Survey c) {

		em.merge(c);
		
	}

	@Override
	public Survey findSurveyById(int idc) {
		
		return em.find(Survey.class, idc);
	}
	

	@Override
	public List<Survey> findAll() {
		return em.createQuery("SELECT c FROM Survey c ",Survey.class).getResultList(); 
	}

	@Override
	public Survey findSurveyByEvent(int ide) {
		return em.createQuery("SELECT c FROM Survey c WHERE c.MyEvent.idEvent=?1",
				Survey.class).setParameter(1, ide).getResultList().get(0);
		
	}
	
	

}
