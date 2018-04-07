package com.gof.voting.serviceImpl;

import java.sql.Connection;
import java.util.List;

import com.gof.voting.dao.VotingDao;
import com.gof.voting.daoImpl.VotingDaoImpl;
import com.gof.voting.dbutils.DBUtils;
import com.gof.voting.jdbc.DBEngine;
import com.gof.voting.jdbc.DBEngineImpl;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gof.voting.service.VotingService#getVotingDetails()
	 */
	@Override
	public List<VotingMenu> getVotingDetails() {
		Connection connection = null;
		VotingDao votingDao = null;
		DBEngine dbEngine = null;

		try {
			connection = DBUtils.getConnection();
			dbEngine = new DBEngineImpl(connection);
			votingDao = new VotingDaoImpl(dbEngine);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return votingDao.getVotingDetails();
	}

	/*
	 * public static void main(String[] args) { VotingService votingService =
	 * new VotingServiceImpl(); List<VotingMenu> list =
	 * votingService.getVotingDetails(); for (VotingMenu votingMenu : list) {
	 * System.out.println("In service impl:");
	 * System.out.println(votingMenu.getSerialNumber());
	 * System.out.println(votingMenu.getPartyName());
	 * System.out.println(votingMenu.getSymbol()); } }
	 */

}
