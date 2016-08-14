package com.techelevator.model.JDBC;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Quantity;
import com.techelevator.model.DAO.QuantityDAO;
@Component
public class JDBCQuantityDAO implements QuantityDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCQuantityDAO(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Override
	public List<Quantity> getAllQuantities() {
		String sqlSelectAllQuantities = "SELECT * "+
			  	 					"FROM quantity";
	SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllQuantities);
	List<Quantity> allQuantities = new ArrayList<>();
	allQuantities = mapRowSetToQuantity(results);
	return allQuantities;
}

private List<Quantity> mapRowSetToQuantity(SqlRowSet results) {
	ArrayList<Quantity> quantityList = new ArrayList<>();
	while(results.next()) {
		Quantity q = new Quantity();
		q.setQuantityId(results.getInt("quantity_id"));
		q.setquantityName(results.getString("quantity_name"));
		quantityList.add(q);
	}
	return quantityList;
}

}
