package com.tomato.util;

import java.util.ArrayList;

import com.google.gson.GsonBuilder;
import com.tomato.dto.BlockDTO;

public class NoobChain {

	public static ArrayList<BlockDTO> blockchain = new ArrayList<BlockDTO>();

	public static void main(String[] args) {

		blockchain.add(new BlockDTO("Hi im the first block", "0","aa"));
		blockchain.add(new BlockDTO("Yo im the second block", blockchain.get(blockchain.size() - 1).hash,"ss"));
		blockchain.add(new BlockDTO("Hey im the third block", blockchain.get(blockchain.size() - 1).hash,"ss"));

		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
		System.out.println(blockchainJson);
	}

}