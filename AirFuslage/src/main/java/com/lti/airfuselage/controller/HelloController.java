
package com.lti.airfuselage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.airfuselage.model.Passengers;

@RestController
public class HelloController {
	@Autowired
	private MailSender mailSender;

	// User user=new User();
	@CrossOrigin
	@RequestMapping(value = "hello", method={RequestMethod.POST})
	public @ResponseBody String hello(@RequestBody Passengers passenger) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("airfuselage@gmail.com");
		message.setTo(passenger.getEmailId());
		message.setSubject("Welcome to Air Fuselage");
		message.setText("Congratulations you have been successfully registered with Air Fuselage");
		mailSender.send(message);

		return "Welcome to Spring REST";
	}
}
