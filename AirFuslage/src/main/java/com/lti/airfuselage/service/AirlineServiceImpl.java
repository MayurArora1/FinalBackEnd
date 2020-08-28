package com.lti.airfuselage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.airfuselage.dto.FlightDetailsDTO;
import com.lti.airfuselage.dto.FlightSearchDetailsDTO;
import com.lti.airfuselage.dto.LoginCredentialsDTO;
import com.lti.airfuselage.dto.SeatInfoDTO;
import com.lti.airfuselage.dto.UserDTO;
import com.lti.airfuselage.exception.CustomerServiceException;
import com.lti.airfuselage.model.AdminLogin;
import com.lti.airfuselage.model.Flights;
import com.lti.airfuselage.model.Passengers;
import com.lti.airfuselage.model.PaymentDetails;
import com.lti.airfuselage.model.Tickets;
import com.lti.airfuselage.repository.AirlineDao;

@Service("service")
@Scope(scopeName="singleton")
public class AirlineServiceImpl implements AirlineService {
	
	@Autowired
	private AirlineDao dao;

	public long registerUser(UserDTO user) {
		return dao.insertUser(user);
	}

	public long getUser(LoginCredentialsDTO credential) {
		return dao.fetchCredentials(credential);
	}

	public List<Flights> getFlightDetails(FlightSearchDetailsDTO details) {
		return dao.fetchFlights(details);
	}

	public List<String> getBookedSeats(long flightId) {
		return dao.fetchSeats(flightId);
	}

	public int getPaymentConfirmation(PaymentDetails details) {
		return dao.fetchPaymentConfirmation(details);
	}

	public int bookTicket(Tickets details) {
		return dao.bookTicket(details);
	}

	public void bookSeats(SeatInfoDTO seatDetails) {
		dao.bookSeats(seatDetails);
	}

	public List<Tickets> getTicket(long userId) {
		return dao.fetchTicket(userId);		
	}

	public Passengers getUser(long userId) {
		return dao.fetchUser(userId);
	}

	public int addFlightDetails(FlightDetailsDTO details) {
		return dao.addFlights(details);
	}

	public int deleteFlight(long flightId) {
		return dao.removeFlight(flightId);
	}

	public List<String> getUserBookedSeats(long flightId, long userId) {
		return dao.fetchUserBookedSeats(flightId, userId);
	}

	public int cancelTicket(long ticketNumber) {
		return dao.cancelTicket(ticketNumber);
	}
	
	@Override
    public AdminLogin adminlogin(String email, String password) {
        try {
            int userId = dao.adminlogin(email, password);
            AdminLogin u = dao.findByadminId(userId);
            return u;
        } catch (EmptyResultDataAccessException e) {
            throw new CustomerServiceException("Incorrect username/password");
        }
    }
}