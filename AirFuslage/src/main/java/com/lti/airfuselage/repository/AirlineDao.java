package com.lti.airfuselage.repository;

import java.util.List;

import com.lti.airfuselage.model.FlightDetails;
import com.lti.airfuselage.model.FlightSearchDetails;
import com.lti.airfuselage.model.Flights;
import com.lti.airfuselage.model.LoginCredentials;
import com.lti.airfuselage.model.Passengers;
import com.lti.airfuselage.model.PaymentDetails;
import com.lti.airfuselage.model.SeatInfo;
import com.lti.airfuselage.model.Tickets;
import com.lti.airfuselage.model.User;

public interface AirlineDao {
	public long insertUser(User user);
	public long fetchCredentials(LoginCredentials credential);
	public List<Flights> fetchFlights(FlightSearchDetails details);
	public List<String> fetchSeats(long flightId);
	public int fetchPaymentConfirmation(PaymentDetails details);
	public int bookTicket(Tickets details);
	public void bookSeats(SeatInfo seatDetails);
	public List<Tickets> fetchTicket(long userId);
	public Passengers fetchUser(long userId);
	public int addFlights(FlightDetails details);
	public int removeFlight(long flightId);
	public List<String> fetchUserBookedSeats(long flightId, long userId);
	public int cancelTicket(long ticketNumber);
}
