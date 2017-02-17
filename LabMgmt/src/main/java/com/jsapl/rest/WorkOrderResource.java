package com.jsapl.rest;

import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.hibernate.Session;

import com.jsapl.model.Customer;
import com.jsapl.model.Test;
import com.jsapl.model.TestId;
import com.jsapl.model.WorkOrder;
import com.jsapl.persistence.HibernateUtil;
import com.jsapl.rest.dto.TestDTO;
import com.jsapl.rest.dto.WorkOrderDTO;
import com.jsapl.util.CUID;

@Path("workorders")
public class WorkOrderResource {


	@GET @Path("{workOrderId}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response getWorkOrderById(@PathParam("workOrderId") long workOrderId){

		Session session = HibernateUtil.getAppSessionFactory().openSession();


		WorkOrder workOrder = (WorkOrder)session.get(WorkOrder.class,  new Long(workOrderId));
		if(workOrder==null){
			session.close();
			return Response.status(Response.Status.NOT_FOUND).entity("WorkOrder not found").build();
		}

		session.close();

		return Response.ok(workOrder).build();
	}


	@POST
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response createWorkOrder(@Context UriInfo uriInfo, WorkOrderDTO workOrderDTO) throws Exception{

		Session session = HibernateUtil.getAppSessionFactory()
				.openSession();

		Customer customer = (Customer)session.get(Customer.class, workOrderDTO.getCustId());
		if(customer==null){
			session.close();
			return Response.status(Response.Status.NOT_FOUND).entity("Customer not found").build();
		}

		WorkOrder workOrder = new WorkOrder();
		workOrder.setId(CUID.getInstance().nextId());
		workOrder.setCustomer(customer);
		workOrder.setDescription(workOrderDTO.getDescription());
		workOrder.setAdvancePaid(workOrderDTO.getAdvancePaid());
		workOrder.setClientInfo(workOrderDTO.getClientInfo());
		workOrder.setCreated(workOrderDTO.getCreated());
		workOrder.setDateCommited(workOrderDTO.getDateCommited());
		workOrder.setStatus(WorkOrder.Status.valueOf(workOrderDTO.getStatus()));
		workOrder.setTotalCost(0);



		session.beginTransaction();

		session.save(workOrder);

		session.getTransaction().commit();
		session.close();

		return Response.created(new URI(uriInfo.getRequestUri()+"/"+workOrder.getId())).build();
	}


	@POST @Path("{workOrderId}/tests")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response createTestsUnderWorkOrder(@PathParam("workOrderId") long workOrderId, TestDTO[] testDTOs){


		boolean areAllSamplesFromSameCustomer = isCustomerUnique(testDTOs);
		if(!areAllSamplesFromSameCustomer){
			return Response.status(Response.Status.CONFLICT).entity("Not all the samples are from the same customer").build();
		}

		Session session = HibernateUtil.getAppSessionFactory()
				.openSession();


		session.beginTransaction();

		for(TestDTO testDTO:testDTOs){
			Test test = new Test();
			test.setTestId(new TestId(workOrderId, testDTO.getSampleId(), testDTO.getTestTypeId()));
			test.setRequiredSpecification(testDTO.getRequiredSpecification());
			test.setTestStatus(Test.Status.valueOf(testDTO.getTestStatus()));
			test.setCreated(testDTO.getCreated());
			session.save(test);
		}


		session.getTransaction().commit();
		session.close();

		return Response.ok().build();
	}


	private boolean isCustomerUnique(TestDTO[] testDTOs) 
	{
		StringBuffer sampleIds=new StringBuffer();
		for(TestDTO testDTO:testDTOs){
			sampleIds.append(testDTO.getSampleId()+",");
		}
		sampleIds.deleteCharAt(sampleIds.length()-1);
		System.out.println("$$$$$$$$$  sampleIds: "+sampleIds);

		Session session = HibernateUtil.getAppSessionFactory()
				.openSession();
		List<Long> custIds = session.createQuery("select s.customer.id from Sample s where s.sampleid in ("+sampleIds+")").list();
		
		System.out.println(custIds);	
		return (new HashSet<Long>(custIds).size()>1)?false:true;
	}



}
