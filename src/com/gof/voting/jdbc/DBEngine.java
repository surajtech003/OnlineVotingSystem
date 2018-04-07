/**
 * 
 */
package com.gof.voting.jdbc;

import java.util.List;

import com.gof.voting.dbexception.DataAccessException;

/**
 * @author suraj singh
 *
 */
public interface DBEngine {

	<T> List<T> select(final String query, final RowMapper<T> rowMapper,
			final Object... parameters) throws DataAccessException;

	boolean save(final String query, final Object... parameters)
			throws DataAccessException;

	boolean update(final String query, final Object... parameters)
			throws DataAccessException;
}
