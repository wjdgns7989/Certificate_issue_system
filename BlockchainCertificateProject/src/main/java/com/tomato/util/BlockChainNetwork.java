package com.tomato.util;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class BlockChainNetwork {
	private static Map<String, String> block = new HashMap<String, String>();

	public static void addHashMap(String key, String value) {
		block.put(StringUtil.applySha256(key), StringUtil.applySha256(value));
	}

	public static boolean checkMap(String key, String value) {

		for (String mapKey : block.keySet()) {
			
		}

		return true;
	}

}
