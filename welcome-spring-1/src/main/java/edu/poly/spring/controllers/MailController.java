package edu.poly.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MailController {
//	@Autowired
//	private JavaMailSender jms;
//	
//	@GetMapping("/sendMail")
//	public String sendMail() {
//		SimpleMailMessage msg = new SimpleMailMessage();
//		msg.setTo("huytpgde140306@fpt.edu.vn");
//		msg.setSubject("send mail");
//		msg.setText("mail first");
//		jms.send(msg);
//		return "result";
//	}
}
