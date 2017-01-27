package com.jsapl.rest;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.hibernate.Query;
import org.hibernate.Session;

import com.jsapl.model.Customer;
import com.jsapl.model.CustomerType;
import com.jsapl.persistence.HibernateUtil;
import com.jsapl.rest.dto.CustomerDTO;
import com.jsapl.util.CUID;

@Path("customers")
public class CustomerResource {

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Customer> getCustomerList(
											@QueryParam("pageStart") String pageStart,
											@QueryParam("pageSize" ) String pageSize){

		Session session = HibernateUtil.getAppSessionFactory()
				.openSession();


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
	
	@POST
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response createCustomer(@Context UriInfo uriInfo, CustomerDTO customerDto) throws Exception{

		
		
		Customer customer = new Customer();
		customer.setCustId(CUID.getInstance().nextId());
		customer.setContacts(customerDto.getContacts());
		customer.setName(customerDto.getName());
		customer.setPan(customerDto.getPan());
		customer.setPhone(customerDto.getPhone());

		
		Session session = HibernateUtil.getAppSessionFactory()
				.openSession();
		
		CustomerType customerType = (CustomerType)session.load(CustomerType.class, customerDto.getCustomerType());
		if(customerType==null){
			return Response.status(Status.BAD_REQUEST).build();
		}
		
		customer.setCustomerType(customerType);
		
		session.beginTransaction();
		
		session.save(customer);
		
		session.getTransaction().commit();
		session.close();
		
		return Response.created(new URI(uriInfo.getRequestUri()+"/"+customer.getCustId())).build();
	}
	
	
	@GET @Path("{custid:\\d+}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Customer getCustomerById(@PathParam("custid") Long custid){

		Session session = HibernateUtil
								.getAppSessionFactory()
								.openSession();

		Customer customer = (Customer)session.load(Customer.class, custid);

		session.close();

		return customer;

	}
	
	
	
}
