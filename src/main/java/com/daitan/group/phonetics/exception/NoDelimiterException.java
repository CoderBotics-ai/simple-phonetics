package com.daitan.group.phonetics.exception;

public class NoDelimiterException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3444345556525610594L;

	public NoDelimiterException () {
		super("Error: No delimiter found.");
	}
}
