package com.niit.crudppbackend1.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.crudappbackend1.model.Person;


@Repository("Persondaompl")
@Transactional
@EnableTransactionManagement
public class PersondaoImpl implements Persondao {

	
	@Autowired
	SessionFactory sessionFactory;
	
	
	public void addPerson(Person p) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(p);
		
	}


	public void upatePerson(Person p) {
		Session session=sessionFactory.getCurrentSession();
		session.update(p);
		
		
	}

	
	public List<Person> listpersons() {
		Session session=sessionFactory.getCurrentSession();
		List<Person> persons=session.createQuery("from Person").getResultList();
		return persons;
		
	}


	public Person getpersonById(int id) {
		Session session=sessionFactory.getCurrentSession();
		Person persons=(Person)session.createQuery("from Person where id="+id).getResultList();
		return persons;
	}


	public void removePerson(int id) {
		
		
	}

}
