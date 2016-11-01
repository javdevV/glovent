package tn.edu.glovent.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: President
 *
 */
@Entity

public class President extends User implements Serializable {

	
	private int attachement_file;
	private static final long serialVersionUID = 1L;

	@OneToOne
	private Organization MyOrganization;
	
	@OneToMany(mappedBy="MyPresident")
	private List<Poll> MyPolls;
	
	public President() {
		super();
	}   
	public int getAttachement_file() {
		return this.attachement_file;
	}

	public void setAttachement_file(int attachement_file) {
		this.attachement_file = attachement_file;
	}
   
}
