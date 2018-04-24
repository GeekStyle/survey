package com.geekstyle.survey.util;

import java.util.Random;

public class RandomUtil {
	
	private static Random random = new Random();
	
	public static String getRandomChar() {
		return Character.toString((char)(random.nextInt(26) + 97));
	}
	
	public static String getRandomChar(int length) {
		StringBuilder randomChar = new StringBuilder("");
		for(int i=0;i<length;i++) {
			randomChar.append(getRandomChar());
		}
		return randomChar.toString();
	}

}
