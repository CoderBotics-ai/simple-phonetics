package com.group.phonetics.enums;

import java.util.HashSet;
import java.util.Set;

public class PhoneticsSounds {

	private enum SOUND1 {
		A, E, I, O, U;
	};

	private enum SOUND2 {
		C, G, J, K, Q, S, X, Y, Z;
	};

	private enum SOUND3 {
		B, F, P, V, W;
	};

	private enum SOUND4 {
		D, T;
	};

	private enum SOUND5 {
		M, N;
	};

	// finds consecutive phonetics from comparable in the phonetic word
	public static boolean containPhonetic(String word, String comparable) {
		// Use var for local variable type inference (Java 10+)
		var w = findPhonetic(word);
		// Use var for local variable type inference (Java 10+)
		var c = findSetPhonetics(comparable);
		// Use var for loop variable type inference (Java 10+)
		for (var s : c) {
			if (w.contains(s))
				return true;
		}
		return false;
	}

	// phonetic from word represented by string
	private static String findPhonetic(String word) {
		// Use var for local variable type inference (Java 10+)
		var phonetic = new StringBuilder("");
		for (int i = 0; i < word.length(); i++) {
			phonetic.append(isPhonetic(word.charAt(i)));
		}
		return phonetic.toString();
	}

	// list of consecutive phonetic found
	private static Set<String> findSetPhonetics(String word) {
		// Use var for local variable type inference (Java 10+)
		// Explicit type argument needed for HashSet constructor when using var
		// Note: This HashSet is populated dynamically within the loop,
		// so it cannot be replaced with an immutable Set.of(...) which requires
		// all elements to be known at the time of creation.
		var phonetics = new HashSet<String>();
		// Use var for local variable type inference (Java 10+)
		var phonetic = new StringBuilder("");
		for (int i = 0; i < word.length(); i++) {
			phonetic.append(isPhonetic(word.charAt(i)));
			// Reset phonetic sequence if a non-phonetic character (0) is encountered
			if (phonetic.toString().equals("0"))
				phonetic.setLength(0);
			// Add phonetic sequences of length greater than 1
			if (phonetic.toString().length() > 1) {
				phonetics.add(phonetic.toString());
				// Reset after adding to find the next sequence
				phonetic.setLength(0);
			}
		}
		return phonetics;
	}

	// map phonetic
	private static int isPhonetic(char set) {
		// No changes needed here, logic remains compatible with Java 21
		// Although pattern matching for switch could be used in Java 21,
		// the current try-catch approach is functional and preserved for minimal changes.
		try {
			SOUND1.valueOf(String.valueOf(set)); // Use String.valueOf for clarity
			return 1;
		} catch (IllegalArgumentException ex) {
			// Ignore exception, try next sound group
		}
		try {
			SOUND2.valueOf(String.valueOf(set)); // Use String.valueOf for clarity
			return 2;
		} catch (IllegalArgumentException ex) {
			// Ignore exception, try next sound group
		}
		try {
			SOUND3.valueOf(String.valueOf(set)); // Use String.valueOf for clarity
			return 3;
		} catch (IllegalArgumentException ex) {
			// Ignore exception, try next sound group
		}
		try {
			SOUND4.valueOf(String.valueOf(set)); // Use String.valueOf for clarity
			return 4;
		} catch (IllegalArgumentException ex) {
			// Ignore exception, try next sound group
		}
		try {
			SOUND5.valueOf(String.valueOf(set)); // Use String.valueOf for clarity
			return 5;
		} catch (IllegalArgumentException ex) {
			// Ignore exception, character doesn't match any sound group
		}
		// Return 0 if the character does not belong to any defined sound group
		return 0;
	}

}