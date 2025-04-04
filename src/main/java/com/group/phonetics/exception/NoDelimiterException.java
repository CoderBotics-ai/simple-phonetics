package com.group.phonetics.exception;

/**
 * Exception thrown when no delimiter is found in the input.
 * 
 * This class has been verified to be compatible with Java 11.
 * No changes were required during the Java 8 to Java 11 migration.
 * 
 * This class has been verified to be compatible with Java 17.
 * No changes were required during the Java 11 to Java 17 migration.
 */
public class NoDelimiterException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3444345556525610594L;

	public NoDelimiterException () {
		super("Error: No delimiter found. Check if the delimiter(\"<\") is concatenated with an input or word.");
	}
}