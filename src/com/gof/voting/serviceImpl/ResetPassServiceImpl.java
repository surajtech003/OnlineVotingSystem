/**
 * 
 */
package com.gof.voting.serviceImpl;

import java.sql.Connection;

import com.gof.voting.crypto.AesEncrptionDecryptionAlgo;
import com.gof.voting.dao.LoginDetailsDao;
import com.gof.voting.daoImpl.LoginDetailsDaoImpl;
import com.gof.voting.dbutils.DBUtils;
import com.gof.voting.email.SenderMail;
import com.gof.voting.jdbc.DBEngine;
import com.gof.voting.jdbc.DBEngineImpl;
import com.gof.voting.model.LoginDetails;
import com.gof.voting.service.RestePassService;

/**
 * @author suraj singh
 *
 */
public class ResetPassServiceImpl implements RestePassService {

	/* (non-Javadoc)
	 * @see com.gof.voting.service.RestePassService#updateResetPassword(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean updateResetPassword(String email, String password) {
		Connection connection = null;
		boolean isUpdate = false;
		LoginDetailsDao loginDetailsDao = null;
		DBEngine dbEngine = null;
		AesEncrptionDecryptionAlgo aesEncrptionDecryptionAlgo = null;
		try {
			connection = DBUtils.getConnection();
			dbEngine = new DBEngineImpl(connection);
			loginDetailsDao = new LoginDetailsDaoImpl(dbEngine);
			aesEncrptionDecryptionAlgo = new AesEncrptionDecryptionAlgo();
			String encPass = aesEncrptionDecryptionAlgo.encrypt(password);
			isUpdate = loginDetailsDao.updateResetPassword(email, encPass);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return isUpdate;
	}

	/* (non-Javadoc)
	 * @see com.gof.voting.service.RestePassService#validateMail(java.lang.String)
	 */
	@Override
	public boolean validateMail(String mail) {
		Connection connection = null;
		boolean isValidate = false;
		LoginDetailsDao loginDetailsDao = null;
		DBEngine dbEngine = null;
		LoginDetails loginDetails = null;
		SenderMail senderMail = null;
		try {
			connection = DBUtils.getConnection();
			dbEngine = new DBEngineImpl(connection);
			loginDetailsDao = new LoginDetailsDaoImpl(dbEngine);
			loginDetails = loginDetailsDao.validateMailId(mail);
			senderMail = new SenderMail();
			if (loginDetails.getEmail().equals(mail)) {
				senderMail.sendMail(mail, loginDetails);
				isValidate = true;
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return isValidate;
	}
}
	
	
	/*public static void main(String[] args) {
		RestePassService registerService = null;
		try {
			registerService = new ResetPassServiceImpl();
			boolean isUpdate = registerService.updateResetPassword("surajcse33@gmail.com",
					"surajkumar");
			System.out.println(isUpdate);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}*/

