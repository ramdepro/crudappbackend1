package com.niit.crudappbackend11.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@ComponentScan(basePackages = "com.niit")
public class AppContext {

	public DataSource getH2DataSource() {

		BasicDataSource datasource = new BasicDataSource();
		datasource.setDriverClassName("org.h2.Driver");
		datasource.setUrl("jdbc:h2:~/test/cart");
		datasource.setUsername("sa");
		datasource.setPassword("");

		return datasource;
	}

	@Bean
	public LocalSessionFactoryBean getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

		sessionFactory.setDataSource(dataSource);
		sessionFactory.setHibernateProperties(getHibernateProperties());

		sessionFactory.setPackagesToScan(new String[] { "com.niit.crudappbackend1.model" });

		return sessionFactory;
	}

	public Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernte.dialect.H2Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hbernate.hbm2ddl.auto", "update");

		return properties;
	}

	@Autowired
	@Bean

	public HibernateTransactionManager getTransactionlManager(SessionFactory sessionFactory) {

		HibernateTransactionManager transactionalManager = new HibernateTransactionManager();
		transactionalManager.setSessionFactory(sessionFactory);

		return transactionalManager;

	}
}