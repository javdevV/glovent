package tn.edu.glovent.service;

import javax.ejb.Local;

@Local
public interface ParticipantServiceLocal {
	public String inviteamis(int id);
}
