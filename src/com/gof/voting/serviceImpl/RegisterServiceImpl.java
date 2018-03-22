package com.gof.voting.serviceImpl;

import java.sql.Connection;

import com.gof.voting.crypto.AesEncrptionDecryptionAlgo;
import com.gof.voting.dao.RegisterDao;
import com.gof.voting.daoImpl.RegisterDaoImpl;
import com.gof.voting.dbutils.DBUtils;
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
		RegisterDao registerDao = null;
		boolean isRegister = false;
		try {
			connection = DBUtils.getConnection();
			registerDao = new RegisterDaoImpl();
			encryptCredential(loginDetails);
			isRegister = registerDao.registerLogger(connection, loginDetails);
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

	/*
	 * public static void main(String[] args) { LoginDetails loginDetails = new
	 * LoginDetails(); loginDetails.setUserName("surajcse");
	 * loginDetails.setPassword("surajcse"); loginDetails.setRole("user");
	 * 
	 * RegisterService registerService = null; try { registerService = new
	 * RegisterServiceImpl(); registerService.registerLogger(loginDetails); }
	 * catch (Exception e) { // TODO: handle exception } }
	 */
}
