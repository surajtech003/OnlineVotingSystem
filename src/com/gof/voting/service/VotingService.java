package com.gof.voting.service;

import java.util.List;

import com.gof.voting.model.VotingMenu;

/**
 * This {@link VotingService} interface having method to get Voting List.
 * 
 * @author suraj singh
 *
 */
public interface VotingService {

	/**
	 * @return List<VotingMenu>
	 */
	public List<VotingMenu> getVotingDetails();

}
