package tn.edu.glovent.service;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.glovent.persistence.Video;





@Remote
public interface VideoEjbRemote {

	  public  void addvideo(Video video );
	  public List<Video> getvideo();
	  public Video findvideoById(int id);
	public void deletevideo(int id);
	public void updatevideo(Video c);
	public List<Video> findbygalerieId(int id);

}
