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
	 
			Object obj1 = parser.parse(new FileReader("halin.json"));
			Object obj2 = parser.parse(new FileReader("halin.json"));
	 
			JSONObject jsonObject1 = (JSONObject) obj1;
			JSONObject jsonObject2 = (JSONObject) obj2;
	 
			JSONObject name = (JSONObject) jsonObject1.get("재학");
			JSONObject temp = (JSONObject) jsonObject2.get("이름");
			
			
			System.out.println(temp);
	 
			
			
	 
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
