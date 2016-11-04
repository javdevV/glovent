package tn.edu.glovent.persistence;

import java.io.File;
import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: Image
 *
 */
@Entity

public class Image implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	 private byte[] image; 
	
    @ManyToOne
    private Galerie galerie;
    @ManyToOne
    private User user;
	private static final long serialVersionUID = 1L;
	
	@XmlTransient
	public Galerie getGalerie() {
		return galerie;
	}
	public void setGalerie(Galerie galerie) {
		this.galerie = galerie;
	}
	@XmlTransient
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Image() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	 @Lob @Basic(fetch= FetchType.EAGER)
	   public byte[] getImage() {
	      return image;
	   }

	   public void setImage(byte[] image) {
	      this.image = image;
	   }

	
}
