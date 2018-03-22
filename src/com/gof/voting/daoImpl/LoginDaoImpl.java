package com.gof.voting.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import com.gof.voting.dao.LoginDao;
import com.gof.voting.model.LoginDetails;

/**
 * This LoginDaoImpl.java class is used to login to Databse.
 * 
 * @author suraj singh
 *
 */
public class LoginDaoImpl implements LoginDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gof.voting.dao.LoginDao#getLoginDetails(java.sql.Connection,
	 * java.lang.String)
	 */
	@Override
	public LoginDetails getLoginDetails(Connection connection, String userName) {
		LoginDetails loginDetails = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection
					.prepareStatement("select * from LoginDetails where userName=?");
			preparedStatement.setString(1, userName);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				loginDetails = new LoginDetails();
				loginDetails.setUserId(resultSet.getInt(1));
				loginDetails.setUserName(resultSet.getString(2));
				loginDetails.setPassword(resultSet.getString(3));
				loginDetails.setRole(resultSet.getString(4));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return loginDetails;
	}

}
