package com.group.phonetics.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.group.phonetics.exception.MultipleInputsException;
import com.group.phonetics.exception.NoDelimiterException;
import com.group.phonetics.exception.NoInputException;
import com.group.phonetics.exception.NoWordException;

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

	// This method remains unchanged as it's compatible with Java 17
	// Java 17 supports all valid Java 11 syntax and this code doesn't use any APIs 
	// that were deprecated or removed in Java 17
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
			// Handle the case where the shell redirects stdin
			if (args.length == 0) {
				throw new NoWordException();
			}
			
			for (i = 0; i < args.length; ++i) {
				this.words.add(args[i]);
			}
			
			// Use "stdin" as a special marker to read from standard input
			this.input = "stdin";
			return;
		}
		
		// Regular processing when delimiter is present
		for (i = 0; i < args.length && !args[i].equals(DELIMITER); ++i) {
			this.words.add(args[i]);
		}

		if (this.words.size() == 0) {
			throw new NoWordException();
		}

		if (args.length - 1 == i) {
			throw new NoInputException();
		}

		if (Arrays.copyOfRange(args, i + 1, args.length).length > 1) {
			throw new MultipleInputsException();
		}

		this.input = args[++i];

	}

}