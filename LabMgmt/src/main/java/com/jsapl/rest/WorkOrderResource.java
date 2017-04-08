package com.jsapl.rest;

import java.net.URI;
import java.sql.Date;
import java.util.Calendar;
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
import com.jsapl.model.WorkOrderSample;
import com.jsapl.model.WorkOrderSampleTest;
import com.jsapl.persistence.HibernateUtil;
import com.jsapl.rest.dto.TestDTO;
import com.jsapl.rest.dto.WorkOrderDTO;
import com.jsapl.rest.dto.WorkOrderSampleDTO;
import com.jsapl.rest.dto.WorkOrderSampleTestDTO;
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
		workOrder.setDateCommited(workOrderDTO.getDateCommited());
		workOrder.setStatus(WorkOrder.Status.valueOf(workOrderDTO.getStatus()));
		workOrder.setTotalCost(0);
		customer.setCreatedBy("santosh");
		customer.setCreatedOn(new Date(Calendar.getInstance().getTimeInMillis()));
		customer.setLastUpdatedBy("santosh");
		customer.setLastUpdatedOn(new Date(Calendar.getInstance().getTimeInMillis()));



		session.beginTransaction();

		session.save(workOrder);

		session.getTransaction().commit();
		session.close();

		return Response.created(new URI(uriInfo.getRequestUri()+"/"+workOrder.getId())).build();
	}


	//	@POST @Path("{workOrderId}/tests")
	//	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	//	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	//	public Response createTestsUnderWorkOrder(@PathParam("workOrderId") long workOrderId, TestDTO[] testDTOs){
	//
	//
	//		boolean areAllSamplesFromSameCustomer = isCustomerUnique(testDTOs);
	//		if(!areAllSamplesFromSameCustomer){
	//			return Response.status(Response.Status.CONFLICT).entity("Not all the samples are from the same customer").build();
	//		}
	//
	//		Session session = HibernateUtil.getAppSessionFactory()
	//				.openSession();
	//
	//
	//		session.beginTransaction();
	//
	//		for(TestDTO testDTO:testDTOs){
	//			Test test = new Test();
	//			test.setTestId(new TestId(workOrderId, testDTO.getSampleId(), testDTO.getTestTypeId()));
	//			test.setRequiredSpecification(testDTO.getRequiredSpecification());
	//			test.setTestStatus(Test.Status.valueOf(testDTO.getTestStatus()));
	//			test.setCreated(testDTO.getCreated());
	//			session.save(test);
	//		}
	//
	//
	//		session.getTransaction().commit();
	//		session.close();
	//
	//		return Response.ok().build();
	//	}


	@POST @Path("{workOrderId}/lineItems")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response createTestsUnderWorkOrder(@PathParam("workOrderId") long workOrderId, WorkOrderSampleDTO[] workOrderSampleDTOs){


		boolean areAllSamplesFromSameCustomer = isCustomerUnique(workOrderSampleDTOs);
		if(!areAllSamplesFromSameCustomer){
			return Response.status(Response.Status.CONFLICT).entity("Not all the samples are from the same customer").build();
		}
		
		System.out.println("workOrderId: "+workOrderId);

		Session session = HibernateUtil.getAppSessionFactory()
				.openSession();


		session.beginTransaction();

		for(WorkOrderSampleDTO workOrderSampleDTO:workOrderSampleDTOs){
			WorkOrderSample workOrderSample = new WorkOrderSample();
			workOrderSample.setId(CUID.getInstance().nextId());
			workOrderSample.setWorkOrderId(workOrderId);
			workOrderSample.setSampleId(workOrderSampleDTO.getSampleId());
			session.save(workOrderSample);
			
			List<WorkOrderSampleTestDTO> tests = workOrderSampleDTO.getTests();
			for(WorkOrderSampleTestDTO test: tests){
				WorkOrderSampleTest workOrderSampleTest = new WorkOrderSampleTest();
				workOrderSampleTest.setWorkOrderSampleId(workOrderSample.getId());
				workOrderSampleTest.setTestTypeId(test.getTestTypeId());
				workOrderSampleTest.setRequiredSpecification(test.getRequiredSpecification());
				workOrderSampleTest.setComments(test.getComments());
				session.save(workOrderSampleTest);
			}
			
		}
		session.getTransaction().commit();
		session.close();

		return Response.ok().build();
	}


	private boolean isCustomerUnique(WorkOrderSampleDTO[] workOrderSampleDTOs) 
	{
		StringBuffer sampleIds=new StringBuffer();
		for(WorkOrderSampleDTO workOrderSampleDTO:workOrderSampleDTOs){
			sampleIds.append(workOrderSampleDTO.getSampleId()+",");
		}
		sampleIds.deleteCharAt(sampleIds.length()-1);
		System.out.println("$$$$$$$$$  sampleIds: "+sampleIds);

		Session session = HibernateUtil.getAppSessionFactory()
				.openSession();
		List<Long> custIds = session.createQuery("select s.customer.id from Sample s where s.sampleId in ("+sampleIds+")").list();

		System.out.println(custIds);	
		return (new HashSet<Long>(custIds).size()>1)?false:true;
	}



}
