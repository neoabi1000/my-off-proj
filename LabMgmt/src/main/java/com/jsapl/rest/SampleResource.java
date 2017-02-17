package com.jsapl.rest;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.hibernate.Session;

import com.jsapl.model.Customer;
import com.jsapl.model.Sample;
import com.jsapl.persistence.HibernateUtil;
import com.jsapl.rest.dto.SampleDTO;
import com.jsapl.util.CUID;

@Path("samples")
public class SampleResource {
	
	@POST
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response createSample(@Context UriInfo uriInfo, SampleDTO sampleDTO) throws Exception{

		

		Session session = HibernateUtil.getAppSessionFactory()
				.openSession();

		Customer customer = (Customer)session.get(Customer.class, sampleDTO.getCustId());
		if(customer==null){
			session.close();
			return Response.status(Response.Status.NOT_FOUND).entity("Customer not found").build();
		}

		Sample sample = new Sample();
		sample.setSampleId(CUID.getInstance().nextId());
		sample.setCustomer(customer);
		sample.setForm(sampleDTO.getForm());
		sample.setReceivedDate(sampleDTO.getReceivedDate());
		sample.setSize(sampleDTO.getSize());
		sample.setStamping(sampleDTO.getStamping());
		sample.setStatus(sampleDTO.getStatus());
		sample.setToBeReturned(sampleDTO.isToBeReturned());
		
		session.beginTransaction();

		session.save(sample);

		session.getTransaction().commit();
		session.close();

		return Response.created(new URI(uriInfo.getRequestUri()+"/"+sample.getSampleId())).build();
	}

}
