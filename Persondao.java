package com.niit.crudppbackend1.dao;

import java.util.List;

import com.niit.crudappbackend1.model.Person;

public interface Persondao {
	
	public void addPerson(Person p);
	public void upatePerson(Person p);
	public List<Person>listpersons();
	public Person getpersonById(int id);
	public void removePerson(int id);
	
	

}
