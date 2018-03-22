package com.gof.voting.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gof.voting.dao.VotingDao;
import com.gof.voting.dbutils.DBUtils;
import com.gof.voting.dbutils.SQLQueryConstants;
import com.gof.voting.model.VotingMenu;

/**
 * This VotingDaoImpl.java class is used for to retrieving the voting list.
 * 
 * @author suraj singh
 *
 */
public class VotingDaoImpl implements VotingDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gof.voting.dao.VotingDao#getVotingDetails(java.sql.Connection)
	 */
	@Override
	public List<VotingMenu> getVotingDetails(Connection connection) {
		List<VotingMenu> votingDetailList = new ArrayList<VotingMenu>();
		VotingMenu votingMenu = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			statement = connection.createStatement();
			resultSet = statement
					.executeQuery(SQLQueryConstants.GET_VOTINGLIST_QUERY);
			while (resultSet.next()) {
				votingMenu = new VotingMenu();
				votingMenu.setSerialNumber(resultSet.getInt(1));
				votingMenu.setPartyName(resultSet.getString(2));
				votingMenu.setSymbol(resultSet.getInt(3));
				votingDetailList.add(votingMenu);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(connection);
		}
		return votingDetailList;
	}
}
