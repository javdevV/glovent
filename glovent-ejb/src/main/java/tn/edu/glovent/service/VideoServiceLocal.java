package tn.edu.glovent.service;

import java.util.List;

import javax.ejb.Local;

import tn.edu.glovent.persistence.Video;

@Local
public interface VideoServiceLocal {
	void addVideo(Video Video );
	   List<Video> getVideo();
	   Video findVideoById(int id);
	   boolean deleteVideo(int id);
	   void updateVideo(Video c);
	   List<Video> findbygalerieId(int id);
}
