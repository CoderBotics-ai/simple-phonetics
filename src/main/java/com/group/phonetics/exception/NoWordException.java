package com.group.phonetics.exception;

public class NoWordException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1687890733248845738L;

	public NoWordException(){
		super("Error: No word found.");
	}
}
// No changes needed as this exception class is fully compatible with Java 21