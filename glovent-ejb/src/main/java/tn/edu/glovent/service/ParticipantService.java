package tn.edu.glovent.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Part;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.glovent.persistence.Event;
import tn.edu.glovent.persistence.Participant;
import tn.edu.glovent.persistence.User;




/**
 * Session Bean implementation class ParticipantService
 */
@Stateless
@LocalBean
public class ParticipantService implements ParticipantServiceRemote, ParticipantServiceLocal {

	@PersistenceContext
	EntityManager em;
	@EJB
	UserServicesRemote us;
	
    public ParticipantService() {
       super();
    }

	@Override
	public String inviteamis(int id) {

		Random random = new Random();
        random.nextInt(9999999);
        int myRandomNumber = random.nextInt();
        String rand = ""+myRandomNumber;
      User u =new Participant();
      u=us.searchUserById(id);

      
      //u.setRand(rand);
      em.merge(u);
        return rand;
	}

	@Override
	public int countinvit(int id) {
		
		
		
		User u =new User();
        u =us.searchUserById(id);
     //   String friendrand = u.getRand();
		List< User>listuser = new ArrayList<>();
		listuser = em.createQuery("SELECT i from User i  where i.friendrand=friendrand").getResultList();
		int count = listuser.size();
		return count;
	}

}
