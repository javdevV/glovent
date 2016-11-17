package tn.edu.glovent.service;

import java.util.List;

import javax.ejb.Local;

import tn.edu.glovent.persistence.Galerie;

@Local
public interface GalerieServiceLocal {
	 void addGalerie(Galerie g);
	 boolean deleteGalerie(int id);
	 void updateGalerie(Galerie g);
	 Galerie findGalerieById(int id);
	 List<Galerie>findAllGalerie();
}
