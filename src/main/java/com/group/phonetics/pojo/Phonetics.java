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

	public void setEnviroment(String[] args)
			throws NoWordException, NoDelimiterException, NoInputException, MultipleInputsException {

		final String DELIMITER = "<";
		int i;

		this.words = new ArrayList<>();

		for (i = 0; i < args.length && !args[i].equals(DELIMITER); ++i) {
			this.words.add(args[i]);
		}

		if (this.words.size() == 0) {
			throw new NoWordException();
		}

		if (this.words.size() == args.length) {
			throw new NoDelimiterException();
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
