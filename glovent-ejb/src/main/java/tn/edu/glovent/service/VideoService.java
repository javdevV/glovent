package tn.edu.glovent.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.glovent.persistence.Image;
import tn.edu.glovent.persistence.Video;

/**
 * Session Bean implementation class VideoService
 */
@Stateless
@LocalBean
public class VideoService implements VideoServiceRemote, VideoServiceLocal {
	@PersistenceContext
	EntityManager em;
    public VideoService() {
       super();
    }

	@Override
	public void addVideo(Video Video) {
		em.persist(Video);
		
	}

	@Override
	public List<Video> getVideo() {
		return em.createQuery("select e from Video e ", Video.class).getResultList();
	}

	@Override
	public Video findVideoById(int id) {
		return em.find(Video.class, id);
	}

	@Override
	public boolean deleteVideo(int id) {
		Video g = em.find(Video.class,id);
		if(g !=null){
			em.remove(g);
			return true;
		}else{
		return false;
		}	
	}

	@Override
	public void updateVideo(Video c) {
		em.merge(c);
		
	}

	@Override
	public List<Video> findbygalerieId(int id) {
		return em.createQuery("SELECT i from Video i inner join i.galerie g where g.id= :id1").setParameter("id1", id).getResultList();
	}

}
