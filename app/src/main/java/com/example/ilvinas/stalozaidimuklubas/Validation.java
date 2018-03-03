package com.example.ilvinas.stalozaidimuklubas;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	private static final String VALID_CREDENTIALS_REGEX = "^[a-žA-Ž0-9.-]{3,32}$";
	private static final String VALID_EMAIL_ADDRESS_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
	private static final String VALID_ID_REGEX = "^[0-9]{1,10}$";
	private static final String VALID_YEAR_REGEX = "^(?:(?:18|19|20)[0-9]{2})$";
	private static final String VALID_TITLE_REGEX = "^[A-ža-Ž0-9._ %+-?!&()*,]{1,1000}$";
	
	public static boolean isValidCredentials(String creds) {
		Pattern patt = Pattern.compile(VALID_CREDENTIALS_REGEX);
		Matcher match = patt.matcher(creds);
		return match.find();
	}
	
	public static boolean isValidMail(String mail) {
		Pattern patt = Pattern.compile(VALID_EMAIL_ADDRESS_REGEX);
		Matcher match = patt.matcher(mail);
		return match.find();
	}
	
	public static boolean isValidId(String id) {
		Pattern patt = Pattern.compile(VALID_ID_REGEX);
		Matcher match = patt.matcher(id);
		return match.find();
	}
	
	public static boolean isValidYear(String year) {
		Pattern patt = Pattern.compile(VALID_YEAR_REGEX);
		Matcher match = patt.matcher(year);
		return match.find();
	}
	
	public static boolean isValidTitle(String title) {
		Pattern patt = Pattern.compile(VALID_TITLE_REGEX);
		Matcher match = patt.matcher(title);
		return match.find();
	}
	
}
