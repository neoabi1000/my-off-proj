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

import com.jsapl.model.TestType;
import com.jsapl.persistence.HibernateUtil;

@Path("testcategories")
public class TestCategoryResource {

	//	@GET
	//	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	//	public List<TestCategory> getAllTestCategories(){
	//		
	//	}
	//	
	//	@GET @Path("{testCategoryId}")
	//	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	//	public Response getTestCategory(@PathParam("testCategoryId") long testCategoryId)){
	//		
	//	}

	@GET @Path("{testCategoryId}/testtypes")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response getAllTestTypesForGiveTestCategory(@PathParam("testCategoryId") int testCategoryId){

		Session session = HibernateUtil.getAppSessionFactory()
				.openSession();


		Query query = session.createQuery("select tt from TestType tt left join fetch tt.category where tt.category.id=:ptestCategoryId");	
		query.setParameter("ptestCategoryId", testCategoryId);
		List<TestType> list = query.list();

		session.close();

		//404 Not Found
		if(list==null || list.size()<=0){
			return Response.status(Status.NOT_FOUND).build();
		}


		//200 OK
		return Response.ok().entity(new GenericEntity<List<TestType>>(list){}).build();
	}

}


