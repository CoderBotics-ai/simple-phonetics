package com.group.phonetics.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.group.phonetics.exception.MultipleInputsException;
import com.group.phonetics.exception.NoDelimiterException;
import com.group.phonetics.exception.NoInputException;
import com.group.phonetics.exception.NoWordException;

/**
 * Represents the phonetic conversion task, holding the input source and the words to be converted.
 * 
 * Note for future improvements (Java 17+): This class could potentially be refactored 
 * into a Java `record` if its primary purpose remains data holding and immutability 
 * becomes desirable, which would reduce boilerplate code for constructors, getters, 
 * equals(), hashCode(), and toString(). However, the current design with setters and 
 * the complex initialization logic in `setEnviroment` might require adjustments if 
 * converted to a record. Leaving it as a class maintains compatibility with minimal changes.
 */
public class Phonetics {

	private String input;
	private List<String> words;

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public List<String> getWords() {
		return words;
	}

	public void setWords(List<String> words) {
		this.words = words;
	}

	/**
	 * Parses command-line arguments to set the words and input source.
	 * Arguments before '<' are treated as words. The argument after '<' is the input source.
	 * If '<' is not present, all arguments are words, and input is set to "stdin".
	 * 
	 * @param args Command-line arguments.
	 * @throws NoWordException If no words are provided before the delimiter or if no arguments are given when stdin is expected.
	 * @throws NoDelimiterException Not explicitly thrown here but part of the design consideration (handled by logic).
	 * @throws NoInputException If the delimiter is the last argument.
	 * @throws MultipleInputsException If more than one argument follows the delimiter.
	 */
	public void setEnviroment(String[] args)
			throws NoWordException, NoDelimiterException, NoInputException, MultipleInputsException {

		final String DELIMITER = "<";
		int i;

		this.words = new ArrayList<>();

		// Check if args contains the delimiter
		boolean hasDelimiter = false;
		for (String arg : args) {
			if (arg.equals(DELIMITER)) {
				hasDelimiter = true;
				break;
			}
		}
		
		// If no delimiter in args, assume all args are words and use stdin for input
		if (!hasDelimiter) {
			// Handle the case where the shell redirects stdin but provides no word arguments
			if (args.length == 0) {
				throw new NoWordException();
			}
			
			// Add all arguments as words
			// No change needed for Java 17: Standard for-loop is compatible.
			for (i = 0; i < args.length; ++i) {
				this.words.add(args[i]);
			}
			
			// Use "stdin" as a special marker to read from standard input
			this.input = "stdin";
			return; // Exit early as processing is complete for this case
		}
		
		// Regular processing when delimiter is present
		// Find words before the delimiter
		// No change needed for Java 17: Standard for-loop and String.equals are compatible.
		for (i = 0; i < args.length && !args[i].equals(DELIMITER); ++i) {
			this.words.add(args[i]);
		}

		// Check if any words were found before the delimiter
		if (this.words.isEmpty()) { // Use isEmpty() for clarity, functionally same as size() == 0
			throw new NoWordException();
		}

		// Check if the delimiter was the last argument (meaning no input source specified after it)
		if (args.length - 1 == i) {
			throw new NoInputException();
		}

		// Check if more than one argument follows the delimiter
		// No change needed for Java 17: Arrays.copyOfRange is compatible.
		if (Arrays.copyOfRange(args, i + 1, args.length).length > 1) {
			throw new MultipleInputsException();
		}

		// Set the input source to the argument immediately following the delimiter
		this.input = args[++i]; // Increment i first to get the index after the delimiter

	}

}