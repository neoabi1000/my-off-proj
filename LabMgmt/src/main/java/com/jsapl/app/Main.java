package com.jsapl.app;

import org.hibernate.Session;

import com.jsapl.persistence.CUID;
import com.jsapl.persistence.Customer;
import com.jsapl.persistence.CustomerContact;
import com.jsapl.persistence.HibernateUtil;
import com.jsapl.persistence.Site;

public class Main {
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getAppSessionFactory().openSession();
		
		//Sample Transaction		
		session.beginTransaction();
		
//		Site site1 = new Site();
//		site1.setId(1);
//		site1.setSiteCode("01");
//		site1.setAddress("Madhaur");
//		site1.getContacts().add("santthosh@gmail.com");
//		site1.getContacts().add("7032662743");
		
		
//		Customer cust1 = new Customer();
//		cust1.setCustId(CUID.getInstance().nextId());
//		cust1.setName("Santhosh Bist");
//		cust1.setPhone("4756786485798");
//		cust1.getContacts().add(new CustomerContact("Hash Bodhi", "harsh.bodhi@kony.com", "874875893"));
//		cust1.getContacts().add(new CustomerContact("Bipin Jethwani", "bipin.jethwani@kony.com", "29784735"));
//		
//		Customer cust2 = new Customer();
//		cust2.setCustId(CUID.getInstance().nextId());
//		cust2.setName("Santhosh1 Bist");
//		cust2.setPhone("4756786485798");
//		cust2.getContacts().add(new CustomerContact("Hash Bodhi", "harsh.bodhi@kony.com", "874875893"));
//		cust2.getContacts().add(new CustomerContact("Bipin Jethwani", "bipin.jethwani@kony.com", "29784735"));
//		
//		
//		Customer cust3 = new Customer();
//		cust3.setCustId(CUID.getInstance().nextId());
//		cust3.setName("Santhosh2 Bist");
//		cust3.setPhone("4756786485798");
//		cust3.getContacts().add(new CustomerContact("Hash Bodhi", "harsh.bodhi@kony.com", "874875893"));
//		cust3.getContacts().add(new CustomerContact("Bipin Jethwani", "bipin.jethwani@kony.com", "29784735"));
//		
//		
//		session.save(cust1);
//		session.save(cust2);
//		session.save(cust3);
		
		//session.save(site1);
		
		
		Customer cust1 = (Customer)session.load(Customer.class, new Long(7725957252340776963L));
		session.delete(cust1);
		
		
		session.getTransaction().commit();
		session.close();
		HibernateUtil.getAppSessionFactory().close();
	}
}
