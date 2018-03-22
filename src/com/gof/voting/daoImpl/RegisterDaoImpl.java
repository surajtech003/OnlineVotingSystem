package com.gof.voting.daoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import com.gof.voting.dao.RegisterDao;
import com.gof.voting.model.LoginDetails;



/**
 * This RegisterDaoImpl.java class is used to store the credential to db.
 * 
 * @author suraj singh
 *
 */
public class RegisterDaoImpl implements RegisterDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gof.voting.dao.RegisterDao#registerLogger(java.sql.Connection,
	 * com.gof.voting.model.LoginDetails)
	 */
	@Override
	public boolean registerLogger(Connection connection, LoginDetails loginDetails) {
		PreparedStatement preparedStatement = null;
		boolean isRegister = false;
		try {
			preparedStatement = connection
					.prepareStatement("insert into LoginDetails values(?,?,?,?,?)");
			preparedStatement.setInt(1, loginDetails.getUserId());
			preparedStatement.setString(2, loginDetails.getUserName());
			preparedStatement.setString(3, loginDetails.getPassword());
			preparedStatement.setString(4, loginDetails.getRole());
			preparedStatement.setString(5, loginDetails.getEmail());

			int update = preparedStatement.executeUpdate();

			if (update == 1) {
				System.out.println("record inserted successfully");
				isRegister = true;
			} else {
				System.out.println("not inserted");
				isRegister = false;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return isRegister;

	}

}
