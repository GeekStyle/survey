package com.geekstyle.survey.util;

public class StringUtil {
	
	public static final String EMPTY = "";
	
	private StringUtil(){}
	/**
	 * check String is a null or empty
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if(str == null || str.equals("")) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * check String is not a null or empty 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		if(isEmpty(str)) {
			return false;
		}else {
			return true;
		}
	}
	
	public static String getCellKey(String cell){
		String nonBlank = cell.toLowerCase().replace(" ", "");
		if(nonBlank.contains("(")){
			return nonBlank.substring(0, nonBlank.indexOf('('));
		}else{
			return nonBlank;
		}
	}
	
	
}
