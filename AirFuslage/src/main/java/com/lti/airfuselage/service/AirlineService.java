package com.lti.airfuselage.service;

import java.util.List;

import com.lti.airfuselage.model.AdminLogin;
import com.lti.airfuselage.model.FlightDetails;
import com.lti.airfuselage.model.FlightSearchDetails;
import com.lti.airfuselage.model.Flights;
import com.lti.airfuselage.model.LoginCredentials;
import com.lti.airfuselage.model.Passengers;
import com.lti.airfuselage.model.PaymentDetails;
import com.lti.airfuselage.model.SeatInfo;
import com.lti.airfuselage.model.Tickets;
import com.lti.airfuselage.model.User;

public interface AirlineService {
	public long registerUser(User user);
	public long getUser(LoginCredentials credential);
	public List<Flights> getFlightDetails(FlightSearchDetails details);
	public List<String> getBookedSeats(long flightId);
	public int getPaymentConfirmation(PaymentDetails details);
	public int bookTicket(Tickets details);
	public void bookSeats(SeatInfo seatDetails);
	public List<Tickets> getTicket(long userId);
	public Passengers getUser(long userId);
	public int addFlightDetails(FlightDetails details);
	public int deleteFlight(long flightId);
	public List<String> getUserBookedSeats(long flightId, long userId);
	public int cancelTicket(long ticketNumber);
	AdminLogin adminlogin(String email, String password);
}
