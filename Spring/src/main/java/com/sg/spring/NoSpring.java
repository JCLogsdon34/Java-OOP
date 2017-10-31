
package com.sg.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.tree.RowMapper;


public class NoSpring {
     //spring example at the bottom
/*
    public Employee getEmployeeById(long id) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
        conn = dataSource.getConnection();
        stmt = conn.prepareStatement(
                "select id, firstname, lastname, salary from "
                + "employee where id=?"); //select employee
        stmt.setLong(1, id);
        rs = stmt.executeQuery();
        Employee employee = null;
        if (rs.next()) { //this will create an object from the data
            employee = new Employee();
            employee.setId(rs.getLong("id"));
            employee.setFirstName(rs.getString("firstname"));
            employee.setLastName(rs.getString("lastname"));
            employee.setSalary(rs.getBigDecimal("salary"));
        }
        return employee;
    } catch (SQLException e) { // what should be done here?

    } finally {
        if (rs != null) { //clean up mess
            try {
                rs.close();
                catch(SQLExeception e) {}
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }

        return null;
    }
    }
*/
    public Employee getEmployeeById(long id) {
    return jdbcTemplate.queryForObject (
	"select id, firstname, lastname, salary " + // SQL Query
	"from employee where id=?",
	new RowMapper<Employee>() {
            Public Employee mapRow(ResultSet rs, //Map results to object
                int rowNum) throws SQLException {
                    Employee employee = new Employee();
                    employee.setId(rs.getLong("id"));
                    employee.setFirstName(rs.getString("firstname"));
                    employee.setLastName(rs.getString("lastname"));
                    employee.setSalary(rs.getBigDecimal("salary"));
                    return employee;
                }
        },
	id); //specify query parameter
}
}
