package tn.edu.glovent.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.glovent.persistence.Event;
import tn.edu.glovent.persistence.Galerie;
import tn.edu.glovent.persistence.Organization;

/**
 * Session Bean implementation class GalerieService
 */
@Stateless
@LocalBean
public class GalerieService implements GalerieServiceRemote, GalerieServiceLocal {


	@PersistenceContext
	private EntityManager em;
    public GalerieService() {
    	super();
    }

	@Override
	public void addGalerie(Galerie g) {
		em.persist(g);
		
	}

	@Override
	public boolean deleteGalerie(int id) {
		Galerie g = em.find(Galerie.class,id);
		if(g !=null){
			em.remove(g);
			return true;
		}else{
		return false;
		}		
	}

	@Override
	public void updateGalerie(Galerie g) {
		em.merge(g);
		
	}

	@Override
	public Galerie findGalerieById(int id) {
		return em.find(Galerie.class, id);
	}

	@Override
	public List<Galerie> findAllGalerie() {
		return em.createQuery("select e from Galerie e ", Galerie.class).getResultList();
	}

}
