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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
                        entityManagerFactoryRef = "db2EntityManagerFactory",
                        transactionManagerRef = "db2TransactionManager",
                        basePackages = "com.san.repository2"
                        )
public class Db2Config {

	// Datasource bean
	@Bean("db2Datasource")
	@ConfigurationProperties(prefix = "db2.datasource")
	public DataSource db2Datasource() {
		return DataSourceBuilder.create().build();
	}

	// EntityManagerFactory
	@Bean("db2EntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean db2EntityManagerFactory(EntityManagerFactoryBuilder emfb,@Qualifier("db2Datasource") DataSource dataSource) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("hibernate.hbm2ddl.auto", "update");
		map.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		return emfb.dataSource(db2Datasource()).properties(map).packages("com.san.entity2").persistenceUnit("Customer").build();
	}

	// TransactionManger
	@Bean("db2TransactionManager")
	public PlatformTransactionManager db2TransactionManager(@Qualifier("db2EntityManagerFactory") EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}

}
