package com.group.phonetics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.group.phonetics.enums.PhoneticsSounds;
import com.group.phonetics.pojo.Phonetics;
import com.group.phonetics.util.Helper;

public class Main {

	public static void main(String[] args) {

		Phonetics po = new Phonetics();
		try {
			po.setEnviroment(args);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		for (String word : po.getWords()) {
			StringBuilder response = new StringBuilder();
			try (BufferedReader br = new BufferedReader(new FileReader(po.getInput()))) {
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
			} catch (FileNotFoundException e) {
				System.out.println("Error: File " + po.getInput() + " not found.");
				System.exit(0);
			} catch (IOException e) {
				System.out.println("Error: File " + po.getInput() + " could not be opened. Check your permissions.");
				System.exit(0);
			}
			System.out.println(word + ": " + response.toString());
		}

	}

}
