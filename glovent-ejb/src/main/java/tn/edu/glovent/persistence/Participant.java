package tn.edu.glovent.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: Participant
 *
 */
@Entity

public class Participant extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private String rand;
	private String friendrand;
	@OneToMany(mappedBy="participant")
   private List<Ticket> tickets;
	
   @OneToMany(mappedBy="MyPatricipant")
   private List<Image> images;
   
   @OneToMany(mappedBy="MyPatricipant")
   private List<Video> video;
   
	@OneToMany(mappedBy="participant")
	private List<LikeImage> likeimages;
	@OneToMany(mappedBy="userr")
	private List<LikeVideo> likevideo;
	public Participant() {
		super();
	}

	public String getRand() {
		return rand;
	}

	public void setRand(String rand) {
		this.rand = rand;
	}

	public String getFriendrand() {
		return friendrand;
	}




	public void setFriendrand(String friendrand) {
		this.friendrand = friendrand;
	}




	public List<Ticket> getTickets() {
		return tickets;
	}




	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}




	public List<Image> getImages() {
		return images;
	}




	public void setImages(List<Image> images) {
		this.images = images;
	}




	public List<Video> getVideo() {
		return video;
	}




	public void setVideo(List<Video> video) {
		this.video = video;
	}
	
   
}
