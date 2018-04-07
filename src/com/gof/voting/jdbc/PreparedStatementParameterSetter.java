/**
 * 
 */
package com.gof.voting.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author suraj singh
 *
 */
public interface PreparedStatementParameterSetter {

	void setParameters(final PreparedStatement statement,
			final Object... parameters) throws SQLException;
}
