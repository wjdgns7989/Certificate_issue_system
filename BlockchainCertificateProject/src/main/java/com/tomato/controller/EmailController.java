package com.tomato.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tomato.dto.DiplomaDTO;
import com.tomato.dto.EmailDTO;
import com.tomato.dto.EnrollmentDTO;
import com.tomato.service.EmailService;

@Controller
public class EmailController {

	@Autowired
	public EmailService emailSender;

	@Autowired
	public EmailDTO email;

	@RequestMapping("/emailSender")
	public String showResult(HttpServletRequest request) throws Exception {
		String page = "cmmn/saveDataSuccess";
		String email = request.getParameter("sender");
		EnrollmentDTO enrollment = (EnrollmentDTO) request.getSession().getAttribute("enrollment");
		DiplomaDTO diploma = (DiplomaDTO) request.getSession().getAttribute("diploma");
		String time = (String) request.getSession().getAttribute("time");

		sendEmailToManager(email, enrollment, diploma, time);
		request.getSession().invalidate();
		return page;
	}

	public void sendEmailToManager(String emailReceiver, EnrollmentDTO enrollment, DiplomaDTO diploma, String time)
			throws Exception {
		// do something
		email.setReciver(emailReceiver);
		email.setSubject("세종대학교 증명 발급 신청");
		emailSender.SendEmail(email, enrollment, diploma, time);
	}
}
