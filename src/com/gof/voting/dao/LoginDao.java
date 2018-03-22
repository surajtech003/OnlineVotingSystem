package com.gof.voting.dao;

import java.sql.Connection;

import com.gof.voting.model.LoginDetails;

/**
 * This LoginDao.java interface having method to get LoginDetails.
 * 
 * @author suraj singh
 *
 */
public interface LoginDao {

	/**
	 * 
	 * @param connection
	 * @param userName
	 * @return LoginDetails
	 */
	public LoginDetails getLoginDetails(Connection connection, String userName);

}
