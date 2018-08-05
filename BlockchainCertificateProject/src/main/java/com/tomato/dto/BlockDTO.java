package com.tomato.dto;

import java.time.LocalDateTime;
import java.util.Date;

import com.tomato.util.StringUtil;

public class BlockDTO {
	public String hash;
	public String previousHash;
	private String data; // our data will be a simple message.
	private String timeStamp; //localtime으로 변경

	public BlockDTO(String data, String previousHash, String timeStamp) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = timeStamp;
		this.hash = calculateHash(); // Making sure we do this after we set the other values.
	}

	public String calculateHash() {
		String calculatedhash = StringUtil.applySha256(previousHash + timeStamp + data);
		return calculatedhash;
	}
}