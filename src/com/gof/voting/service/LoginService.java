package com.gof.voting.service;

/**
 * This {@link LoginService} interface having method to check crenditial
 * details.
 * 
 * @author suraj singh
 *
 */
public interface LoginService {

	/**
	 * @param userName
	 * @param password
	 * @return
	 */
	public boolean getLoginDetails(String userName, String password);
}
