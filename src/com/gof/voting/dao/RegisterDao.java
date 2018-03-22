package com.gof.voting.dao;

import java.sql.Connection;

import com.gof.voting.model.LoginDetails;

/**
 * This RegisterDao.java interface having one method to register the
 * crendiatial.
 * 
 * @author suraj singh
 *
 */
public interface RegisterDao {

	/**
	 * @param connection
	 * @param loginDetails
	 */
	public boolean registerLogger(Connection connection, LoginDetails loginDetails);

}
