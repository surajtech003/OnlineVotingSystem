/**
 * 
 */
package com.gof.voting.serviceImpl;

import java.sql.Connection;

import com.gof.voting.dao.RegisterDao;
import com.gof.voting.dao.ResetPassDao;
import com.gof.voting.daoImpl.RegisterDaoImpl;
import com.gof.voting.daoImpl.ResetPassDaoImpl;
import com.gof.voting.dbutils.DBUtils;
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
		ResetPassDao resetPassDao = null;
		boolean isUpdate = false;
		try {
			connection = DBUtils.getConnection();
			resetPassDao = new ResetPassDaoImpl();
			isUpdate = resetPassDao.updateResetPassword(connection, email, password);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return isUpdate;
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
}
