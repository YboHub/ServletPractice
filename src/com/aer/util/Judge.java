package com.aer.util;

public class Judge {
	public static boolean isNotEmpty(String str){
		boolean flag = false;
		if (str!=null&&!str.equals("")) {
			flag = true;
		}
		return flag;
	}
}
