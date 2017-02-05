package com.jsapl.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.fasterxml.jackson.jaxrs.xml.JacksonXMLProvider;


@ApplicationPath("rest")
public class JerseyConfig extends ResourceConfig
{
	public JerseyConfig()
	{
		
		
		JacksonJsonProvider jacksonJsonProvider = new JacksonJsonProvider();
		jacksonJsonProvider.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		jacksonJsonProvider.setMapper(new HibernateAwareObjectMapper());
		
		JacksonXMLProvider jacksonXMLProvider = new JacksonXMLProvider();
		
		
		packages("com.jsapl.rest");
		register(jacksonJsonProvider);
		register(jacksonXMLProvider);
	}
}
