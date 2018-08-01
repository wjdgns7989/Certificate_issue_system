package com.tomato.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tomato.email.Email;
import com.tomato.email.EmailSender;

	
	@Controller
	public class EmailController {
		
		@Autowired
		public EmailSender emailSender;

		@Autowired
		public Email email;
		
		
		@RequestMapping("/emailSender")
		public String showResult(HttpServletRequest request) throws Exception {
			String page = "cmmn/saveDataSuccess";
			String email = request.getParameter("sender");
			sendEmailToManager(email);
			return page;
	   }
	   
	   public void sendEmailToManager(String emailReceiver) throws Exception {
	        // do something
	         email.setReciver(emailReceiver);
	         email.setSubject("ssss");
	         email.setContent("aaaa");
	         emailSender.SendEmail(email);
	    }
}


