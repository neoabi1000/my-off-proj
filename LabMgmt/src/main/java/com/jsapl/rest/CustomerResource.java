package com.jsapl.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;

import com.jsapl.persistence.Customer;
import com.jsapl.persistence.HibernateUtil;

@Path("customer")
public class CustomerResource {


	//	@GET
	//	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	//	public List<Customer> getCustomerList(){
	//		
	//		Customer cust1 = new Customer();
	//		cust1.setCustId(CUID.getInstance().nextId());
	//		cust1.setName("Customer ABC");
	//		cust1.setPan("AKUPB9629G");
	//		cust1.setPhone("+91 9878987878787");
	//		cust1.getContacts().add(new CustomerContact("Clark", "Clark@kony.com", "+19898998"));
	//		cust1.getContacts().add(new CustomerContact("Cheryl", "Cheryl@kony.com", "29784735"));
	//		
	//		List<Customer> list = new ArrayList<>();
	//		list.add(cust1);
	//		
	//		return list;
	//		
	//	}


	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Customer> getCustomerList(){

		Session session = HibernateUtil.getAppSessionFactory()
				.openSession();


		List<Customer> list = session.createCriteria(Customer.class).list();

		session.close();

		return list;

	}
}
