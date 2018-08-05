package com.tomato.util;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class BlockChainNetwork {
	private static Map<String, String> block = new HashMap<String, String>();

	public static void addHashMap(String key, String value) {
		block.put(StringUtil.applySha256(key), StringUtil.applySha256(value));
	}

	// key 와 value에는 timeStamp를 붙여서 보내야 한다.
	public static boolean checkMap(String key, String value) {
		boolean hasHashvalue = false;
		// key와 value가 전부 맞는 것을 찾는다.
		String hashKey = StringUtil.applySha256(key);
		String hashValue = StringUtil.applySha256(value);
		if (block.containsKey(hashKey) && block.get(hashKey).equals(hashValue)) {
			hasHashvalue = true;
		}
		System.out.println(hasHashvalue);

		
		for(String keyset:block.keySet()) {
			System.out.println(keyset+block.get(keyset));
		}
		System.out.println("====================");

		
		System.out.println(hashKey+hashValue);
		
		return hasHashvalue;
	}

}
