package com.jsapl.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.hibernate.Query;
import org.hibernate.Session;

import com.jsapl.model.Customer;
import com.jsapl.model.TestType;
import com.jsapl.persistence.HibernateUtil;

@Path("testtypes")
public class TestTypeResource {

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<TestType> getAllTestTypes(){


		Session session = HibernateUtil.getAppSessionFactory()
				.openSession();


		Query query = session.createQuery("select tt from TestType tt left join fetch tt.category");						

		List<TestType> list = query.list();

		session.close();

		return list;

	}

	@GET @Path("{testtypeid}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response getTestType(@PathParam("testtypeid") long testtypeid){

		Session session = HibernateUtil.getAppSessionFactory()
				.openSession();


		Query query = session.createQuery("select tt from TestType tt left join fetch tt.category where tt.testTypeId=:ptestTypeId");
		query.setParameter("ptestTypeId", testtypeid);


		TestType testType = (TestType) query.uniqueResult();

		session.close();

		//404 Not Found
		if(testType==null ){
			return Response.status(Status.NOT_FOUND).build();
		}


		//200 OK
		return Response.ok().entity(new GenericEntity<TestType>(testType){}).build();
	}

}

