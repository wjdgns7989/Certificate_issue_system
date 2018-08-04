package com.tomato.controller;

import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.tomato.dto.UserDTO;
import com.tomato.util.LoginUser;

@Controller
public class LoginController {

	// index페이지 요청
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}

	// login 화면 요청
	@RequestMapping(value = "/loginPage.do", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	// 로그인 확인
	@RequestMapping(value = "/loginCheck.do", method = RequestMethod.POST)
	public ModelAndView loginCheck(UserDTO userDTO, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Map<String, String> member = LoginUser.getInstance();
		boolean loginOk = false;
		for (String key : member.keySet()) {
			System.out.println(member.get(key) + userDTO.getId());
			if (key.equals(userDTO.getId())) {
				if (member.get(key).equals(userDTO.getPasswd())) {
					loginOk = true;
					// 로그인 세션추가
					session.setAttribute("loginOk", userDTO.getId());
					break;
				}

			}
		}
		if (loginOk) {
			mv.setViewName("check");
		} 
		//로그인 실패 시 첫 화면으로 리턴한다.
		else {
			mv.setViewName("login");
			mv.addObject("login", false);
		}
		return mv;
	}
}
