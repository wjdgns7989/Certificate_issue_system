package com.tomato.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




@Controller
public class CertificationController {

	@RequestMapping(value = "/boxcheck.do")
	String boxCheck(HttpServletRequest request) {
		String[] value = request.getParameterValues("checkbox");
		System.out.println(Arrays.toString(value));
		
		JSONParser parser = new JSONParser();
		try {
	 
			Object obj = parser.parse(new FileReader("BlockchainCertificateProject\\src\\main\\webapp\\resources\\json\\user1.json"));
	 
			JSONObject jsonObject = (JSONObject) obj;
	 
			String name = (String) jsonObject.get("name");
			System.out.println(name);
	 
			long age = (Long) jsonObject.get("age");
			System.out.println(age);
	 
			// loop array
			JSONArray msg = (JSONArray) jsonObject.get("messages");
			Iterator<String> iterator = msg.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
	 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	 
	     


	
		
		return "result";
	}
}
