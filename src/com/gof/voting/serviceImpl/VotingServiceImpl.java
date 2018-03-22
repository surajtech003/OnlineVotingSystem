package com.gof.voting.serviceImpl;

import java.sql.Connection;
import java.util.List;

import com.gof.voting.dao.VotingDao;
import com.gof.voting.daoImpl.VotingDaoImpl;
import com.gof.voting.dbutils.DBUtils;
import com.gof.voting.model.VotingMenu;
import com.gof.voting.service.VotingService;

/**
 * VotingServiceImpl.java class is used to apply business operation on
 * VotingLIst.
 * 
 * @author suraj singh
 *
 */
public class VotingServiceImpl implements VotingService {

	
	/* (non-Javadoc)
	 * @see com.gof.voting.service.VotingService#getVotingDetails()
	 */
	@Override
	public List<VotingMenu> getVotingDetails() {
		Connection connection = null;
		VotingDao votingDao = null;
		try {
			connection = DBUtils.getConnection();
			votingDao = new VotingDaoImpl();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return votingDao.getVotingDetails(connection);
	}

	/*
	 * public static void main(String[] args) { Connection connection = null;
	 * VotingDao votingDao = null; connection = DBUtils.getConnection();
	 * votingDao = new VotingDaoImpl(); List<VotingMenu> list =
	 * votingDao.getVotingDetails(connection); for (VotingMenu votingMenu :
	 * list) { System.out.println("In service impl:");
	 * System.out.println(votingMenu.getSerialNumber());
	 * System.out.println(votingMenu.getPartyName());
	 * System.out.println(votingMenu.getSymbol()); } }
	 */

}
