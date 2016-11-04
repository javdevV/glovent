package tn.edu.glovent.service;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.glovent.persistence.Galerie;




@Remote
public interface GalerieEjbRemote {

	public void addGalerie(Galerie c);
	public void deleteGalerie(int id);
	public void updateGalerie(Galerie c);
	public Galerie findGalerieById(int idGalerie);
	public List<Galerie>findAllGalerie();
	
	
	
}
