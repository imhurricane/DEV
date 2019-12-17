package com.appsoft.utils;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.UUID;

public class AppTool {

	public static String encodeByMd5(String string) {

		String encodeToString = "";
		try {
			// 确定计算方法
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			Base64.Encoder base64Encoder = Base64.getEncoder();
			encodeToString = base64Encoder.encodeToString(md5.digest(string.getBytes("utf-8")));
			// 加密字符串
		} catch (Exception e) {
			e.printStackTrace();
		}

		return encodeToString;
	}

	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "").replaceAll(" ", "");
	}

}
