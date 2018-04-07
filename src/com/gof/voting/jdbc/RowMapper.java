/**
 * 
 */
package com.gof.voting.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author suraj singh
 *
 */
public interface RowMapper<T> {
	
	T map(ResultSet resultSet) throws SQLException;
}
