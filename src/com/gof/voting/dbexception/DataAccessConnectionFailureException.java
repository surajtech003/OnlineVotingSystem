/**
 * 
 */
package com.gof.voting.dbexception;

/**
 * @author suraj singh
 *
 */
public class DataAccessConnectionFailureException extends DataAccessException {

	private static final long serialVersionUID = 1L;

	public DataAccessConnectionFailureException(final Throwable cause) {
		super(cause);
	}
}
