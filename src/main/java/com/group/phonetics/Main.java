package com.group.phonetics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.group.phonetics.enums.PhoneticsSounds;
import com.group.phonetics.pojo.Phonetics;
import com.group.phonetics.util.Helper;

public class Main {

	public static void main(String[] args) {

		Phonetics po = new Phonetics();
		try {
			po.setEnviroment(args);
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			System.exit(0);
		}

		List<Map<String, String>> normalized = new ArrayList<>();
		
		// Using try-with-resources which is more idiomatic in Java 11 and Java 17
		// This automatically handles closing the resource even if an exception occurs
		try (BufferedReader br = "stdin".equals(po.getInput()) 
				? new BufferedReader(new InputStreamReader(System.in))
				: new BufferedReader(new FileReader(po.getInput()))) {
			
			String line;
			while ((line = br.readLine()) != null) {
				Map<String, String> map = new HashMap<>();
				map.put(line, Helper.normalize(line));
				normalized.add(map);
			}
		} catch (FileNotFoundException e) {
			System.err.println("Error: File " + po.getInput() + " not found.");
			System.exit(0);
		} catch (IOException e) {
			System.err.println("Error: File " + po.getInput() + " could not be opened. Check your permissions.");
			System.exit(0);
		}
		
		for (String word : po.getWords()) {
			StringBuilder response = new StringBuilder();
			for (Map<String, String> map : normalized) {
				// normalization removing non-alphabetic characters and
				// specific rules characters after first letter.
				Map.Entry<String, String> entry = map.entrySet().iterator().next();
				if (PhoneticsSounds.containPhonetic(Helper.normalize(word), entry.getValue())) {
					if (response.toString().equals(""))
						response.append(entry.getKey());
					else
						response.append(", " + entry.getKey());
				}
			}
			System.out.println(word + ": " + response.toString());
		}

	}

}