package com.jsapl.app;

import org.hibernate.Session;

import com.jsapl.persistence.Customer;
import com.jsapl.persistence.CustomerType;
import com.jsapl.persistence.HibernateUtil;

public class AddCustomerType {
	public static void main(String[] args) {

		Session session = HibernateUtil.getAppSessionFactory().openSession();

		//Sample Transaction		
		session.beginTransaction();


		CustomerType customerType1 = new CustomerType("Platinum", 200_000);
		CustomerType customerType2 = new CustomerType("Gold", 100_000);
		CustomerType customerType3 = new CustomerType("Silver", 25_000);
		CustomerType customerType4 = new CustomerType("Bronze", 5_000);
		CustomerType customerType5 = new CustomerType("Walk-in", 0);
		
		session.save(customerType1);
		session.save(customerType2);
		session.save(customerType3);
		session.save(customerType4);
		session.save(customerType5);

		
		
		
		session.getTransaction().commit();
		session.close();
		HibernateUtil.getAppSessionFactory().close();
	}
}
