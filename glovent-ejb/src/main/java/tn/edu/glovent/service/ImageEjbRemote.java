package tn.edu.glovent.service;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.glovent.persistence.Image;


@Remote
public interface ImageEjbRemote {
	

	  public  void addimage(Image image );
	  public List<Image> getimage();
	  public Image findImageById(int id);
		public void deleteImage(int id);
		public void updateImage(Image c);
		public List<Image> findbygalerieId(int id);
}
