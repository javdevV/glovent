package tn.edu.glovent.service;

import java.util.List;
import javax.ejb.Remote;
import tn.edu.glovent.persistence.*;

@Remote
public interface FieldServiceRemote {
	/**
	 * this method adds a field 
	 * @param f
	 */
	public void addField(Field f);
	
	/**
	 * this method deletes a field 
	 * @param f
	 */
	public void deleteField(int id);
	
	/**
	 * this method updates a field 
	 * @param f
	 * @return string 
	 */
	public void updateField(Field f);
	
	/**
	 * this method finds a field by id 
	 * @param id
	 */
	public Field findFieldbyId(int id );
	
	/**
	 * this method lists all fields 
	 * @return list
	 */
	public List<Field> getAllFields();
	/**
	 * this method find a fiend by name
	 * @param name
	 * @return
	 */
	public Field findFieldByName(String name);
	
	
	
}