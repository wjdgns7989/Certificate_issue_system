package com.tomato.util;
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
public class EmailSender  {
     
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
 
    public void SendEmail(EmailDTO email, EnrollmentDTO enrollment, DiplomaDTO diploma) throws Exception {
         
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
                                "  <article style=\"float: left;\r\n" + 
                                "    padding: 20px;\r\n" + 
                                "    width: 70%;\r\n" + 
                                "    border: 3px solid black;\r\n" +
                                "    background-color: #f1f1f1;\r\n" + 
                                "    height: 50%;\">\r\n" + 
                                "    <h1 style=\"font-size:22px\">" + diploma.getName() + " " + diploma.getType() +"</h1><br><br><br>\r\n" + 
                                "    <p style=\"font-size:18px; \">증명서를 확인해주세요.</p>\r\n" + 
                                "    <a href=\"http://localhost:8080/blockchain/certification.do/diploma/" + DiplomaResult +"/enrollment/null\">인증</a>\r\n" +
                                "    <input type=\"submit\" value=\"인증\" style=\"background-color: gray;\r\n" + 
                                "    border: none;\r\n" + 
                                "    color: white;\r\n" + 
                                "    padding: 16px 32px;\r\n" + 
                                "    text-decoration: none;\r\n" + 
                                "    margin: 4px 2px;\r\n" + 
                                "    cursor: pointer; \">" +
                                "  </article>\r\n" + 
                                "</section>\r\n"
                                , "UTF-8", "html");
            }
            else if(checkEmailNULL(enrollment, diploma)=="Enrollment")
            {
               String EnrollmentResult=gson.toJson(enrollment);
               System.out.println(EnrollmentResult);
               msg.setText(    
                      "<section>\r\n" + 
                        "  <article style=\"float: left;\r\n" + 
                        "    padding: 20px;\r\n" + 
                        "    width: 70%;\r\n" + 
                        "    border: 3px solid black;\r\n" +
                        "    background-color: #f1f1f1;\r\n" + 
                        "    height: 50%;\">\r\n" + 
                        "    <h1 style=\"font-size:22px\">" + enrollment.getName() + " " + enrollment.getType() +"</h1><br><br><br>\r\n" + 
                        "    <p style=\"font-size:18px; \">증명서를 확인해주세요.</p>\r\n" + 
                        "    <a href=\'http://localhost:8080/blockchain/certification.do/diploma/null/enrollment/" + EnrollmentResult + "\'>인증</a>\r\n" +
                        "    <input type=\"submit\" value=\"인증\" style=\"background-color: gray;\r\n" + 
                        "    border: none;\r\n" + 
                        "    color: white;\r\n" + 
                        "    padding: 16px 32px;\r\n" + 
                        "    text-decoration: none;\r\n" + 
                        "    margin: 4px 2px;\r\n" + 
                        "    cursor: pointer; \">" +
                        "  </article>\r\n" + 
                        "</section>\r\n", "UTF-8", "html");
            }
            else
            {
               String EnrollmentResult=gson.toJson(enrollment);
               String DiplomaResult=gson.toJson(diploma);
               
               msg.setText(    
                      "<section>\r\n" + 
                        "  <article style=\"float: left;\r\n" + 
                        "    padding: 20px;\r\n" + 
                        "    width: 70%;\r\n" + 
                        "    border: 3px solid black;\r\n" +
                        "    background-color: #f1f1f1;\r\n" + 
                        "    height: 50%;\">\r\n" + 
                        "    <h1 style=\"font-size:22px\">" + enrollment.getName() + " " + enrollment.getType() +"</h1><br><br><br>\r\n" + 
                        "    <p style=\"font-size:18px; \">증명서를 확인해주세요.</p>\r\n" + 
                        "    <a href=\"http://localhost:8080/blockchain/certification.do/diploma/" + DiplomaResult + "/enrollment/" + EnrollmentResult + "\">인증</a>\r\n" +
                        "    <input type=\"submit\" value=\"인증\" style=\"background-color: gray;\r\n" + 
                        "    border: none;\r\n" + 
                        "    color: white;\r\n" + 
                        "    padding: 16px 32px;\r\n" + 
                        "    text-decoration: none;\r\n" + 
                        "    margin: 4px 2px;\r\n" + 
                        "    cursor: pointer; \">" +
                        "  </article>\r\n" + 
                        "</section>\r\n" +
                        
                        "<section>\r\n" + 
                        "  <article style=\"float: left;\r\n" + 
                        "    padding: 20px;\r\n" + 
                        "    width: 70%;\r\n" + 
                        "    border: 3px solid black;\r\n" +
                        "    background-color: #f1f1f1;\r\n" + 
                        "    height: 50%;\">\r\n" + 
                        "    <h1 style=\"font-size:22px\">" + diploma.getName() + " " + diploma.getType() +"</h1><br><br><br>\r\n" + 
                        "    <p style=\"font-size:18px; \">증명서를 확인해주세요.</p>\r\n" + 
                        "    <a href=\"http://localhost:8080/blockchain/certification.do/diploma/" + DiplomaResult + "/enrollment/" + EnrollmentResult + "\">인증</a>\r\n" +
                        "    <input type=\"submit\" value=\"인증\" style=\"background-color: gray;\r\n" + 
                        "    border: none;\r\n" + 
                        "    color: white;\r\n" + 
                        "    padding: 16px 32px;\r\n" + 
                        "    text-decoration: none;\r\n" + 
                        "    margin: 4px 2px;\r\n" + 
                        "    cursor: pointer; \">" +
                        "  </article>\r\n" + 
                        "</section>\r\n"
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