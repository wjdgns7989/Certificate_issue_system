package com.tomato.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.tomato.dto.UserDTO;
import com.tomato.util.LoginUser;

@Repository
public class LoginDAO {

	public boolean loginCheck(UserDTO userDTO) {
		boolean loginOk = false;
		Map<String, String> member = LoginUser.getInstance();
		//id와 passwd를 확인한다. 
		for (String key : member.keySet()) {
			if (key.equals(userDTO.getId())) {
				if (member.get(key).equals(userDTO.getPasswd())) {
					loginOk = true;
					break;
				}
			}
		}
		return loginOk;
	}

}
