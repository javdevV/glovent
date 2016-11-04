package tn.edu.glovent.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: Galerie
 *
 */
@Entity

public class Galerie implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
    @OneToOne 
    private Event event;
    @OneToMany(mappedBy="galerie")
    private List<Image> images;
    @OneToMany(mappedBy="galerie")
    private List<Video> video;
	private static final long serialVersionUID = 1L;
	@XmlTransient
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	@XmlTransient
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}
	public Galerie() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@XmlTransient
	public List<Video> getVideo() {
		return video;
	}
	public void setVideo(List<Video> video) {
		this.video = video;
	}
	@Override
	public String toString() {
		return "Galerie [id=" + id + ", name=" + name + ", event=" + event + "]";
	}
	
   
}
