package com.jsapl.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;


@ApplicationPath("rest")
public class JerseyConfig extends ResourceConfig
{
	public JerseyConfig()
	{
		packages("com.jsapl.rest");
	}
}
