package com.test.project.confg;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.test.project.dao.ExtraDAO;
import com.test.project.dao.ExtraDAOImpl;
import com.test.project.dao.RegistrationDAO;
import com.test.project.dao.RegistrationDAOImpl;
import com.test.project.model.Registration;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.test.project")
public class AppConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public DriverManagerDataSource dataSource() {		
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName("com.mysql.jdbc.Driver");
		dmds.setUrl("jdbc:mysql://localhost:3306/sai");
		dmds.setUsername("sai");
		dmds.setPassword("Abc123$%");
		
		return dmds;
	}

	@Bean(name = "regDAO")
	public RegistrationDAO registrationDAO() {
		RegistrationDAOImpl regDAO = new RegistrationDAOImpl();
		regDAO.setDataSource(dataSource());
		return regDAO;
	}

	@Bean(name = "extraDAO")
	public ExtraDAO extraDAO() {
		ExtraDAOImpl extraDAO = new ExtraDAOImpl();
		extraDAO.setDataSource(dataSource());
		return extraDAO;
	}
	
	public Properties getHibernateProperties(){
		Properties p = new Properties();
		p.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");		
		return p;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();		
		localSessionFactoryBean.setDataSource(dataSource());			
		localSessionFactoryBean.setHibernateProperties(getHibernateProperties());		
		localSessionFactoryBean.setAnnotatedClasses(Registration.class);		
		
		return localSessionFactoryBean;
	}
	
	
	
	@Bean
	@Autowired
	public HibernateTransactionManager txManager(SessionFactory sessionFactory){
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory);
		return hibernateTransactionManager;
	}
	
}
