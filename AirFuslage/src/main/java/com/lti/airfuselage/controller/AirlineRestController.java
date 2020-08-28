package com.lti.airfuselage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lti.airfuselage.dto.FlightDetailsDTO;
import com.lti.airfuselage.dto.FlightSearchDetailsDTO;
import com.lti.airfuselage.model.Flights;
import com.lti.airfuselage.service.AirlineService;

@Controller
@RequestMapping("/")
@CrossOrigin
public class AirlineRestController {

	@Autowired
	private AirlineService service;

	
	// http://localhost:9090/search
	@RequestMapping(path = "search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Flights> getFlights(@RequestBody FlightSearchDetailsDTO details) {
		List<Flights> result = service.getFlightDetails(details);
		return result;
	}

	// http://localhost:9090/addFlight
	@RequestMapping(path = "addFlight", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody int addFlight(@RequestBody FlightDetailsDTO details) {
		int result = service.addFlightDetails(details);
		return result;
	}

	// http://localhost:9090/deleteFlight/{flightId}
	@RequestMapping(path = "deleteFlight/{flightId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody int deleteFlight(@PathVariable("flightId") long flightId) {
		return service.deleteFlight(flightId);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex) {
		ResponseEntity<String> error = new ResponseEntity<String>("Error: " + ex.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR);
		return error;
	}

}
