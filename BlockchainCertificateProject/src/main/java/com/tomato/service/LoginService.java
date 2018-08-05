package com.tomato.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomato.dao.LoginDAO;
import com.tomato.dto.UserDTO;

@Service
public class LoginService {
	
	@Autowired
	LoginDAO loginDAO;

	public boolean loginCheck(UserDTO userDTO) {
		return loginDAO.loginCheck(userDTO);
	}
	
	
}
