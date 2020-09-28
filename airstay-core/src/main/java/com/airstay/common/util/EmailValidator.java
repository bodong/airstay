package com.airstay.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

/**
 * @author sarwo.wibowo
 *
 */
public class EmailValidator {
	private static final String regex = "^(.+)@(.+)$";
	
	public static boolean validEmail(String email) {
		
		if(StringUtils.isEmpty(email)) {
			return false;
		}
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
}
