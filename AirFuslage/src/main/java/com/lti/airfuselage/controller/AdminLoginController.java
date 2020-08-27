package com.lti.airfuselage.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.airfuselage.controller.AdminLoginController.Status.StatusType;
import com.lti.airfuselage.dto.AdminLoginDTO;
import com.lti.airfuselage.exception.CustomerServiceException;
import com.lti.airfuselage.model.AdminLogin;
import com.lti.airfuselage.service.AirlineService;

@RestController
@CrossOrigin
public class AdminLoginController {
	
	@Autowired
	private AirlineService service;
	
	@PostMapping("/adminlogin")
	public AdminLoginStatus Adminlogin(@RequestBody AdminLoginDTO adminloginDto) {
		try {
			AdminLogin u = service.adminlogin(adminloginDto.getEmail(), adminloginDto.getPassword());
			AdminLoginStatus adminloginStatus = new AdminLoginStatus();
			adminloginStatus.setStatus(StatusType.SUCCESS);
			adminloginStatus.setMessage("Login successful");
			adminloginStatus.setUserId(u.getId());
			adminloginStatus.setFirstName(u.getFirstName());
			adminloginStatus.setLastName(u.getLastName());
			adminloginStatus.setDateOfBirth(u.getDateOfBirth());
			adminloginStatus.setMobileNumber(u.getMobileNumber());
			return adminloginStatus;
		} catch (CustomerServiceException e) {
			AdminLoginStatus adminloginStatus = new AdminLoginStatus();
			adminloginStatus.setStatus(StatusType.FAILURE);
			adminloginStatus.setMessage(e.getMessage());
			return adminloginStatus;
		}

	}

	public static class AdminLoginStatus extends Status {

		private int id;
		private String firstName;
		private String lastName;
		private LocalDate dateOfBirth;
		private String mobileNumber;
		
		

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public LocalDate getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(LocalDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public String getMobileNumber() {
			return mobileNumber;
		}

		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}

		public int getId() {
			return id;
		}

		public void setUserId(int id) {
			this.id = id;
		}

	}

	public static class Status {
		private StatusType status;
		private String message;

		public static enum StatusType {
			SUCCESS, FAILURE;
		}

		public StatusType getStatus() {
			return status;
		}

		public void setStatus(StatusType status) {
			this.status = status;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

	}

}
