package com.chahar.webservice.rest.client.beans;

import java.util.Arrays;
import java.util.Map;

public class Person {
	private String firstName , lastName;
	private Integer age;
	private String[] citizenships;
	private Map<String, Object> creditCards;
	
	
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", citizenships="
				+ Arrays.toString(citizenships) + ", creditCards=" + creditCards + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public Person(String firstName, String lastName, Integer age, String[] citizenships,
			Map<String, Object> creditCards) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.citizenships = citizenships;
	}
	public Person() {}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String[] getCitizenships() {
		return citizenships;
	}
	public void setCitizenships(String[] citizenships) {
		this.citizenships = citizenships;
	}
	public Map<String, Object> getCreditCards() {
		return creditCards;
	}
	public void setCreditCards(Map<String, Object> creditCards) {
		this.creditCards = creditCards;
	}
}
