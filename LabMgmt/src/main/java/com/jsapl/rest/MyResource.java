package com.jsapl.rest;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@Path("resource")
public class MyResource 
{
	@GET
	@Produces("text/plain")
	public String getHello(){
		return "Hello World!";
	}
}

