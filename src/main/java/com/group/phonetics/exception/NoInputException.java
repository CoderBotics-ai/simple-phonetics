package com.group.phonetics.exception;

public class NoInputException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3062133015414522741L;
	
	public NoInputException() {
		super("Error: No input file found.");
	}

}
