package com.jsapl.persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.jsapl.model.Sample;
import com.jsapl.model.SampleTestItem;
import com.jsapl.rest.dto.SampleDTO;

public class SampleDao {

	public List<Sample> getSamples(String pageStart, String pageSize)
	{
		Session session = HibernateUtil.getAppSessionFactory().openSession();

		Query query = session.createQuery("from Sample");
		if(pageStart !=null){
			query = query.setFirstResult(Integer.valueOf(pageStart));
		}
		if(pageSize != null){
			query = query.setMaxResults(Integer.valueOf(pageSize));
		}

		List<Sample> list = query.list();
		session.close();
		
		return list;
	}
	
	
	public List<SampleDTO> getSampleDTO(String pageStart, String pageSize)
	{
		Session session = HibernateUtil.getAppSessionFactory().openSession();

		Query query = session.createQuery("from Sample");
		if(pageStart !=null){
			query = query.setFirstResult(Integer.valueOf(pageStart));
		}
		if(pageSize != null){
			query = query.setMaxResults(Integer.valueOf(pageSize));
		}

		List<Sample> list = query.list();
		
		//TODO - This has to improve using some hibernate trick such that I can close session early .
		//I have done this such that I can load the customer namesfor the UI grid.
		List<SampleDTO> retList = SampleDTO.covertList(list);
		
		
		session.close();
		
		return retList;
	}


}
