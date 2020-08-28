package com.lti.airfuselage.service;

import java.util.List;

import com.lti.airfuselage.dto.FlightDetailsDTO;
import com.lti.airfuselage.dto.FlightSearchDetailsDTO;
import com.lti.airfuselage.dto.LoginCredentialsDTO;
import com.lti.airfuselage.dto.SeatInfoDTO;
import com.lti.airfuselage.dto.UserDTO;
import com.lti.airfuselage.model.AdminLogin;
import com.lti.airfuselage.model.Flights;
import com.lti.airfuselage.model.Passengers;
import com.lti.airfuselage.model.PaymentDetails;
import com.lti.airfuselage.model.Tickets;


public interface AirlineService {
	public long registerUser(UserDTO user);
	public long getUser(LoginCredentialsDTO credential);
	public List<Flights> getFlightDetails(FlightSearchDetailsDTO details);
	public List<String> getBookedSeats(long flightId);
	public int getPaymentConfirmation(PaymentDetails details);
	public int bookTicket(Tickets details);
	public void bookSeats(SeatInfoDTO seatDetails);
	public List<Tickets> getTicket(long userId);
	public Passengers getUser(long userId);
	public int addFlightDetails(FlightDetailsDTO details);
	public int deleteFlight(long flightId);
	public List<String> getUserBookedSeats(long flightId, long userId);
	public int cancelTicket(long ticketNumber);
	AdminLogin adminlogin(String email, String password);
}
