package tn.edu.glovent.service;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.glovent.persistence.Survey;
//by sourour
@Remote
public interface SurveyInterface {
	public void addSurvey(Survey c);
	public void updateSurvey(Survey c);
	public Survey findSurveyById(int idc);
	public List<Survey> findAll() ;
	public Survey findSurveyByEvent(int ide);
	public boolean deleteSurvey(int c);
	
}
