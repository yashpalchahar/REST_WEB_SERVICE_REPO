package com.chahar.webservice.rest.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.client.RestTemplate;

import com.chahar.webservice.rest.client.beans.Person;

public class RestTemplateApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring_rest_template_context.xml");
		
		RestTemplate restTemplate = (RestTemplate) context.getBean("restTemplate");
		
		Person person = restTemplate.getForObject("http://localhost:8080/ws_rest_server/rest/person/get/222222", Person.class);
		System.out.println(person);
	}

}
