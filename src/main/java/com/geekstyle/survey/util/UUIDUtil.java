package com.geekstyle.survey.util;

import java.util.UUID;

public class UUIDUtil {
	/**
	 * get a UUID
	 * @return
	 */
	public static String getUUID() {
		String uuid = UUID.randomUUID().toString();
		return uuid.substring(0,8)+uuid.substring(9,13)+uuid.substring(14,18)+uuid.substring(19,23)+uuid.substring(24); 
	}
	
	public static void main(String args[]) {
		System.out.println(getUUID());
	}
}
