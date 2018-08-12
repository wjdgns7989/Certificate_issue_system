package com.tomato.util;

import java.util.HashMap;
import java.util.Map;

public class LoginUser {

	private static Map<String, String> member = new HashMap<>();

	// 싱글톤 패턴을 사용하여 객체를 관리한다.
	public static Map getInstance() {
		if (member.size() != 0) {
			return member;
		} else {
			// 회원정보 삽입(데이터 베이스를 대체하는 역할을 한다.)
			member.put("halin", "1234");
			member.put("junghoon", "1234");
			return member;
		}
	}
}
