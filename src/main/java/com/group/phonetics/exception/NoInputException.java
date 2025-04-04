package com.group.phonetics.exception;

/**
 * Exception thrown when no input file is found.
 * 
 * This class has been verified to be compatible with Java 11.
 * No changes were required during the Java 8 to Java 11 upgrade.
 * 
 * This class has been verified to be compatible with Java 17.
 * No changes were required during the Java 11 to Java 17 upgrade.
 */
public class NoInputException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3062133015414522741L;
	
	public NoInputException() {
		super("Error: No input file found.");
	}

}