package tn.edu.glovent.service;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.glovent.persistence.RegistrationForm;

@Remote
public interface RegistrationFormServiceRemote {
	/**
	 * this method adds a RegistrationForm
	 * @param rf
	 */
	public void addRegistrationForm(RegistrationForm rf);
	
	/**
	 * this method updates a RegistrationForm
	 */
	public void updateRegistrationForm(RegistrationForm rf);
	
	/**
	 * this method removes a RegistrationForm by id 
	 */
	public void deleteRegistrationForm(int id );
	/**
	 * this method removes a RegistrationForm by object  
	 * @param rf
	 */
	public void deleteEntireRegistrationForm(RegistrationForm rf ) ;
	
	/**
	 * this methode clear all RegistrationForms
	 */
	public void clearRegistrationForm();
	
	/**
	 * get a RegistrationForm by Id
	 */
	public RegistrationForm getRegFormById(int id);
	/**
	 * this method lists all RegistrationForm
	 */
	public List<RegistrationForm>getAllRegForm();
	
	public List<RegistrationForm>getRegFormbyName(String name);

	public void updateOneRegistrationForm(int id);
	
	
	
}
