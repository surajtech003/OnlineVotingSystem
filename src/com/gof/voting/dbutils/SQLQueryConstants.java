package com.gof.voting.dbutils;

/**
 * This class contains all query constants.
 * 
 * @author suraj singh
 */
public class SQLQueryConstants {

	// Get all records query
	public static final String GET_VOTINGLIST_QUERY = "SELECT * FROM VotingMenu";
	public static final String GET_LOGIN_DETAILS_QUERY = "SELECT * FROM LoginDetails";

	// Get records based on parameter query
	public static final String GET_LOGINdETAILS_BY_USERNAME = "SELECT * FROM LoginDetails WHERE userName = ?";
	public static final String GET_LOGINdETAILS_BY_EMAIL = "SELECT * FROM LoginDetails WHERE email = ?";

	// Update record query
	public static final String UPDATE_PASSWORD_QUERY = "UPDATE LoginDetails SET password = ? WHERE email = ?";

	// Insert record query
	public static final String INSERT_LOGIN_DETAILS_QUERY = "INSERT INTO LoginDetails VALUES(?,?,?,?,?,?)";

}
