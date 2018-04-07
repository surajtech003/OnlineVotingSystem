package com.gof.voting.serviceImpl;

import java.sql.Connection;

import com.gof.voting.crypto.AesEncrptionDecryptionAlgo;
import com.gof.voting.dao.LoginDetailsDao;
import com.gof.voting.daoImpl.LoginDetailsDaoImpl;
import com.gof.voting.dbutils.DBUtils;
import com.gof.voting.jdbc.DBEngine;
import com.gof.voting.jdbc.DBEngineImpl;
import com.gof.voting.model.LoginDetails;
import com.gof.voting.service.RegisterService;

/**
 * This {@link RegisterServiceImpl} class is used to register the loginDetails.
 * 
 * @author suraj singh
 *
 */
public class RegisterServiceImpl implements RegisterService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gof.voting.service.RegisterService#registerLogger(com.gof.voting.
	 * model.LoginDetails)
	 */
	@Override
	public boolean registerLogger(LoginDetails loginDetails) {
		Connection connection = null;
		LoginDetailsDao loginDetailsDao = null;
		boolean isRegister = false;
		DBEngine dbEngine = null;
		try {
			connection = DBUtils.getConnection();
			dbEngine = new DBEngineImpl(connection);
			loginDetailsDao = new LoginDetailsDaoImpl(dbEngine);
			encryptCredential(loginDetails);
			isRegister = loginDetailsDao.registerLogger(loginDetails);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return isRegister;
	}

	/**
	 * This method is used to encrypt the password.
	 * 
	 * @param loginDetails
	 */
	private void encryptCredential(LoginDetails loginDetails) {
		AesEncrptionDecryptionAlgo sha256CryptoAES = null;
		String encryptPassword = null;
		try {
			sha256CryptoAES = new AesEncrptionDecryptionAlgo();
			encryptPassword = sha256CryptoAES.encrypt(loginDetails
					.getPassword());
			loginDetails.setPassword(encryptPassword);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
