package com.geekstyle.survey.util;

import java.io.StringWriter;
import java.io.Writer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtil {
    
    private static final Logger logger = LoggerFactory.getLogger(JSONUtil.class);

	private static ObjectMapper mapper=new ObjectMapper();
	
	public static String toJSONString(Object obj) {
		Writer write=new StringWriter();
		try {
			mapper.writeValue(write, obj);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
		return write.toString();
	}
	
	public static <T> T toObject(String jsonStr,Class<T> classType) {
		T t=null;
		try {
			t=mapper.readValue(jsonStr.getBytes("UTF-8"),classType);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
		return t;
	}
	
}
