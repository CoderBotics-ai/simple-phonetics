package com.group.phonetics.tests;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;

import com.group.phonetics.pojo.Phonetics;

public class PhoneticsTests {

	@Ignore
	public void emptyTest(){
		
		String args[] = new String[]{};
		
		Phonetics po = new Phonetics();
		try {
			po.setEnviroment(args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Ignore
	public void noWordTest(){
		
		String args[] = new String[]{"<","C:\\Users\\marcosrachid\\workspace\\SearchPhonetics\\src\\main\\resource\\word_dict.txt"};
		
		Phonetics po = new Phonetics();
		try {
			po.setEnviroment(args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Ignore
	public void noDelimiterTest(){
		
		String args[] = new String[]{"1ton#", "brief", "soon", "C:\\Users\\marcosrachid\\workspace\\SearchPhonetics\\src\\main\\resource\\word_dict.txt"};
		
		Phonetics po = new Phonetics();
		try {
			po.setEnviroment(args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Ignore
	public void noInputFileTest(){
		
		String args[] = new String[]{"1ton#", "brief", "soon", "<"};
		
		Phonetics po = new Phonetics();
		try {
			po.setEnviroment(args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Ignore
	public void MultipleInputFileTest(){
		
		String args[] = new String[]{"1ton#", "brief", "soon", "<", "C:\\Users\\marcosrachid\\workspace\\SearchPhonetics\\src\\main\\resource\\word_dict.txt", "C:\\Users\\marcosrachid\\workspace\\SearchPhonetics\\src\\main\\resource\\word_dict.txt"};
		
		Phonetics po = new Phonetics();
		try {
			po.setEnviroment(args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Ignore
	public void inputFileNotFoundTest(){
		
		BufferedReader br = null;
		try {			
			br = new BufferedReader(new FileReader("C:\\Users\\marcosrachid\\workspace\\SearchPhonetics\\src\\main\\resource\\word_dict.tx"));
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
				}
			}
		}
		
	}
	
}
