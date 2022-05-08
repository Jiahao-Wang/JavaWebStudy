package com.javaweb.util;

/**
 * @author Jiahao Wang
 * @create 2022-05-08 12:15
 */
public class StringUtil {
	public static boolean isEmpty(String str){
		return str == null || "".equals(str);
	}

	public static boolean isNotEmpty(String str){
		return !isEmpty(str);
	}
}
