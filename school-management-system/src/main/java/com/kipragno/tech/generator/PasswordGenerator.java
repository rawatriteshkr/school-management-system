package com.kipragno.tech.generator;

import java.security.SecureRandom;

public class PasswordGenerator {

	public static String generatePassword(int length) {

		String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
		String specialCharacters = "!@#$";
		String numbers = "1234567890";
		final String combinedChars = numbers + capitalCaseLetters + specialCharacters + lowerCaseLetters;
		
		SecureRandom secureRnd = new SecureRandom();

		StringBuilder sb = new StringBuilder(length); 
		for (int i = 0; i < length; i++) 
			sb.append(combinedChars.charAt(secureRnd.nextInt(combinedChars.length()))); 
		return sb.toString(); 
	}
}
