package com.jsapl.app;

import java.sql.Date;
import java.util.Calendar;

import org.hibernate.Session;

import com.jsapl.model.Customer;
import com.jsapl.model.CustomerContact;
import com.jsapl.model.CustomerType;
import com.jsapl.model.Sample;
import com.jsapl.persistence.HibernateUtil;
import com.jsapl.util.CUID;

public class CreateCustomer {
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getAppSessionFactory().openSession();

		//Sample Transaction		
		session.beginTransaction();


		CustomerType customerType = (CustomerType)session.load(CustomerType.class, new Integer(1));
		
		Customer cust1 = new Customer();
		cust1.setCustId(CUID.getInstance().nextId());
		cust1.setName("Customer WHY");
		cust1.setPan("MHUPM78879H");
		cust1.setPhone("+91 8765438987");
		cust1.setCustomerType(customerType);
		cust1.getContacts().add(new CustomerContact("Anil", "Anil@why.com", "+91 9876789876"));
		cust1.getContacts().add(new CustomerContact("Srinivas", "Srinivas@why.com", "+91 8978675645"));
		cust1.setCreatedBy("anjali-reception");
		cust1.setCreatedOn(new Date(Calendar.getInstance().getTimeInMillis()));
		
		session.save(cust1);
		session.getTransaction().commit();
		session.close();
		HibernateUtil.getAppSessionFactory().close();
	}
	
	public static void createCustomers(){
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
		
		
		
		
		
		//2nd transaction
		session.beginTransaction();
		
		
		Sample sample1 = new Sample();
		sample1.setSampleId(CUID.getInstance().nextId());
		sample1.setCustomer(cust1);
		sample1.setForm(Sample.Form.Wires);
		sample1.setReceivedDate(new Date(Calendar.getInstance().getTimeInMillis()));
		//sample1.setRequiredSpecification("IS 713-1981 Gr: ZnAl4Cu1");
		sample1.setSize(10);
		sample1.setStatus(Sample.Status.Received);
		
		Sample sample2 = new Sample();
		sample2.setSampleId(CUID.getInstance().nextId());
		sample2.setCustomer(cust1);
		sample2.setForm(Sample.Form.Powder);
		sample2.setReceivedDate(new Date(Calendar.getInstance().getTimeInMillis()));
		//sample2.setRequiredSpecification("IS 713-1981 Gr: kcjahsj");
		sample2.setSize(1);
		sample2.setStatus(Sample.Status.Received);
		
		Sample sample3 = new Sample();
		sample3.setSampleId(CUID.getInstance().nextId());
		sample3.setCustomer(cust1);
		sample3.setForm(Sample.Form.Pipe);
		sample3.setReceivedDate(new Date(Calendar.getInstance().getTimeInMillis()));
		//sample3.setRequiredSpecification("IS 950-19");
		sample3.setSize(50);
		sample3.setStatus(Sample.Status.Used);
		
		session.save(sample1);
		session.save(sample2);
		session.save(sample3);
		
		
		session.getTransaction().commit();
		
		
		
		
		
		
		session.close();
		HibernateUtil.getAppSessionFactory().close();
	}
}
