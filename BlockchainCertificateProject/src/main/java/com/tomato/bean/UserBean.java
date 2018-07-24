package com.tomato.bean;

import org.springframework.stereotype.Component;

@Component
public class UserBean {
    String username;
    String password;
    String nickname;
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }
    public void setNickname(String nickname){
        this.nickname = nickname;
    }
    public String getNickname(){
        return nickname;
    }
}
