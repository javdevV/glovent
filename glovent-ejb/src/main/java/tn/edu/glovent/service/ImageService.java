package tn.edu.glovent.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.glovent.persistence.Galerie;
import tn.edu.glovent.persistence.Image;
import tn.edu.glovent.persistence.LikeImage;

/**
 * Session Bean implementation class ImageService
 */
@Stateless
@LocalBean
public class ImageService implements ImageServiceRemote, ImageServiceLocal {

	@PersistenceContext
	EntityManager em;
    public ImageService() {
      super();
    }

	@Override
	public void addimage(Image image) {
		em.persist(image);
		
	}

	@Override
	public List<Image> getimage() {
		return em.createQuery("select e from Image e ", Image.class).getResultList();
	}

	@Override
	public Image findImageById(int id) {
		return em.find(Image.class, id);
	}

	@Override
	public boolean deleteImage(int id) {
		Image g = em.find(Image.class,id);
		if(g !=null){
			em.remove(g);
			return true;
		}else{
		return false;
		}	
	}

	@Override
	public void updateImage(Image c) {
		em.merge(c);
		
	}

	@Override
	public List<Image> findbygalerieId(int id) {
		 return em.createQuery("SELECT i from Image i inner join i.galerie g where g.id= :id1").setParameter("id1", id).getResultList();
	}

	@Override
	public boolean likeImage(int idi, int idu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dislikeImage(int idi, int idu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean signalImage(int idi, int idu) {
		// TODO Auto-generated method stub
		return false;
	}
	public LikeImage searchlike(int idi, int idu){
		return null;
		// return em.createQuery("SELECT i from LikeImage i inner join i.img g i.user u where g.id= :id1 u.idUser= :id2" ).setParameter("id1", idi).setParameter("id2", idu).getSingleResult();
		
	}

}
