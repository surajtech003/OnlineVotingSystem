package com.gof.voting.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.gof.voting.dao.AbstractDao;
import com.gof.voting.dao.VotingDao;
import com.gof.voting.dbutils.SQLQueryConstants;
import com.gof.voting.jdbc.DBEngine;
import com.gof.voting.jdbc.RowMapper;
import com.gof.voting.model.VotingMenu;

/**
 * This VotingDaoImpl.java class is used for to retrieving the voting list.
 * 
 * @author suraj singh
 *
 */
public class VotingDaoImpl extends AbstractDao implements VotingDao {

	private static final RowMapper<VotingMenu> VOTING_MENU_MAPPER = new RowMapper<VotingMenu>() {

		@Override
		public VotingMenu map(final ResultSet resultSet) throws SQLException {
			final VotingMenu votingMenu = new VotingMenu();
			votingMenu.setSerialNumber(resultSet.getInt(1));
			votingMenu.setPartyName(resultSet.getString(2));
			votingMenu.setSymbol(resultSet.getInt(3));
			return votingMenu;
		}
	};

	/**
	 * @param dbEngine
	 */
	public VotingDaoImpl(DBEngine dbEngine) {
		super(dbEngine);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gof.voting.dao.VotingDao#getVotingDetails()
	 */
	@Override
	public List<VotingMenu> getVotingDetails() {
		return dbEngine().select(SQLQueryConstants.GET_VOTINGLIST_QUERY,
				VOTING_MENU_MAPPER);
	}
}
