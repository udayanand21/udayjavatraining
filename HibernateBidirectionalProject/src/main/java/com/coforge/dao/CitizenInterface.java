package com.coforge.dao;

import java.util.List;

import com.coforge.entities.Citizen;

public interface CitizenInterface {
	List<Citizen>getAllCitizens();
	public void insertCitizen(Citizen citizen);
	public void updateCitizen(long cid, String name);
	Citizen getCitizenByAadhar(long aadharId);
	public void deleteCitizen(long cid);
	

}
