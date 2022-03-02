package com.bugshop.config;

import java.util.Properties;


import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

@Configuration // config
@EnableJpaRepositories(basePackages = { "com.bugshop.repository" })
@EnableTransactionManagement // entity transaction
public class JPAConfig {

	// khoi tao entity manager factory
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPersistenceUnitName("persistence-data"); // persistence mapping entity in backage
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);

		// generate table by using java class
		em.setJpaProperties(additionalProperties());
		return em;
	}

	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/ejava");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}

	Properties additionalProperties() {
		Properties properties = new Properties();

		// generate database
		//properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		//properties.setProperty("hibernate.hbm2ddl.auto", "update");

		properties.setProperty("hibernate.hbm2ddl.auto", "none");
		properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
		return properties;
	}
	
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
	    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	    multipartResolver.setDefaultEncoding("UTF-8");
	    multipartResolver.setMaxUploadSize(100000);
	    return multipartResolver;
	}
	@Bean
	public Cloudinary cloudinary() {
		Cloudinary c = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "abcduy",
				"api_key", "777696373522314",
				"api_secret", "YgykCnezvAcBe6xJxh1RtBAWUsw",
				"secure", true));
		return c;
	}
}
