/**
 * 
 */
package com.gof.voting.dao;

import com.gof.voting.jdbc.DBEngine;

/**
 * @author suraj singh
 *
 */
public abstract class AbstractDao {
	
	private DBEngine dbEngine;

	public AbstractDao(final DBEngine dbEngine) {
		this.dbEngine = dbEngine;
	}

	protected final DBEngine dbEngine() {
		return dbEngine;
	}
}
