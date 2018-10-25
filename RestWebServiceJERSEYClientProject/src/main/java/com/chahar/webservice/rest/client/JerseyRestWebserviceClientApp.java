package com.chahar.webservice.rest.client;

import java.io.IOException;

import com.chahar.webservice.rest.client.beans.Person;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyRestWebserviceClientApp 
{
    public static void main( String[] args ) throws JsonParseException, JsonMappingException, IOException
    {
    	program2_POST();
    }
    
    public static void program1_GET() throws JsonParseException, JsonMappingException, IOException {
    	Client client = Client.create();
    	WebResource webResource = client.resource("http://localhost:8080/ws_rest_server/rest/person/get/567890");
    	ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
    	
    	if (response.getStatus() != 200) {
 		   throw new RuntimeException("Failed : HTTP error code : "
 			+ response.getStatus());
 		}

 		String output = response.getEntity(String.class);

 		System.out.println("program1_GET: Output from Server .... \n" + output);
 		
 		/*NOTE: 
 		 * JACKSON json mapper, which maps json string to java object
 		 * */
 		
 		ObjectMapper mapper = new ObjectMapper();
 		Person person = mapper.readValue(output, Person.class);
 		System.out.println(person);
    }
    
    public static void program2_POST() {
    	Client client = Client.create();

		WebResource webResource = client.resource("http://localhost:8080/ws_rest_server/rest/person/post1");

		String input = "{\"firstName\":\"yashpal1\",\"lastName\":\"chahar2\"}";
		
		//webResource.type = @Consumes - it is created json data for sending  
		//webResource.type = @Produces - it is expected application/xml for receiving
		ClientResponse response = webResource.type("application/json").accept("application/xml").post(ClientResponse.class, input);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
		}
		String output = response.getEntity(String.class);
		System.out.println("program2_POST: Output from Server .... \n"+ output);
		
    }
}
