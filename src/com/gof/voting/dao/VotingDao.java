package com.gof.voting.dao;

import java.sql.Connection;
import java.util.List;

import com.gof.voting.model.VotingMenu;

/**
 * 
 * @author suraj singh
 *
 */
public interface VotingDao {
	
	public List<VotingMenu> getVotingDetails(Connection connection);

}
