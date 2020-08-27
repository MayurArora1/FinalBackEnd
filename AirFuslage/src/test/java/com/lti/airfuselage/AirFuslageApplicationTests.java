package com.lti.airfuselage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.lti.airfuselage.model.AdminLogin;
import com.lti.airfuselage.model.FlightDetails;
import com.lti.airfuselage.model.PaymentDetails;
import com.lti.airfuselage.repository.AirlineDao;

@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@SpringBootTest
class AirFuslageApplicationTests {

	@Autowired
	private AirlineDao dao;

	@Test
	void addFlight() {

		FlightDetails f = new FlightDetails();
		f.setAirlineName("Airfuslage");
		f.setAirportName("Indira Gandhi");
		f.setSource("Mumbai");
		f.setDestination("Bangalore");
		f.setDepartureDate("01-11-2020");
		f.setDepartureTime("11:30");
		f.setArrivalTime("12:30");
		f.setDuration("1");
		f.setBasePrice(2500);

		System.out.println(dao.addFlights(f));
	}

	@Test
	void addAdmin() {
		AdminLogin admin = new AdminLogin();
		admin.setEmail("admin@lti");
		admin.setPassword("Admin");
		dao.addAdmin(admin);;
	}
	
	@Test
	void addCard() {
		PaymentDetails p=new PaymentDetails();
		p.setCardNumber(1122334455);
		p.setCvv(12);
		p.setExpiryDate("12/23");
		p.setAccountBalance(50000000);
		dao.addCard(p);
		
	}

}
