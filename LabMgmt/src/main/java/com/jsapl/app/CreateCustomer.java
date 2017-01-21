package com.jsapl.app;

import org.hibernate.Session;

import com.jsapl.persistence.CUID;
import com.jsapl.persistence.Customer;
import com.jsapl.persistence.CustomerContact;
import com.jsapl.persistence.CustomerType;
import com.jsapl.persistence.HibernateUtil;

public class CreateCustomer {
	public static void main(String[] args) {
		Session session = HibernateUtil.getAppSessionFactory().openSession();

		//Sample Transaction		
		session.beginTransaction();


		CustomerType customerType = (CustomerType)session.load(CustomerType.class, new Integer(1));
		
		Customer cust1 = new Customer();
		cust1.setCustId(CUID.getInstance().nextId());
		cust1.setName("Customer ABC");
		cust1.setPan("AKUPB9629G");
		cust1.setPhone("+91 9878987878787");
		cust1.setCustomerType(customerType);
		cust1.getContacts().add(new CustomerContact("Clark", "Clark@kony.com", "+19898998"));
		cust1.getContacts().add(new CustomerContact("Cheryl", "Cheryl@kony.com", "29784735"));

		
		session.save(cust1);
		
		session.getTransaction().commit();
		session.close();
		HibernateUtil.getAppSessionFactory().close();
	}
}
