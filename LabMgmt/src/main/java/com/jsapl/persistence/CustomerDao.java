package com.jsapl.persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.jsapl.model.Customer;

public class CustomerDao {

	public List<Customer> getCustomers(String pageStart, String pageSize)
	{
		Session session = HibernateUtil.getAppSessionFactory().openSession();

		Query query = session.createQuery("from Customer");
		if(pageStart !=null){
			query = query.setFirstResult(Integer.valueOf(pageStart));
		}
		if(pageSize != null){
			query = query.setMaxResults(Integer.valueOf(pageSize));
		}

		List<Customer> list = query.list();
		session.close();
		
		return list;
	}


}
