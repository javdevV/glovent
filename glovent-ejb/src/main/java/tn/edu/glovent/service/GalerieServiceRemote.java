package tn.edu.glovent.service;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.glovent.persistence.Galerie;



@Remote
public interface GalerieServiceRemote {
	 void addGalerie(Galerie g);
	 boolean deleteGalerie(int id);
	 void updateGalerie(Galerie g);
	 Galerie findGalerieById(int id);
	 List<Galerie>findAllGalerie();
	 

}
