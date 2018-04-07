package com.gof.voting.dao;

import java.util.List;

import com.gof.voting.model.LoginDetails;

/**
 * This LoginDao.java interface having method to get LoginDetails.
 * 
 * @author suraj singh
 *
 */
public interface LoginDetailsDao {

	LoginDetails getLoginDetailsByUserName(String userName);

	List<LoginDetails> getAllLoginDetailsUser();

	public boolean registerLogger(LoginDetails loginDetails);

	boolean updateResetPassword(String email, String password);

	LoginDetails validateMailId(String mail);
}
