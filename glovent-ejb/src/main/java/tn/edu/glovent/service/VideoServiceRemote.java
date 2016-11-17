package tn.edu.glovent.service;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.glovent.persistence.Video;

@Remote
public interface VideoServiceRemote {
	void addVideo(Video Video );
	   List<Video> getVideo();
	   Video findVideoById(int id);
	   boolean deleteVideo(int id);
	   void updateVideo(Video c);
	   List<Video> findbygalerieId(int id);
}
