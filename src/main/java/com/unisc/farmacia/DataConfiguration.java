package com.unisc.farmacia;

import javax.sql.DataSource;

import org.hibernate.Hibernate;
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
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/dbfarmacia");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adptr = new HibernateJpaVendorAdapter();
		adptr.setDatabase(Database.MYSQL);
		adptr.setShowSql(true);
		adptr.setGenerateDdl(false);
		adptr.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		adptr.setPrepareConnection(true);
		return adptr;
	}
	
	
	
}
