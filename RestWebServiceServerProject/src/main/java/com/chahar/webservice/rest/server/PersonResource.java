package com.chahar.webservice.rest.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.chahar.webservice.rest.server.response.Message;
import com.chahar.webservice.rest.server.response.Person;

@Path("/person")
public class PersonResource {
	
	private final Logger LOG = LogManager.getLogger(PersonResource.class);
	
	@Path("/get/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})  //add MediaType.APPLICATION_XML if you want XML as response (don't forget @XmlRootElement)
    public Person getPerson(@PathParam("id") String id){
        double  randomNumber = Math.random();
        
        Person person = new Person();
        person.setFirstName("Nabi: "+ randomNumber);
        person.setLastName("Zamani: "+ randomNumber);
        person.setAge(10);
        person.setCitizenships( new String[]{"German", "Persian"} );      
        
        Map<String, Object> creditCards = new HashMap<String, Object>();
        creditCards.put("MasterCard", "1234 1234 1234 1234");
        creditCards.put("Visa", "1234 1234 1234 1234");
        creditCards.put("dummy", true);
        person.setCreditCards(creditCards);
        
        LOG.info(" /person/get/{} {} , time: {}" ,id, person,new Date());
        
        return person;
    }
	
	@Path("/post")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	//@Consumes("application/x-www-form-urlencoded")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Message> postPerson(Person person , @Context UriInfo uri) {
		
		List<Message> result = new ArrayList<>();
		for(int i=0;i<5;i++) {
			String randomNumber = " -"+ Math.random();
			Message message = new Message();
			message.setFirstName(person.getFirstName()+randomNumber);
			message.setLastName(person.getLastName()+randomNumber);
			message.setText("Random text: "+ new Date() + " - "+randomNumber);
			message.setDate(new Date() );
			
			result.add(message);
		}
		
		LOG.info("/person/post , person: {} , message: {} ",person , result);
		LOG.info("@Context Uri: {} " , uri); 
		
		return result;
	}
	
	@Path("/post1")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML})
	public List<Message> postPerson1(Person person) {
		
		List<Message> result = new ArrayList<>();
		for(int i=0;i<5;i++) {
			String randomNumber = " -"+ Math.random();
			Message message = new Message();
			message.setFirstName(person.getFirstName()+randomNumber);
			message.setLastName(person.getLastName()+randomNumber);
			message.setText("Random text: "+ new Date() + " - "+randomNumber);
			message.setDate(new Date() );
			
			result.add(message);
		}
		
		LOG.info("/person/post1 , person: {} , message: {} ",person , result);
		
		return result;
	}
}
