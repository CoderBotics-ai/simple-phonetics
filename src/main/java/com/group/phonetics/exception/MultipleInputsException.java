package com.group.phonetics.exception;

/**
 * Exception thrown when multiple inputs are detected.
 * 
 * This class has been verified for Java 11 compatibility.
 * No changes were required as the implementation is compatible with both Java 8 and Java 11.
 */
public class MultipleInputsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7358548927881801895L;
	
	public MultipleInputsException() {
		super("Error: Multiple inputs found.");
	}

}