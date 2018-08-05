package com.tomato.util;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class BlockChainNetwork {
	private static Map<String, String> block = new HashMap<String, String>();

	public static void addHashMap(String key, String value) {
		// 서버에서 timestamp를 가져온다.
		LocalDateTime currentDateTime = LocalDateTime.now();
		String time = String.valueOf(currentDateTime.getYear()) + "-"
				+ String.valueOf(currentDateTime.getMonthValue()) + "-"
				+ String.valueOf(currentDateTime.getDayOfMonth()) + " " + String.valueOf(currentDateTime.getHour())
				+ ":" + String.valueOf(currentDateTime.getMinute()) + ":"
				+ String.valueOf(currentDateTime.getSecond());
		System.out.println(key+"\t"+time);
		block.put(StringUtil.applySha256(key+time), StringUtil.applySha256(value+time));
	}
}
