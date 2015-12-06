package com.daitan.group.phonetics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.daitan.group.phonetics.enums.PhoneticsSounds;
import com.daitan.group.phonetics.exception.MultipleInputsException;
import com.daitan.group.phonetics.exception.NoDelimiterException;
import com.daitan.group.phonetics.exception.NoInputException;
import com.daitan.group.phonetics.exception.NoWordException;
import com.daitan.group.phonetics.util.Helper;

public class Phonetics {

	public static void main(String[] args) throws NoDelimiterException, NoInputException, MultipleInputsException,
			FileNotFoundException, IOException, NoWordException {

		final String DELIMITER = "<";
		int i;
		List<String> words = new ArrayList<>();
		String input;
		for (i = 0; i < args.length && !args[i].equals(DELIMITER); ++i) {
			words.add(args[i]);
		}

		if (words.size() == 0) {
			throw new NoWordException();
		}

		if (words.size() == args.length) {
			throw new NoDelimiterException();
		}

		if (args.length - 1 == i) {
			throw new NoInputException();
		}

		if (Arrays.copyOfRange(args, i + 1, args.length).length > 1) {
			throw new MultipleInputsException();
		}

		input = args[++i];

		for (String word : words) {
			String out = word + ": ";
			StringBuilder response = new StringBuilder();
			try (BufferedReader br = new BufferedReader(new FileReader(input))) {
				String line;
				while ((line = br.readLine()) != null) {
					// normalization removing non-alphabetic characters and
					// specific rules characters after first letter.
					if (PhoneticsSounds.containPhonetic(Helper.normalize(word), Helper.normalize(line))) {
						if (response.toString().equals(""))
							response.append(line);
						else
							response.append(", " + line);
					}
				}
			}
			System.out.println(out + response.toString());
		}

	}

}
