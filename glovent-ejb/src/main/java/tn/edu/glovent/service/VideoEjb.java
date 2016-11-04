package tn.edu.glovent.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.glovent.persistence.Video;


/**
 * Session Bean implementation class VideoEjb
 */
@Stateless
@LocalBean
public class VideoEjb implements VideoEjbRemote {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="pidev-ejb")
	EntityManager em;
    public VideoEjb() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addvideo(Video video) {
		// TODO Auto-generated method stub
		em.persist(video);
	}

	@Override
	public List<Video> getvideo() {
		// TODO Auto-generated method stub
		 return em.createQuery("From Video").getResultList();
	}

	@Override
	public Video findvideoById(int id) {
		// TODO Auto-generated method stub
		return em.find(Video.class, id);
	}

	@Override
	public void deletevideo(int id) {
		Video vid =new Video();
		vid =findvideoById(id);
		em.remove(vid);
		
	}

	@Override
	public void updatevideo(Video c) {
		em.merge(c);
		
	}

	@Override
	public List<Video> findbygalerieId(int id) {
		// TODO Auto-generated method stub
		 return em.createQuery("SELECT i from Video i inner join i.galerie g where g.id= :id1").setParameter("id1", id).getResultList();
	}

}
