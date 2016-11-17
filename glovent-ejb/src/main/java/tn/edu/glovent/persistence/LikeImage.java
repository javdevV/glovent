package tn.edu.glovent.persistence;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: LikeImage
 *
 */
@Entity

public class LikeImage implements Serializable {

	   
	@Id
	private int id;
	@ManyToOne
	private Image img;
	@ManyToOne
	private User participant;
	private static final long serialVersionUID = 1L;

	public LikeImage() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
   
}
