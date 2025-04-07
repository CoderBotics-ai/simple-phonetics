package com.group.phonetics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
// No specific Java 11 file I/O features like Files.readString are directly applicable
// here without changing the line-by-line processing logic or stdin handling.
// Sticking with BufferedReader within try-with-resources is the minimal change.
// No specific Java 17/21 file I/O features offer a direct advantage here
// for the current logic compared to BufferedReader.
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.group.phonetics.enums.PhoneticsSounds;
import com.group.phonetics.pojo.Phonetics;
import com.group.phonetics.util.Helper;

public class Main {

	public static void main(String[] args) {

		// Use var for local variable type inference (Java 10+)
		// No changes needed for Java 17/21 compatibility. 'var' remains valid.
		var po = new Phonetics();
		try {
			po.setEnviroment(args);
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			System.exit(0);
		}

		// Use var for local variable type inference (Java 10+)
		// Explicit type arguments needed on the right for inference with generics.
		// This usage is correct and clear, no changes needed for Java 17/21.
		// Note: Java 21 introduces SequencedCollection, which ArrayList implements,
		// but no specific methods from that interface are needed here.
		var normalized = new ArrayList<Map<String, String>>();
		// Use try-with-resources (available since Java 7) for automatic resource management of BufferedReader
		// This replaces the manual br.close() in the finally block.
		// No changes needed for Java 17/21 compatibility.
		try (BufferedReader br = "stdin".equals(po.getInput())
				? new BufferedReader(new InputStreamReader(System.in))
				: new BufferedReader(new FileReader(po.getInput()))) {

			String line;
			while ((line = br.readLine()) != null) {
				// Use var for local variable type inference (Java 10+)
				// Explicit type arguments ensure correct type inference.
				// No changes needed for Java 17/21.
				var map = new HashMap<String, String>();
				map.put(line, Helper.normalize(line));
				normalized.add(map);
			}
		} catch (FileNotFoundException e) {
			System.err.println("Error: File " + po.getInput() + " not found.");
			System.exit(0);
		} catch (IOException e) {
			// Refined error message for clarity on input source
			System.err.println("Error: Could not read from " + ("stdin".equals(po.getInput()) ? "standard input" : po.getInput()) + ". " + e.getMessage());
			System.exit(0);
		}
		// The finally block for closing BufferedReader is no longer needed due to try-with-resources.

		for (String word : po.getWords()) {
			// Use var for local variable type inference (Java 10+)
			// No changes needed for Java 17/21.
			var response = new StringBuilder();
			for (Map<String, String> map : normalized) {
				// normalization removing non-alphabetic characters and
				// specific rules characters after first letter.
				// Use var for local variable type inference (Java 10+)
				// Type inference for Map.Entry<String, String> is clear.
				// No changes needed for Java 17/21.
				// Note: Assumes map always contains exactly one entry.
				// Java 21 features like Record Patterns or Pattern Matching for switch
				// are not directly applicable here without significant refactoring.
				if (!map.isEmpty()) {
					// Note: HashMap entrySet iteration order is not guaranteed, but
					// since we assume only one entry, iterator().next() is acceptable.
					// Java 21's SequencedMap/SequencedSet could offer getFirst() if
					// a suitable Map implementation (like LinkedHashMap) were used,
					// but it's not necessary for this upgrade.
					var entry = map.entrySet().iterator().next();
					if (PhoneticsSounds.containPhonetic(Helper.normalize(word), entry.getValue())) {
						// Check StringBuilder length for efficiency instead of toString().equals("")
						if (response.length() == 0)
							response.append(entry.getKey());
						else
							// Chain append calls for minor improvement
							response.append(", ").append(entry.getKey());
					}
				}
			}
			// Java 21's String Templates (preview feature) could format this,
			// but sticking to standard concatenation for stability.
			System.out.println(word + ": " + response.toString());
		}

		// Overall: No functional changes were required to upgrade this file from Java 17 to Java 21.
		// Existing features like 'var' and try-with-resources are fully compatible.
		// New Java 21 features do not offer necessary replacements or straightforward
		// improvements for the current logic without significant refactoring.
	}

}