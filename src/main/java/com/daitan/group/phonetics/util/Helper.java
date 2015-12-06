package com.daitan.group.phonetics.util;

public class Helper {
	
	private enum Discard {A, E, I, H, O, U, W, Y;};
	
	public static String normalize (String word) {
		StringBuilder newWord = new StringBuilder("");
		word = onlyAlphabetic(word);
		System.out.println(word);
		for (int i = 1; i < word.length(); i++){
			char c = word.charAt(i);
			try {
				Discard.valueOf(c+"");
			}catch (IllegalArgumentException ex) {
				newWord.append(c);
			}
		}
		return newWord.toString().toUpperCase();
	}

	public static String onlyAlphabetic (String word) {
		return word.replaceAll("[^a-zA-Z]", "");
	}
	
}
