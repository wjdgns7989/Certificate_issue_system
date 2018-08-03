package com.tomato.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CertificationController {

	@RequestMapping(value = "/boxcheck.do")
	String boxCheck(HttpServletRequest request) {
		String[] value = request.getParameterValues("checkbox");
		System.out.println(Arrays.toString(value));
		return "result";
	}
}
