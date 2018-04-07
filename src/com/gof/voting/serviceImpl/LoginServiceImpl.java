package com.gof.voting.serviceImpl;

import java.sql.Connection;

import com.gof.voting.crypto.AesEncrptionDecryptionAlgo;
import com.gof.voting.dao.LoginDetailsDao;
import com.gof.voting.daoImpl.LoginDetailsDaoImpl;
import com.gof.voting.dbutils.DBUtils;
import com.gof.voting.jdbc.DBEngine;
import com.gof.voting.jdbc.DBEngineImpl;
import com.gof.voting.model.LoginDetails;
import com.gof.voting.service.LoginService;

/**
 * This {@link LoginServiceImpl} class is used to check user is valid or not
 * from db side.
 * 
 * @author suraj singh
 *
 */
public class LoginServiceImpl implements LoginService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gof.voting.service.LoginService#getLoginDetails(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean getLoginDetails(String userName, String password) {
		boolean isValid = false;
		Connection connection = null;
		LoginDetailsDao loginDetailsDao = null;
		LoginDetails loginDetails = null;
		DBEngine dbEngine = null;
		try {
			connection = DBUtils.getConnection();
			dbEngine = new DBEngineImpl(connection);
			loginDetailsDao = new LoginDetailsDaoImpl(dbEngine);
			loginDetails = loginDetailsDao.getLoginDetailsByUserName(userName);
			System.out.println(loginDetails);
			if (loginDetails != null) {
				isValid = validateCredential(userName, password, loginDetails);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return isValid;
	}

	/**
	 * This method is used to validate userName and password with using AES
	 * algorithms.
	 * 
	 * @param userName
	 * @param password
	 * @param loginDetails
	 * @return
	 */
	private boolean validateCredential(String userName, String password,
			LoginDetails loginDetails) {
		boolean isValidateor = false;
		AesEncrptionDecryptionAlgo sha256CryptoAES = null;
		try {
			if (userName.endsWith(loginDetails.getUserName())) {
				sha256CryptoAES = new AesEncrptionDecryptionAlgo();
				if ((sha256CryptoAES.decrypt(loginDetails.getPassword())
						.equals(password))) {
					isValidateor = true;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return isValidateor;
	}

	/*
	 * public static void main(String[] args) { LoginService loginService = new
	 * LoginServiceImpl(); boolean isValid =
	 * loginService.getLoginDetails("surajcse33", "surajcse33");
	 * System.out.println(isValid + " "); }
	 */

}
