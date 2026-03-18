package com.coforge.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.coforge.entities.Aadhar;

import com.coforge.Util.HibernateUtil;

public class AadharDao implements AadharInterface{

	public AadharDao getAadharById(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		AadharDao aadhar = session.get(AadharDao.class, id);
		session.close();
		return aadhar;
		
	}

}
