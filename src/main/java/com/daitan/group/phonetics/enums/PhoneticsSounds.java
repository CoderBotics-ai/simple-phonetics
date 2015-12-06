package com.daitan.group.phonetics.enums;

public class PhoneticsSounds {

	private enum SOUND1 { A, E, I, O, U; };
	private enum SOUND2 { C, G, J, K, Q, S, X, Y, Z; };
	private enum SOUND3 { B, F, P, V, W; };
	private enum SOUND4 { D, T; };
	private enum SOUND5 { M, N; };
	
	public static boolean containPhonetic(String word, String comparable) {
		//System.out.println(word+" - "+comparable);
		int count = 0;
		for (int i = 0; i < comparable.length(); i++){
		    char c = comparable.charAt(i);       
		    count = (isPhonetic(c)) ? count+1 : 0;
		    if (count > 1)
		    	return true;
		}
		return false;
	}

	private static boolean isPhonetic(char set) {
		try {
			SOUND1.valueOf(set+"");
			return true;
		}catch (IllegalArgumentException ex) { 
		}
		try {
			SOUND2.valueOf(set+"");
			return true;
		}catch (IllegalArgumentException ex) {  			
		}
		try {
			SOUND3.valueOf(set+"");
			return true;
		}catch (IllegalArgumentException ex) {  			
		}
		try {
			SOUND4.valueOf(set+"");
			return true;
		}catch (IllegalArgumentException ex) {  			
		}
		try {
			SOUND5.valueOf(set+"");
			return true;
		}catch (IllegalArgumentException ex) {  			
		}
		return false;
	}

}
