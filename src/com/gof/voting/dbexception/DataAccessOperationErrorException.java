/**
 * 
 */
package com.gof.voting.dbexception;

/**
 * @author suraj singh
 *
 */
public class DataAccessOperationErrorException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataAccessOperationErrorException() {
	}

	public DataAccessOperationErrorException(final String message,
			final Throwable cause) {
		super(message, cause);
	}

	public DataAccessOperationErrorException(final String message) {
		super(message);
	}

	public DataAccessOperationErrorException(final Throwable cause) {
		super(cause);
	}
}
