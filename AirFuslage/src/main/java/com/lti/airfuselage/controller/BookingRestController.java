package com.lti.airfuselage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lti.airfuselage.dto.SeatInfoDTO;
import com.lti.airfuselage.model.PaymentDetails;
import com.lti.airfuselage.model.Tickets;
import com.lti.airfuselage.service.AirlineService;

@Controller
@RequestMapping("/")
@CrossOrigin
public class BookingRestController {
	
	@Autowired
	private AirlineService service;
	
	// http://localhost:9090/payment
		@RequestMapping(path = "payment", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody PaymentDetails getPaymentConfirmation(@RequestBody PaymentDetails details) {

			PaymentDetails response;
			int result = service.getPaymentConfirmation(details);
			if (result == 1) {
				response = new PaymentDetails();
			} else {
				response = null;
			}
			return response;
		}

		// http://localhost:9090/book
		@RequestMapping(path = "book", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody int bookTicket(@RequestBody Tickets details) {
			int result = service.bookTicket(details);
			return result;
		}

		// http://localhost:9090/seats
		@RequestMapping(path = "seats", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody void bookSeats(@RequestBody SeatInfoDTO seatDetails) {
			service.bookSeats(seatDetails);
		}

		// http://localhost:9090/seats/{flightId}
		@RequestMapping(path = "seats/{flightId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody List<String> getBookedSeats(@PathVariable("flightId") long flightId) {
			List<String> result = service.getBookedSeats(flightId);
			return result;
		}

		// http://localhost:9090/userSeats/{flightId}/{userId}
		@RequestMapping(path = "userSeats/{flightId}/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody List<String> getUserBookedSeats(@PathVariable("flightId") long flightId,
				@PathVariable("userId") long userId) {
			List<String> result = service.getUserBookedSeats(flightId, userId);
			return result;
		}

		// http://localhost:9090/ticket/{userId}
		@RequestMapping(path = "ticket/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody List<Tickets> getTicket(@PathVariable("userId") long userId) {
			return service.getTicket(userId);
		}
		
		// http://localhost:9090/cancel/{ticketNumber}
		@RequestMapping(path = "cancel/{ticketNumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody int cancelTicket(@PathVariable("ticketNumber") long ticketNumber) {
			return service.cancelTicket(ticketNumber);
		}

}
