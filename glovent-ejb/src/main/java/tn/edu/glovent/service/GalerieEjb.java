package tn.edu.glovent.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.glovent.persistence.Galerie;



/**
 * Session Bean implementation class GalerieEjb
 */
@Stateless
@LocalBean
public class GalerieEjb implements GalerieEjbRemote {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="pidev-ejb")
	EntityManager em;
    public GalerieEjb() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addGalerie(Galerie c) {
		em.persist(c);
		
	}

	@Override
	public void deleteGalerie(int id) {
		Galerie g =new Galerie();
		g =findGalerieById(id);
		em.remove(g);
		
	}

	@Override
	public void updateGalerie(Galerie c) {
		em.merge(c);
		
	}

	@Override
	public Galerie findGalerieById(int idGalerie) {
		// TODO Auto-generated method stub
		return em.find(Galerie.class, idGalerie);
	}

	@Override
	public List<Galerie> findAllGalerie() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT c FROM Client c ",Galerie.class).getResultList();
	}

	

}
