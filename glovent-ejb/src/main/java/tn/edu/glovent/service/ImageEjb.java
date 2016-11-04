package tn.edu.glovent.service;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import tn.edu.glovent.persistence.Image;

/**
 * Session Bean implementation class ImageEjb
 */

public class ImageEjb implements ImageEjbRemote {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="pidev-ejb")
	EntityManager em;
    public ImageEjb() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public void addimage(Image image) {
		
		 em.persist(image);
		
	}
	@Override
	public List<Image> getimage() {
		// TODO Auto-generated method stub
		 return em.createQuery("From Image").getResultList();
	}
	@Override
	public Image findImageById(int id) {
		// TODO Auto-generated method stub
		return em.find(Image.class, id);
	}
	@Override
	public void deleteImage(int id) {
		Image i =new Image();
		i =findImageById(id);
		em.remove(i);
		
	}
	@Override
	public void updateImage(Image c) {
		em.merge(c);
		
	}
	@Override
	public List<Image> findbygalerieId(int id) {
		 return em.createQuery("SELECT i from Image i inner join i.galerie g where g.id= :id1").setParameter("id1", id).getResultList();
		//select i from image i inner join i.galerie g where g.id= :id 
	}
	


}
