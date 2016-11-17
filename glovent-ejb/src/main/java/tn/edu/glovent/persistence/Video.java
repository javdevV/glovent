package tn.edu.glovent.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: Video
 *
 */
@Entity

public class Video implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String url;
    @ManyToOne
    private Galerie galerie;
    @ManyToOne
    private Participant MyPatricipant;
    private int aime;
    private int danger;
    @OneToMany(mappedBy="vid")
    private List<LikeVideo> likes;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	
	private static final long serialVersionUID = 1L;

	public Video() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@XmlTransient
	public Galerie getGalerie() {
		return galerie;
	}
	public void setGalerie(Galerie galerie) {
		this.galerie = galerie;
	}
	public Participant getMyPatricipant() {
		return MyPatricipant;
	}
	public void setMyPatricipant(Participant myPatricipant) {
		MyPatricipant = myPatricipant;
	}

	
   
}
