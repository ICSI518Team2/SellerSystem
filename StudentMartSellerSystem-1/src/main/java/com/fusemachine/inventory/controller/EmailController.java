package com.fusemachine.inventory.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class EmailController {
    @Autowired
    private JavaMailSender sender;
    
    @RequestMapping(value="/emailadmin")
    public String emailAdminPage(){
        return "emailadmin";
    }
    
    //@RequestMapping(value="/sendMail")
    @PostMapping("/sendMail")
    public void sendMail() {
    	System.out.println("send mail!");
    	//String recevier = "yunweijiangchn@gmail.com";
    	String recevier = "Sellitdown@gmail.com";
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setTo(recevier);
            helper.setText("My question");
            helper.setSubject("Question");
        } catch (MessagingException e) {
            e.printStackTrace();
            //return "Error while sending mail ..";
        }
        sender.send(message);
        //return "Mail Sent Success!";
    }
}
