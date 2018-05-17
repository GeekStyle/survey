package com.geekstyle.survey.util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.codec.digest.DigestUtils;

public class FileUtil {

	public static String getMd5(File file) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			String md5 = DigestUtils.md5Hex(fis);
			fis.close();
			return md5;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}	
	
	public static String getMd5(String filePath) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File(filePath));
			String md5 = DigestUtils.md5Hex(fis);
			fis.close();
			return md5;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}
