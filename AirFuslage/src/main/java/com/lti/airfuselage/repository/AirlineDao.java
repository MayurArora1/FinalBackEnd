package com.lti.airfuselage.repository;

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


public interface AirlineDao {
	public long insertUser(UserDTO user);
	public long fetchCredentials(LoginCredentialsDTO credential);
	public List<Flights> fetchFlights(FlightSearchDetailsDTO details);
	public List<String> fetchSeats(long flightId);
	public int fetchPaymentConfirmation(PaymentDetails details);
	public int bookTicket(Tickets details);
	public void bookSeats(SeatInfoDTO seatDetails);
	public List<Tickets> fetchTicket(long userId);
	public Passengers fetchUser(long userId);
	public int addFlights(FlightDetailsDTO details);
	public int removeFlight(long flightId);
	public List<String> fetchUserBookedSeats(long flightId, long userId);
	public int cancelTicket(long ticketNumber);
	void addAdmin(AdminLogin admin);
	int adminlogin(String email, String password);
	AdminLogin findByadminId(int id);
	void addCard(PaymentDetails details);
}
