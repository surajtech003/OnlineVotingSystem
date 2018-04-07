/**
 * 
 */
package com.gof.voting.service;

/**
 * @author suraj singh
 *
 */
public interface RestePassService {

	/**
	 * @param email
	 * @param password
	 * @return
	 */
	boolean updateResetPassword(String email, String password);
	
	boolean validateMail(String mail);

}
