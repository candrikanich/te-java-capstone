package com.techelevator.model.JDBC;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Recipe;
import com.techelevator.model.DAO.GroceryListDAO;

@Component
public class JDBCGroceryListDAO implements GroceryListDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired 
	public JDBCGroceryListDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
}
