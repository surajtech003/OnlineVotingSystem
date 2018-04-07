package com.gof.voting.dao;

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
	 * @return list<VotingMenu>
	 */
	public List<VotingMenu> getVotingDetails();
}
