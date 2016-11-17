package tn.edu.glovent.service;

import java.util.List;

import javax.ejb.Local;

import tn.edu.glovent.persistence.Image;

@Local
public interface ImageServiceLocal {
	   void addimage(Image image );
	   List<Image> getimage();
	   Image findImageById(int id);
	   boolean deleteImage(int id);
	   void updateImage(Image c);
	   List<Image> findbygalerieId(int id);
	   boolean likeImage(int idi,int idu);
	   boolean dislikeImage(int idi,int idu);
	   boolean signalImage(int idi,int idu);

}
