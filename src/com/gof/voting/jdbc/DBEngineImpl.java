/**
 * 
 */
package com.gof.voting.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gof.voting.dbexception.DataAccessConnectionFailureException;
import com.gof.voting.dbexception.DataAccessException;
import com.gof.voting.dbexception.DataAccessOperationErrorException;
import com.gof.voting.dbutils.DBUtils;

/**
 * @author suraj singh
 *
 */
public class DBEngineImpl implements DBEngine {

	private final PreparedStatementParameterSetter preparedStatementParameterSetter = new DefaultPreparedStatementParameterSetter();

	private Connection connection = null;

	public DBEngineImpl(final Connection connection) {
		this.connection = connection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gof.voting.jdbc.DBEngine#select(java.lang.String,
	 * com.gof.voting.jdbc.RowMapper, java.lang.Object[])
	 */
	@Override
	public <T> List<T> select(final String sql, final RowMapper<T> rowMapper,
			final Object... parameters) throws DataAccessException {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		final List<T> result = new ArrayList<T>();
		try {
			statement = connection.prepareStatement(sql);
			preparedStatementParameterSetter.setParameters(statement,
					parameters);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				result.add(rowMapper.map(resultSet));
			}
		} catch (final SQLException e) {
			throw new DataAccessOperationErrorException(e);
		} finally {
			DBUtils.closeQuietly(connection, statement, resultSet);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gof.voting.jdbc.DBEngine#save(java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public boolean save(final String sql, final Object... parameters)
			throws DataAccessException {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		boolean isSave = false;
		try {
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			preparedStatementParameterSetter.setParameters(statement,
					parameters);
			final int result = statement.executeUpdate();
			if (0 != result) {
				isSave = true;
			}
			if (0 == result) {
				throw new DataAccessOperationErrorException("insertion failed");
			}
			connection.commit();
			return isSave;
		} catch (final DataAccessException e) {
			DBUtils.rollback(connection);
			throw e;
		} catch (final Exception e) {
			DBUtils.rollback(connection);
			throw new DataAccessOperationErrorException(e);
		} finally {
			DBUtils.closeQuietly(connection, statement, resultSet);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gof.voting.jdbc.DBEngine#update(java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public boolean update(final String sql, final Object... parameters)
			throws DataAccessException {
		PreparedStatement statement = null;
		final ResultSet resultSet = null;
		boolean isUpdate = false;
		try {
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			preparedStatementParameterSetter.setParameters(statement,
					parameters);
			final int result = statement.executeUpdate();
			if (0 != result) {
				isUpdate = true;
			}
			if (0 == result) {
				throw new DataAccessOperationErrorException("updation failed");
			}
			connection.commit();
			return isUpdate;
		} catch (final DataAccessException e) {
			DBUtils.rollback(connection);
			throw e;
		} catch (final Exception e) {
			DBUtils.rollback(connection);
			throw new DataAccessOperationErrorException(e);
		} finally {
			DBUtils.closeQuietly(connection, statement, resultSet);
		}
	}

}
