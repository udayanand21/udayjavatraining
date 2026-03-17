package com.coforge.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.coforge.dao.EmployeeDaoInterface;
import com.coforge.dao.EmployeeDaoImpl;

@Configuration
@ComponentScan(basePackages = "com.coforge")
public class Appconfig {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dSource = new DriverManagerDataSource();
		// Use H2 in-memory database so the app runs without an external DB
		dSource.setDriverClassName("org.h2.Driver");
		dSource.setUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;MODE=MySQL");
		dSource.setUsername("sa");
		dSource.setPassword("");
		return dSource;
		
	}
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dSource)
	{
		JdbcTemplate jt = new JdbcTemplate(dSource);
		// initialize schema/table matching com.coforge.entities.Employee fields
		jt.execute("CREATE TABLE IF NOT EXISTS employee (eid BIGINT PRIMARY KEY, ename VARCHAR(100), salary DOUBLE);");
		return jt;
	}

	@Bean
	public EmployeeDaoInterface employeeDaoInterface(JdbcTemplate jdbcTemplate) {
		return new EmployeeDaoImpl(jdbcTemplate);
	}
}