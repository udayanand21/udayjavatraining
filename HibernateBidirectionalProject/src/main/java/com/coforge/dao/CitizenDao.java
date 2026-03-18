package com.coforge.dao;

import java.util.List;

import com.coforge.Util.HibernateUtil;
import com.coforge.entities.Citizen;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.coforge.entities.Aadhar;


public class CitizenDao implements CitizenInterface{

	@Override
	public List<Citizen> getAllCitizens() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Citizen> list = session.createQuery("from Citizen",Citizen.class).list();
		session.close();
		return list;
		
	
	}

	@Override
	public void insertCitizen(Citizen citizen) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txTransaction = session.beginTransaction();
		session.persist(citizen);
		txTransaction.commit();
		session.close();
		
		
	}

	@Override
	public void updateCitizen(long cid, String name) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txTransaction = session.beginTransaction();
		
		Citizen citizen = session.get(Citizen.class,cid);
		
		if(citizen!=null)
		{
			citizen.setCname(name);
			session.update(citizen);
		}
		txTransaction.commit();
		session.close();
		
		
		
	}

	@Override
	public Citizen getCitizenByAadhar(long aadharId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txTransaction = session.beginTransaction();
		Aadhar aadhar = session.get(Aadhar.class, aadharId);
		session.close();
		
		if(aadhar!=null)
		{
			return aadhar.getCitizen();
		}
		
		return null;
	}

	@Override
	public void deleteCitizen(long cid) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txTransaction = session.beginTransaction();
		
		Citizen citizen = session.get(Citizen.class, cid);
		if(citizen!=null)
		{
			session.remove(citizen);
		}
		txTransaction.commit();
		session.close();
		
		
	}
	
	
	

}
