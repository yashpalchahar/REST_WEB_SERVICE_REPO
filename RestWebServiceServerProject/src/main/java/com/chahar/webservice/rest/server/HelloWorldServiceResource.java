package com.chahar.webservice.rest.server;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Path("/helloworld")
public class HelloWorldServiceResource {
	
	private final Logger LOG = LogManager.getLogger(HelloWorldServiceResource.class);
	
	@GET
	@Path("/request/text/{name1}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response sayTextHello(@PathParam("name1") final String name) {
		LOG.info("hit url: /helloworld/request/text/{} " ,name );
		
		String output = "Welcome " + name + " from Jersey - " + new Date();
		
		return Response.status(200).entity(output).build();
	}
	
	@GET
	@Path("/request/html/{name1}")
	@Produces(MediaType.TEXT_HTML)
	//@Produces(MediaType.TEXT_PLAIN)
	public String sayHTMLHello(@PathParam("name1") final String name) {
		LOG.info("hit url: /helloworld/request/html/{} " ,name );
		
		String result = "<html> " + "<title>" + "Jersey RestWebService " + "</title>"  + "<body><h1><div style='font-size: larger;'>"
				+ "Hello <span style='text-transform: capitalize; color: green;'>" + name +  "</span> - "+ new Date() +"</div></h1></body>" + "</html>";
		
		/* NOTE:
		 * IF @Produces =   text/plain and return type of String which contains complete html code.
		 * then browser will treat html code as string.
		 * 
		 * Content-Type: text/plain in response header will be set based on @Produces.
		 * 
		 * 
		 *  IF Return type is html , then use @Produces=text/html , then web browser will treat html code as html code.
		 *  will render html code properly.
		 * **/
		
		return result;
	}
	
	@GET
	@Path("/request/xml/{name1}")
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello(@PathParam("name1") final String name) {
		LOG.info("hit url: /helloworld/request/xml/{} " ,name );
		
		
		return "<?xml version=\"1.0\"?>" + "<hello> Hello World RESTful Jersey: "+ name + " - " + new Date() 
				+ "</hello>";
	}
	
	/* http://localhost:8080/ws_rest_server/rest/helloworld/request/post_queryparam_xml?name1=yashchahar3
	 * test from advance rest client plugin from chrome browser
	*/
	@POST
	@Path("/request/post_queryparam_xml")
	@Produces(MediaType.TEXT_XML)
	public String testingPostQueryParam(@QueryParam("name1") final String name) {
		LOG.info("hit url: /helloworld/post_queryparam_xml/{} " ,name );
		
		
		return "<?xml version=\"1.0\"?>" + "<hello> post_queryparam_xml -- Hello World RESTful Jersey: "+ name + " - " + new Date() 
				+ "</hello>";
	}
	
}
