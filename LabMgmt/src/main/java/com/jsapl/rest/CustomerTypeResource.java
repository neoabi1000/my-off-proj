package com.jsapl.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Query;
import org.hibernate.Session;

import com.jsapl.model.CustomerType;
import com.jsapl.persistence.HibernateUtil;

@Path("customerTypes")
public class CustomerTypeResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CustomerType> getAllCustomerTypes(){
		Session session = HibernateUtil.getAppSessionFactory().openSession();
		Query query = session.createQuery("from CustomerType");
		List<CustomerType> list = query.list();
		session.close();
		return list;
	}
	
}
