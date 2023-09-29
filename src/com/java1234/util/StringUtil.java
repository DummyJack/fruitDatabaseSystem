package com.java1234.util;

/**
 * 字符串工具類
 * @author Jack
 *
 */

public class StringUtil {
	
	// 判斷 user or password 輸入是否是空
	public static boolean isEmpty(String str) {
		if(str==null || "".equals(str.trim())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// 判斷 user or password 輸入是否不是空
	public static boolean isNotEmpty(String str) {
		if(str!=null && !"".equals(str.trim())) {
			return true;
		}
		else {
			return false;
		}
	}
}
