package com.tomato.util;

import java.util.HashMap;
import java.util.Map;

public class LoginUser {

	private static Map<String, String> member = new HashMap<>();

	public static Map getInstance() {
		if (member.size() != 0) {
			return member;
		} else {
			member.put("halin", "1234");
			member.put("junghoon", "1234");
			return member;
		}
	}
}
