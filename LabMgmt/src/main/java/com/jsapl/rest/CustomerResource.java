package com.jsapl.rest;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.jsapl.model.Customer;
import com.jsapl.model.CustomerType;
import com.jsapl.model.Sample;
import com.jsapl.model.WorkOrder;
import com.jsapl.persistence.CustomerDao;
import com.jsapl.persistence.HibernateUtil;
import com.jsapl.rest.dto.CustomerDTO;
import com.jsapl.rest.dto.SampleDTO;
import com.jsapl.rest.dto.WorkOrderDTO;
import com.jsapl.util.CUID;

@Path("customers")
public class CustomerResource {
	
	CustomerDao customerDao = new CustomerDao();

	@GET
	@Produces(MediaType.APPLICATION_JSON) @Consumes(MediaType.APPLICATION_JSON)
	public List<CustomerDTO> getCustomerList(
				@QueryParam("pageStart") String pageStart, 
				@QueryParam("pageSize" ) String pageSize){

		return CustomerDTO.covertList(customerDao.getCustomers(pageStart, pageSize));
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

		Customer customer = (Customer)session.get(Customer.class, custid);

		session.close();

		return customer;

	}


	@DELETE @Path("{custid:\\d+}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response deleteCustomerById(@PathParam("custid") Long custid){

		Session session = HibernateUtil
				.getAppSessionFactory()
				.openSession();
		try{
			session.beginTransaction();

			Customer customer = (Customer)session.get(Customer.class, custid);
			session.delete(customer);
			session.getTransaction().commit();
			session.close();

		}catch(ObjectNotFoundException e){
			return Response.status(Response.Status.NOT_FOUND).entity("Customer not found").build();
		}
		

		return Response.ok().build();

	}




	@GET @Path("{custid:\\d+}/samples")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response getSamplesByCustId(
			@PathParam("custid") Long custid,
			@QueryParam("pageStart") String pageStart,
			@QueryParam("pageSize" ) String pageSize){

		List<Sample> list = null;
		List<SampleDTO> retList = null;
		Session session = HibernateUtil.getAppSessionFactory().openSession();

		Customer customer = (Customer)session.get(Customer.class, custid);

		if(customer!=null){
			System.out.println(customer.getCustId());
			Query query = session.createQuery("select s from Sample s where s.customer.custId=:pcustid");
			query.setParameter("pcustid", custid);
			if(pageStart !=null){
				query = query.setFirstResult(Integer.valueOf(pageStart));
			}
			if(pageSize != null){
				query = query.setMaxResults(Integer.valueOf(pageSize));
			}
			list = query.list();
		}

		session.close();

		if(customer==null)
			return Response.status(Response.Status.NOT_FOUND).entity("Can't find the customer with given identity").build();

		if(list==null || list.size()==0)
			return Response.status(Response.Status.NOT_FOUND).entity("There are no samples for this customer").build();

		retList = new ArrayList<>();

		for(Sample sample: list){
			retList.add(new SampleDTO(sample));
		}

		return Response.ok().entity(new GenericEntity<List<SampleDTO>>(retList){}).build();

	}


	@GET @Path("{custid:\\d+}/workorders")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response getWorkOrdersByCustId(
			@PathParam("custid") Long custid,
			@QueryParam("pageStart") String pageStart,
			@QueryParam("pageSize" ) String pageSize){

		List<WorkOrder> list = null;
		List<WorkOrderDTO> retList = null;
		Session session = HibernateUtil.getAppSessionFactory().openSession();

		Customer customer = (Customer)session.get(Customer.class, custid);

		if(customer!=null){
			System.out.println(customer.getCustId());
			Query query = session.createQuery("select wo from WorkOrder wo where wo.customer.custId=:pcustid");
			query.setParameter("pcustid", custid);
			if(pageStart !=null){
				query = query.setFirstResult(Integer.valueOf(pageStart));
			}
			if(pageSize != null){
				query = query.setMaxResults(Integer.valueOf(pageSize));
			}
			list = query.list();
		}

		session.close();

		if(customer==null)
			return Response.status(Response.Status.NOT_FOUND).entity("Can't find the customer with given identity").build();

		if(list==null || list.size()==0)
			return Response.status(Response.Status.NOT_FOUND).entity("There are no work orders for this customer").build();

		retList = new ArrayList<>();

		for(WorkOrder workOrder: list){
			retList.add(new WorkOrderDTO(workOrder));
		}

		return Response.ok().entity(new GenericEntity<List<WorkOrderDTO>>(retList){}).build();

	}

}
