package com.gof.voting.dao;

import java.sql.Connection;
import java.util.List;

import com.gof.voting.model.VotingMenu;

/**
 * This VotingDao.java interface having one method to get Voting List.
 * 
 * @author suraj singh
 *
 */
public interface VotingDao {

	/**
	 * @param connection
	 * @return list<VotingMenu>
	 */
	public List<VotingMenu> getVotingDetails(Connection connection);

}
