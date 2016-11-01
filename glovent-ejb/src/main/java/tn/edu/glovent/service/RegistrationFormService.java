package tn.edu.glovent.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.glovent.persistence.RegistrationForm;

/**
 * Session Bean implementation class RegistrationFormService
 */
@Stateless
@LocalBean
public class RegistrationFormService implements RegistrationFormServiceRemote {

	@PersistenceContext
	EntityManager em ;
	
    /**
     * Default constructor. 
     */
    public RegistrationFormService() {
    	
    }

	@Override
	public void addRegistrationForm(RegistrationForm rf) {
		em.persist(rf);
		
	}

	@Override
	public void updateRegistrationForm(RegistrationForm rf) {
		em.merge(rf);
	}

	@Override
	public void deleteRegistrationForm(int id ) {
		RegistrationForm r = em.find(RegistrationForm.class, id);
		em.remove(r);
	}

	@Override
	public void clearRegistrationForm() {
	    Query q3 = em.createNativeQuery("DELETE FROM RegistrationForm");
	    q3.executeUpdate();
		
	}

	@Override
	public RegistrationForm getRegFormById(int id) {
		return em.find(RegistrationForm.class, id);
		
	}

	@Override
	public List<RegistrationForm> getAllRegForm() {
		
		return em.createQuery("SELECT r FROM RegistrationForm r",RegistrationForm.class).getResultList();
	}

	@Override
	public List<RegistrationForm> getRegFormbyName(String name) {
		return em.createQuery("SELECT r FROM RegistrationForm r WHERE r.title=:na",RegistrationForm.class)
				.setParameter("na", name).getResultList();
	}
	
	

}
