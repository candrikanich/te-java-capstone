package com.techelevator.model.JDBC;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Unit;
import com.techelevator.model.DAO.UnitDAO;

@Component
public class JDBCUnitDAO implements UnitDAO{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCUnitDAO(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Override
	public List<Unit> getAllUnits() {
		String sqlSelectAllUnits = "SELECT * "+
				  	 "FROM unit";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllUnits);
		List<Unit> allUnits = new ArrayList<>();
		allUnits = mapRowSetToUnit(results);
		return allUnits;
	}
	
	private List<Unit> mapRowSetToUnit(SqlRowSet results) {
		ArrayList<Unit> unitList = new ArrayList<>();
		while(results.next()) {
			Unit u = new Unit();
			u.setUnitId(results.getInt("unit_id"));
			u.setUnitName(results.getString("unit_name"));
			unitList.add(u);
		}
		return unitList;
	}

}
