package com.lti.airfuselage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("flights")
@Scope(scopeName="prototype")
@Entity
@Table(name="flights")
public class Flights {
	
	@Id
	@SequenceGenerator(name = "flight_id_seq", allocationSize = 1, initialValue = 100)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flight_id_seq")
	@Column(name = "flight_id")
	private long flightId;
	
	@Column(name="airline_name")
	private String airlineName;
	
	@Column(name="airport_name")
	private String airportName;
	
	@Column(name="source")
	private String source;
	
	@Column(name="destination")
	private String destination;
	
	@Column(name="departure_date")
	private String departureDate;
	
	@Column(name="departure_time")
	private String departureTime;
	
	@Column(name="arrival_time")
	private String arrivalTime;
	
	@Column(name="duration")
	private String duration;
	
	@Column(name="total_seats")
	private int totalSeats;
	
	@Column(name="available_seats")
	private int availableSeats;
	
	@Column(name="base_price")
	private int basePrice;
	
	public Flights() {}

	public Flights(String airlineName, String airportName, String source, String destination, String departureDate,
			String departureTime, String arrivalTime, String duration, int totalSeats, int availableSeats,
			int basePrice) {
		super();
		this.airlineName = airlineName;
		this.airportName = airportName;
		this.source = source;
		this.destination = destination;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.duration = duration;
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
		this.basePrice = basePrice;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public int getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}

	public long getFlightId() {
		return flightId;
	}

	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}
	
}
