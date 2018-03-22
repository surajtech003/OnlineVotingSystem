/**
 * 
 */
package com.gof.voting.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.gof.voting.dao.ResetPassDao;

/**
 * @author suraj singh
 *
 */
public class ResetPassDaoImpl implements ResetPassDao {

	/* (non-Javadoc)
	 * @see com.gof.voting.dao.ResetPassDao#updateResetPassword(java.sql.Connection, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean updateResetPassword(Connection connection, String email,
			String password) {

		PreparedStatement preparedStatement = null;
		boolean isUpdate = false;
		try {
			preparedStatement = connection
					.prepareStatement("update LoginDetails set password=? where email=?");
			preparedStatement.setString(1, password);
			preparedStatement.setString(2, email);

			int update = preparedStatement.executeUpdate();

			if (update >= 1) {
				System.out.println("password updated successfully");
				isUpdate = true;
			} else {
				System.out.println("not updated");
				isUpdate = false;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return isUpdate;
	}
}
