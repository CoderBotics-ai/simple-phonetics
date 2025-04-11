package com.group.phonetics.util;

// No specific Java 11 functional replacements needed for this class's logic.
// Optional 'var' keyword usage is introduced for local variables as per Java 10+.
// No changes needed for Java 17 upgrade based on the provided instructions,
// as 'var' usage here does not involve generics requiring explicit type arguments.
// Java 21 Upgrade: Replaced new StringBuilder("") with new StringBuilder() for best practice.
public class Helper {

	private enum Discard {A, E, I, H, O, U, W, Y;};

	public static String normalize (String word) {
		word = word.toUpperCase();
		// Use 'var' for local variable type inference (Java 10+) - No generics involved.
		// Java 21 Upgrade: Use preferred constructor for empty StringBuilder.
		var newWord = new StringBuilder();
		word = onlyAlphabetic(word);
		// Handle empty string after onlyAlphabetic
		if (word.isEmpty()) {
			return "";
		}
		newWord.append(word.charAt(0));
		for (int i = 1; i < word.length(); i++){
			// Use 'var' for local variable type inference (Java 10+) - Primitive type inferred.
			var c = word.charAt(i);
			try {
				// Check if the character should be discarded
				Discard.valueOf(String.valueOf(c)); // Use String.valueOf for clarity
			} catch (IllegalArgumentException ex) { // Existing exception handling is valid in Java 17 & 21.
				// If valueOf throws an exception, the character is not in Discard enum
				newWord.append(c);
			}
		}
		return newWord.toString();
	}

	/**
	 * Removes all non-alphabetic characters from a string.
	 * Note: Java 11's String.strip() removes leading/trailing whitespace,
	 * which is different from this method's goal of removing *all* non-alphabetic characters.
	 * Therefore, strip() is not applicable here.
	 * This logic remains valid and necessary in Java 17 & 21.
	 * @param word The input string.
	 * @return The string containing only alphabetic characters.
	 */
	public static String onlyAlphabetic (String word) {
		// Keep existing logic as strip() is not equivalent and replaceAll is standard.
		// No changes needed for Java 21 compatibility.
		return word.replaceAll("[^a-zA-Z]", "");
	}

}