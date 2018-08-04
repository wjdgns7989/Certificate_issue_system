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
            msg.setText("<h2>CSS Layout Float</h2>\r\n" + 
                  "<p>In this example, we have created a header, two columns/boxes and a footer. On smaller screens, the columns will stack on top of each other.</p>\r\n" + 
                  "<p>Resize the browser window to see the responsive effect (you will learn more about this in our next chapter - HTML Responsive.)</p>\r\n" + 
                  "\r\n" + 
                  "<header>\r\n" + 
                  "  <h2>Cities</h2>\r\n" + 
                  "</header>\r\n" + 
                  "\r\n" + 
                  "<section>\r\n" + 
                  "  <nav>\r\n" + 
                  "    <ul>\r\n" + 
                  "      <li><a href=\"#\">London</a></li>\r\n" + 
                  "      <li><a href=\"#\">Paris</a></li>\r\n" + 
                  "      <li><a href=\"#\">Tokyo</a></li>\r\n" + 
                  "    </ul>\r\n" + 
                  "  </nav>\r\n" + 
                  "  \r\n" + 
                  "  <article style=\"float: left;\r\n" + 
                  "    padding: 20px;\r\n" + 
                  "    width: 70%;\r\n" + 
                  "    background-color: #f1f1f1;\r\n" + 
                  "    height: 300px;\">\r\n" + 
                  "    <h1>London</h1>\r\n" + 
                  "    <p>London is the capital city of England. It is the most populous city in the  United Kingdom, with a metropolitan area of over 13 million inhabitants.</p>\r\n" + 
                  "    <p>Standing on the River Thames, London has been a major settlement for two millennia, its history going back to its founding by the Romans, who named it Londinium.</p>\r\n" + 
                  "  </article>\r\n" + 
                  "</section>\r\n" + 
                  "\r\n" + 
                  "<footer>\r\n" + 
                  "  <p>Footer</p>\r\n" + 
                  "</footer>", "UTF-8", "html");
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