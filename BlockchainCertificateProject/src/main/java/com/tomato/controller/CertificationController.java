package com.tomato.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tomato.dto.DiplomaDTO;
import com.tomato.dto.EnrollmentDTO;
import com.tomato.dto.UserDTO;
import com.tomato.util.LoginUser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




@Controller
public class CertificationController {
   
   @RequestMapping(value = "/boxcheck.do")
   public ModelAndView boxCheck(HttpServletRequest request, UserDTO userDTO, DiplomaDTO diplomaDTO, EnrollmentDTO enrollmentDTO) {
	   System.out.println(request.getSession().getAttribute("loginOk"));
	   Map<String, String> member = LoginUser.getInstance();
	   for (String key : member.keySet()) {
			if (key.equals(userDTO.getId())) {
				if (member.get(key).equals(userDTO.getPasswd())) {
					break;
				}
			}
		}
	   ModelAndView mv = new ModelAndView(); 
	   
       String[] value = request.getParameterValues("checkbox");
       System.out.println(Arrays.toString(value));
      
       JSONParser parser = new JSONParser(); 
       try {
    	  
          Object obj = parser.parse(new FileReader("halin.json")); 
          JSONObject jsonObject = (JSONObject) obj;
          JSONObject dataObject = (JSONObject) jsonObject.get("certificate1"); 
          System.out.println("type : " +dataObject.get("type"));
          
          
          
          mv.setViewName("result");
          //mv.addObject("diploma", );
   	   	  //mv.addObject("enrollment",);
       } catch (FileNotFoundException e) { 
          e.printStackTrace(); 
       } catch (IOException e) { 
          e.printStackTrace();
       } catch (ParseException e) { 
          e.printStackTrace(); 
       }
      

      return mv;
   }
}