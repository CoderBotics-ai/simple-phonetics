package com.group.phonetics.util;

public class Helper {
	
	// No changes needed for Java 11 compatibility
	// The enum declaration is already compatible with Java 11
	private enum Discard {A, E, I, H, O, U, W, Y;};
	
	public static String normalize (String word) {		
		word = word.toUpperCase();
		StringBuilder newWord = new StringBuilder("");
		word = onlyAlphabetic(word);
		newWord.append(word.charAt(0));
		for (int i = 1; i < word.length(); i++){
			char c = word.charAt(i);
			try {
				Discard.valueOf(c+"");
			}catch (IllegalArgumentException ex) {
				newWord.append(c);
			}
		}
		return newWord.toString();
	}

	public static String onlyAlphabetic (String word) {
		return word.replaceAll("[^a-zA-Z]", "");
	}
	
}