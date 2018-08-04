package com.tomato.dto;

import org.springframework.stereotype.Repository;

@Repository
public class UserDTO {
	String id;
	String passwd;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}
