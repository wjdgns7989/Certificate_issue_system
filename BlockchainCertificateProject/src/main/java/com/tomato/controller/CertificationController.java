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
         Object obj = parser.parse(new FileReader("halin.json")); 
         JSONObject jsonObject = (JSONObject) obj;
         JSONObject dataObject = (JSONObject) jsonObject.get("certificate1"); 
         System.out.println("type : " +dataObject.get("type"));    
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