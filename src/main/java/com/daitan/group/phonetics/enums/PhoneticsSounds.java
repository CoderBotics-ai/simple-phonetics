package com.daitan.group.phonetics.enums;

import java.util.HashSet;
import java.util.Set;

public class PhoneticsSounds {

	private enum SOUND1 { A, E, I, O, U; };
	private enum SOUND2 { C, G, J, K, Q, S, X, Y, Z; };
	private enum SOUND3 { B, F, P, V, W; };
	private enum SOUND4 { D, T; };
	private enum SOUND5 { M, N; };
	
	public static boolean containPhonetic(String word, String comparable) {
		//System.out.println(word+" - "+comparable);
		String w = findPhonetic(word);
		//System.out.println(w+" - "+findPhonetic(comparable));
		Set<String> c = findSetPhonetics(comparable);
		for (String s : c) {
			//System.out.println(s);
			if(w.contains(s))
				return true;
		}
		return false;
	}
	
	private static String findPhonetic(String word) {
		StringBuilder phonetic = new StringBuilder("");
		for (int i = 0; i < word.length(); i++){
			phonetic.append(isPhonetic(word.charAt(i)));
		}
		return phonetic.toString();
	}
	
	private static Set<String> findSetPhonetics(String word) {
		Set<String> phonetics = new HashSet<>();
		StringBuilder phonetic = new StringBuilder("");
		for (int i = 0; i < word.length(); i++){			
			phonetic.append(isPhonetic(word.charAt(i)));
			if (phonetic.toString().equals("0"))
				phonetic.setLength(0);
			if (phonetic.toString().length() > 1) {
				phonetics.add(phonetic.toString());
				phonetic.setLength(0);
			}
		}
		return phonetics;
	}

	private static int isPhonetic(char set) {
		try {
			SOUND1.valueOf(set+"");
			return 1;
		}catch (IllegalArgumentException ex) { 
		}
		try {
			SOUND2.valueOf(set+"");
			return 2;
		}catch (IllegalArgumentException ex) {  			
		}
		try {
			SOUND3.valueOf(set+"");
			return 3;
		}catch (IllegalArgumentException ex) {  			
		}
		try {
			SOUND4.valueOf(set+"");
			return 4;
		}catch (IllegalArgumentException ex) {  			
		}
		try {
			SOUND5.valueOf(set+"");
			return 5;
		}catch (IllegalArgumentException ex) {  			
		}
		return 0;
	}

}
