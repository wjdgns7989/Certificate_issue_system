package com.tomato.email;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.tomato.email.Email;


@Component
public class EmailSender  {
     
    @Autowired
    private JavaMailSender mailSender;
 
    public void SendEmail(Email email) throws Exception {
         
       MimeMessage msg = mailSender.createMimeMessage();
        try {
            msg.setSubject(email.getSubject());
            msg.setText("<b>홍길동 졸업 증명서 발급<br></b> "+
                      "<a href=\"https://www.naver.com/\">인증</a>", "UTF-8", "html");
            msg.setRecipients(MimeMessage.RecipientType.TO , InternetAddress.parse(email.getReciver()));
            msg.setFrom("sejong");
            
        }catch(MessagingException e) {
            System.out.println("MessagingException");
            e.printStackTrace();
        }
        try {
            mailSender.send(msg);
        }catch(MailException e) {
            System.out.println("MailException발생");
            e.printStackTrace();
        }
    }
}