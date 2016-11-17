package tn.edu.glovent.persistence;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: LikeVideo
 *
 */
@Entity

public class LikeVideo implements Serializable {

	   
	@Id
	private int id;
	@ManyToOne
	private Video vid;
	@ManyToOne
	private User userr;
	private static final long serialVersionUID = 1L;

	public LikeVideo() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
   
}
