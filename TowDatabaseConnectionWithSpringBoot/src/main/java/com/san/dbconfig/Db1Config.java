package com.san.dbconfig;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "db1EntityManagerFactory", transactionManagerRef = "db1TransactionManager", basePackages = "com.san.repository1")
public class Db1Config {

	// Datasource bean

	@Primary
	@ConfigurationProperties(prefix = "db1.datasource")
	@Bean(name = "db1Datasource")
	public DataSource db1Datasource() {
		return DataSourceBuilder.create().build();
	}

	// EntityManagerFactory
	@Primary
	@Bean(name = "db1EntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean db1EntityManagerFactory(EntityManagerFactoryBuilder emfb,
			@Qualifier("db1Datasource") DataSource db1Datasource) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("hibernate.hbm2ddl.auto", "update");
		map.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		return emfb.dataSource(db1Datasource()).properties(map).packages("com.san.entity1").persistenceUnit("Laptop")
				.build();
	}

	// TransactionManger
	@Primary
	@Bean(name = "db1TransactionManager")
	public PlatformTransactionManager db1TransactionManager(
			@Qualifier("db1EntityManagerFactory") EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}

}
