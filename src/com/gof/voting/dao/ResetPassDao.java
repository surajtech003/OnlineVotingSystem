/**
 * 
 */
package com.gof.voting.dao;

import java.sql.Connection;

/**
 * @author suraj singh
 *
 */
public interface ResetPassDao {

	/**
	 * @param connection
	 * @param email
	 * @param password
	 * @return
	 */
	boolean updateResetPassword(Connection connection, String email,
			String password);

}
