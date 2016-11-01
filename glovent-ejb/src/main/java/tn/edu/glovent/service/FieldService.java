package tn.edu.glovent.service;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.glovent.persistence.Field;

/**
 * Session Bean implementation class FieldServiceRemote
 */
@Stateless
@LocalBean
public class FieldService implements FieldServiceRemote {
	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public FieldService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addField(Field f) {
		em.persist(f);
	}

	@Override
	public void deleteField(int id ) {
		Field f = em.find(Field.class, id);
		em.remove(f);
	}

	@Override
	public void updateField(Field f) {
		em.merge(f);
	}

	@Override
	public Field findFieldbyId(int id) {
		return em.find(Field.class, id);
	}

	@Override
	public List<Field> getAllFields() {
		return em.createQuery("SELECT f FROM Field f ",Field.class).getResultList();
	}

	@Override
	public Field findFieldByName(String name) {
		
		return (Field) em.createQuery("SELECT f FROM Field f WHERE f.label=?1",Field.class).setParameter(1, name).getSingleResult();
	}
	
	
}
