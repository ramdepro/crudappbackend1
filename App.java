package com.niit.crudappbackend1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.niit.crudappbackend1.model.Person;
import com.niit.crudappbackend11.config.AppContext;
import com.niit.crudppbackend1.dao.Persondao;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args )
    {
    	AbstractApplicationContext context=new AnnotationConfigApplicationContext(AppContext.class);
    	
    	Persondao persondao=(Persondao)context.getBean("persondao");
    	
    	Person person=new Person();
    	person.setName("Raam");
    	person.setCounry("India");
    	
       
    }
}
