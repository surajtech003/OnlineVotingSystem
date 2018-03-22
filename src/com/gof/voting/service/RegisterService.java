package com.gof.voting.service;

import com.gof.voting.model.LoginDetails;

/**
 * This {@link RegisterService} interface having method to register login
 * crenditial.
 * 
 * @author suraj singh
 *
 */
public interface RegisterService {

	/**
	 * @param loginDetails
	 */
	public boolean registerLogger(LoginDetails loginDetails);

}
