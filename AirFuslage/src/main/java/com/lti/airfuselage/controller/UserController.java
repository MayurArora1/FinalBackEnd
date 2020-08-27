package com.lti.airfuselage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lti.airfuselage.model.LoginCredentials;
import com.lti.airfuselage.model.Passengers;
import com.lti.airfuselage.model.User;
import com.lti.airfuselage.service.AirlineService;

@Controller
@RequestMapping("/")
@CrossOrigin
public class UserController {

	@Autowired
	private AirlineService service;

	// http://localhost:9090/
	@RequestMapping(path = "register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody long registerPassenger(@RequestBody User user) {
		long result = service.registerUser(user);
		return result;
	}

	// http://localhost:9090/{userId}
	@RequestMapping(path = "{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Passengers getUser(@PathVariable("userId") long userId) {
		Passengers result = service.getUser(userId);
		return result;
	}

	// http://localhost:9090/login
	@RequestMapping(path = "login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody long getCredentials(@RequestBody LoginCredentials credential) {
		long result = service.getUser(credential);
		System.out.println(result);
		return result;
	}
}