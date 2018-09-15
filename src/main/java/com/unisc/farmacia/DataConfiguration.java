package com.unisc.farmacia;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataConfiguration {

	@Bean
	public DataSource datasource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/desenvolvimento");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres");
		return dataSource;
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adptr = new HibernateJpaVendorAdapter();
		adptr.setDatabase(Database.POSTGRESQL);
		adptr.setShowSql(true);
		adptr.setGenerateDdl(false);
		adptr.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
		adptr.setPrepareConnection(true);
		return adptr;
	}
	
	
	
}
