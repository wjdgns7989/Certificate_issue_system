package com.tomato.service;
import java.util.HashMap;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.tomato.dto.DiplomaDTO;
import com.tomato.dto.EmailDTO;
import com.tomato.dto.EnrollmentDTO;


@Component
public class EmailService  {
     
    @Autowired
    private JavaMailSender mailSender;
    
    public String checkEmailNULL(EnrollmentDTO enrollment, DiplomaDTO diploma)
    {
       if(enrollment==null)
       {
          return "Diploma";
       }
       else if(diploma==null)
       {
          return "Enrollment";
       }
       return "All";
    }
 
    public void SendEmail(EmailDTO email, EnrollmentDTO enrollment, DiplomaDTO diploma, String time) throws Exception {
         
       MimeMessage msg = mailSender.createMimeMessage();
       Gson gson=new Gson();
       
        try {
            msg.setSubject(email.getSubject());
            if(checkEmailNULL(enrollment, diploma)=="Diploma")
            {
               String DiplomaResult=gson.toJson(diploma);
               //System.out.println(DiplomaResult);
               msg.setText(
                     "<section>\r\n" + 
                     "  <article style=\"float: left;  padding: 20px; width: 40%; border: 0.5px solid black; height: 50%;\">\r\n" + 
                     "      <a href=\"http://www.sejong.ac.kr\" > <img src=\"http://sejong.ac.kr/img/common/h1_top_logo01.gif\" alt=\"Sejong\" height=\"25%\" width=\"25%\">      </a>\r\n" + 
                     "\r\n" + 
                     "        <h1>" + diploma.getName()+ " / " + diploma.getMajor() + "</h1>\r\n" + 
                     "        <hr>\r\n" + 
                     "        <p style=\"font-weight:bold; display:inline; font-size:12px\">전화 : </p>\r\n" + 
                     "        <p style=\"display:inline; font-size:12px\">02-3408-3114</p>\r\n" + 
                     "        <br>\r\n" + 
                     "        <p style=\"font-weight:bold; display:inline; font-size:12px\">FAX : </p>\r\n" + 
                     "        <a style=\"background-color: #00B4DB; color: white; padding: 8px 25px; text-align: center; text-decoration: none; display: inline-block; float:right; font-weight:bold;\" href=\'http://localhost:8080/blockchain/certification.do/diploma/" + DiplomaResult + "/enrollment/null/time/" + time + "\'>인증</a>\r\n" + 
                     "\r\n" + 
                     "        <p style=\"display:inline; font-size:12px\">02-6935-2419</p>\r\n" + 
                     "        <br>\r\n" + 
                     "        <p style=\"font-weight:bold; display:inline; font-size:12px\">E-mail : </p>\r\n" + 
                     "        <p style=\"display:inline; font-size:12px\">sw6@sejong.ac.kr</p>\r\n" + 
                     "\r\n" + 
                     "  </article>\r\n" + 
                     "</section>"
                                , "UTF-8", "html");
            }
            
            else if(checkEmailNULL(enrollment, diploma)=="Enrollment")
            {
               String EnrollmentResult=gson.toJson(enrollment);
               System.out.println(EnrollmentResult);
               msg.setText(    
            		   "<section>\r\n" + 
                               "  <article style=\"float: left;  padding: 20px; width: 40%; border: 0.5px solid black; height: 50%;\">\r\n" + 
                               "      <a href=\"http://www.sejong.ac.kr\" > <img src=\"http://sejong.ac.kr/img/common/h1_top_logo01.gif\" alt=\"Sejong\" height=\"25%\" width=\"25%\">      </a>\r\n" + 
                               "\r\n" + 
                               "        <h1>" + enrollment.getName()+ " / " + enrollment.getMajor() + "</h1>\r\n" + 
                               "        <hr>\r\n" + 
                               "        <p style=\"font-weight:bold; display:inline; font-size:12px\">전화 : </p>\r\n" + 
                               "        <p style=\"display:inline; font-size:12px\">02-3408-3114</p>\r\n" + 
                               "        <br>\r\n" + 
                               "        <p style=\"font-weight:bold; display:inline; font-size:12px\">FAX : </p>\r\n" + 
                               "        <a style=\"background-color: #00B4DB; color: white; padding: 8px 25px; text-align: center; text-decoration: none; display: inline-block; float:right; font-weight:bold;\" href=\'http://localhost:8080/blockchain/certification.do/diploma/null/enrollment/" + EnrollmentResult + "/time/" + time + "\'>인증</a>\r\n" +
                               "\r\n" + 
                               "        <p style=\"display:inline; font-size:12px\">02-6935-2419</p>\r\n" + 
                               "        <br>\r\n" + 
                               "        <p style=\"font-weight:bold; display:inline; font-size:12px\">E-mail : </p>\r\n" + 
                               "        <p style=\"display:inline; font-size:12px\">sw6@sejong.ac.kr</p>\r\n" + 
                               "\r\n" + 
                               "  </article>\r\n" + 
                               "</section>"
                               , "UTF-8", "html");
            }
            else
            {
               String EnrollmentResult=gson.toJson(enrollment);
               String DiplomaResult=gson.toJson(diploma);
               
               msg.setText(    
            		   "<section>\r\n" + 
                               "  <article style=\"float: left;  padding: 20px; width: 40%; border: 0.5px solid black; height: 50%;\">\r\n" + 
                               "      <a href=\"http://www.sejong.ac.kr\" > <img src=\"http://sejong.ac.kr/img/common/h1_top_logo01.gif\" alt=\"Sejong\" height=\"25%\" width=\"25%\">      </a>\r\n" + 
                               "\r\n" + 
                               "        <h1>" + enrollment.getName()+ " / " + enrollment.getMajor() + "</h1>\r\n" + 
                               "        <hr>\r\n" + 
                               "        <p style=\"font-weight:bold; display:inline; font-size:12px\">전화 : </p>\r\n" + 
                               "        <p style=\"display:inline; font-size:12px\">02-3408-3114</p>\r\n" + 
                               "        <br>\r\n" + 
                               "        <p style=\"font-weight:bold; display:inline; font-size:12px\">FAX : </p>\r\n" + 
                               "        <a style=\"background-color: #00B4DB; color: white; padding: 8px 25px; text-align: center; text-decoration: none; display: inline-block; float:right; font-weight:bold;\" href=\'http://localhost:8080/blockchain/certification.do/diploma/"+ DiplomaResult +"/enrollment/" + EnrollmentResult + "/time/" + time + "\'>인증</a>\r\n" +
                               "\r\n" + 
                               "        <p style=\"display:inline; font-size:12px\">02-6935-2419</p>\r\n" + 
                               "        <br>\r\n" + 
                               "        <p style=\"font-weight:bold; display:inline; font-size:12px\">E-mail : </p>\r\n" + 
                               "        <p style=\"display:inline; font-size:12px\">sw6@sejong.ac.kr</p>\r\n" + 
                               "\r\n" + 
                               "  </article>\r\n" + 
                               "</section>"
                        , "UTF-8", "html");
            }
            
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