package com.gof.voting.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.gof.voting.dao.AbstractDao;
import com.gof.voting.dao.LoginDetailsDao;
import com.gof.voting.dbutils.SQLQueryConstants;
import com.gof.voting.jdbc.DBEngine;
import com.gof.voting.model.LoginDetails;
import com.gof.voting.jdbc.RowMapper;

/**
 * This LoginDaoImpl.java class is used to login to Databse.
 * 
 * @author suraj singh
 *
 */
public class LoginDetailsDaoImpl extends AbstractDao implements LoginDetailsDao {

	/**
	 * @param dbEngine
	 */
	public LoginDetailsDaoImpl(DBEngine dbEngine) {
		super(dbEngine);
		// TODO Auto-generated constructor stub
	}

	private static final RowMapper<LoginDetails> LOGINDETAILS_MAPPER = new RowMapper<LoginDetails>() {

		@Override
		public LoginDetails map(final ResultSet resultSet) throws SQLException {
			final LoginDetails loginDetails = new LoginDetails();
			loginDetails.setUserName(resultSet.getString("userName"));
			loginDetails.setFname(resultSet.getString("fname"));
			loginDetails.setLname(resultSet.getString("lname"));
			loginDetails.setPassword(resultSet.getString("password"));
			loginDetails.setRole(resultSet.getString("role"));
			loginDetails.setEmail(resultSet.getString("email"));
			return loginDetails;
		}
	};

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gof.voting.dao.LoginDao#getLoginDetailsByUserName(java.lang.String)
	 */
	@Override
	public LoginDetails getLoginDetailsByUserName(String userName) {
		List<LoginDetails> list = dbEngine().select(
				SQLQueryConstants.GET_LOGINdETAILS_BY_USERNAME,
				LOGINDETAILS_MAPPER, userName);
		return list.isEmpty() ? null : list.get(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gof.voting.dao.LoginDao#getAllLoginDetailsUser()
	 */
	@Override
	public List<LoginDetails> getAllLoginDetailsUser() {
		return dbEngine().select(SQLQueryConstants.GET_LOGIN_DETAILS_QUERY,
				LOGINDETAILS_MAPPER);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gof.voting.dao.LoginDetailsDao#registerLogger(com.gof.voting.model
	 * .LoginDetails)
	 */
	@Override
	public boolean registerLogger(LoginDetails loginDetails) {
		return dbEngine().save(SQLQueryConstants.INSERT_LOGIN_DETAILS_QUERY,
				loginDetails.getUserName(), loginDetails.getFname(),
				loginDetails.getLname(), loginDetails.getPassword(),
				loginDetails.getRole(), loginDetails.getEmail());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gof.voting.dao.LoginDetailsDao#updateResetPassword(java.sql.Connection
	 * , java.lang.String, java.lang.String)
	 */
	@Override
	public boolean updateResetPassword(String email, String password) {
		return dbEngine().update(SQLQueryConstants.UPDATE_PASSWORD_QUERY,
				password, email);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gof.voting.dao.LoginDetailsDao#validateMailId(java.lang.String)
	 */
	@Override
	public LoginDetails validateMailId(String mail) {
		List<LoginDetails> list = dbEngine().select(
				SQLQueryConstants.GET_LOGINdETAILS_BY_EMAIL,
				LOGINDETAILS_MAPPER, mail);
		return list.isEmpty() ? null : list.get(0);
	}
}
