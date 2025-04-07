package com.group.phonetics.tests;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.group.phonetics.pojo.Phonetics;

/**
 * Test class for Phonetics functionality.
 * Note: Tests are currently ignored. Review and potentially enable/update them
 * as part of testing the application on Java 11. The core Java APIs used
 * (File I/O, String, Exception Handling) are compatible between Java 8 and 11.
 */
public class PhoneticsTests {

	@Disabled // Test remains ignored as per original code. No Java 11 specific changes needed within the test.
	@Test
	public void emptyTest(){

		String args[] = new String[]{};

		Phonetics po = new Phonetics();
		try {
			po.setEnviroment(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Disabled // Test remains ignored as per original code. No Java 11 specific changes needed within the test.
	@Test
	public void noWordTest(){

		String args[] = new String[]{"<","C:\\Users\\marcosrachid\\workspace\\SearchPhonetics\\src\\main\\resource\\word_dict.txt"};

		Phonetics po = new Phonetics();
		try {
			po.setEnviroment(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Disabled // Test remains ignored as per original code. No Java 11 specific changes needed within the test.
	@Test
	public void noDelimiterTest(){

		String args[] = new String[]{"1ton#", "brief", "soon", "C:\\Users\\marcosrachid\\workspace\\SearchPhonetics\\src\\main\\resource\\word_dict.txt"};

		Phonetics po = new Phonetics();
		try {
			po.setEnviroment(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Disabled // Test remains ignored as per original code. No Java 11 specific changes needed within the test.
	@Test
	public void noInputFileTest(){

		String args[] = new String[]{"1ton#", "brief", "soon", "<"};

		Phonetics po = new Phonetics();
		try {
			po.setEnviroment(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Disabled // Test remains ignored as per original code. No Java 11 specific changes needed within the test.
	@Test
	public void MultipleInputFileTest(){

		String args[] = new String[]{"1ton#", "brief", "soon", "<", "C:\\Users\\marcosrachid\\workspace\\SearchPhonetics\\src\\main\\resource\\word_dict.txt", "C:\\Users\\marcosrachid\\workspace\\SearchPhonetics\\src\\main\\resource\\word_dict.txt"};

		Phonetics po = new Phonetics();
		try {
			po.setEnviroment(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Disabled // Test remains ignored as per original code. No Java 11 specific changes needed within the test.
	@Test
	public void inputFileNotFoundTest(){

		// The file I/O operations (FileReader, BufferedReader) and exception handling
		// used here are fully compatible with Java 11. No changes are required.
		// The try-finally block for resource management, while replaceable with
		// try-with-resources (available since Java 7), is left unchanged to adhere
		// to the minimal change requirement.
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\marcosrachid\\workspace\\SearchPhonetics\\src\\main\\resource\\word_dict.tx"));
			// Added @Test annotation which was missing, although the test remains ignored.
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			// This catch block was missing in the original for the br.readLine() potentially throwing IOException,
            // however, since no reading is done, only the constructor is called,
            // FileNotFoundException (subclass of IOException) is the primary expected exception.
            // Keeping original structure.
			System.err.println(e.getMessage());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// Ignored as per original code
					System.err.println(e.getMessage());
				}
			}
		}

	}

}
