package com.group.phonetics.util;

public class Helper {
	
	// No changes needed for enum declaration - Java 11 fully supports this syntax
	private enum Discard {A, E, I, H, O, U, W, Y;};
	
	public static String normalize (String word) {		
		word = word.toUpperCase();
		// Using StringBuilder is still the recommended approach in Java 11
		StringBuilder newWord = new StringBuilder("");
		word = onlyAlphabetic(word);
		newWord.append(word.charAt(0));
		for (int i = 1; i < word.length(); i++){
			char c = word.charAt(i);
			try {
				// This enum valueOf usage is compatible with Java 11
				Discard.valueOf(c+"");
			}catch (IllegalArgumentException ex) {
				newWord.append(c);
			}
		}
		return newWord.toString();
	}

	public static String onlyAlphabetic (String word) {
		// Regular expression usage remains unchanged in Java 11
		return word.replaceAll("[^a-zA-Z]", "");
	}
	
}