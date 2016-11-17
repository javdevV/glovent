package tn.edu.glovent.service;

import javax.ejb.Remote;

@Remote
public interface ParticipantServiceRemote {
	public String inviteamis(int id);
	public int countinvit(int id);
}
