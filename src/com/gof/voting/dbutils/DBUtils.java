package com.gof.voting.dbutils;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


/**
 * This class contains all the utility methods for database connection.
 * 
 * @author Suraj Singh
 */
public class DBUtils {

	private static String USERNAME;

	private static String PASSWORD;

	private static String DRIVER;

	private static String URL;


	static {
		Properties properties = new Properties();
		try {
			properties.load(DBUtils.class.getClassLoader().getResourceAsStream(
					DBConstants.PROP_PATH_SQL));
			USERNAME = properties.getProperty(DBConstants.PROP_USERNAME);
			PASSWORD = properties.getProperty(DBConstants.PROP_PASSWORD);
			URL = properties.getProperty(DBConstants.PROP_URL);
			DRIVER = properties.getProperty(DBConstants.PROP_DRIVER);
			
			Class.forName(DRIVER);

			
		} catch (ClassNotFoundException e) {
			// dblogger.error(DBConstants.DRIVER_LOAD_ERR_MSG);
			e.printStackTrace();
		} catch (IOException e) {
			// dblogger.error(DBConstants.PROP_LOAD_ERR_MSG);
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		Connection connection=null;
		try {
			connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void closeConnection(Connection connection)  {
		if(connection!=null)
			try {
				connection.close();
			} catch (SQLException e) {
				
			}
	}
	
	/*public static void main(String[] args) {
		System.out.println(URL);
		System.out.println(UNAME);
		System.out.println(DRIVER);
		System.out.println(PWD);
	}*/
	
}
