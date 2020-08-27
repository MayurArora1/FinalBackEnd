package com.lti.airfuselage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("tickets")
@Scope(scopeName="prototype")
@Entity
@Table(name="tickets")
public class Tickets {
	@Id
	@SequenceGenerator(name = "ticket_number_seq",allocationSize = 1,initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ticket_number_seq")
	@Column(name = "ticket_number")
	private long ticketNumber;
	
	@Column(name = "passenger_id")
	private long passengerId;
	
	@OneToOne
	@Transient
	@PrimaryKeyJoinColumn(name="passenger_id", referencedColumnName="user_id")
	private Credentials credential;
	
	@Column(name = "flight_id")
	private long flightId;
	
	@OneToOne
	@PrimaryKeyJoinColumn(name="flight_id", referencedColumnName="flight_id")
	private Flights flight;
	
	@Column(name="source")
	private String source;
	
	@Column(name="destination")
	private String destination;
	
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

	@Column(name="departure_date")
	private String departureDate;
	
	@Column(name="departure_time")
	private String departureTime;
	
	@Column(name="airport_name")
	private String airportName;
	
	@Column(name="class")
	private String travelClass;
	
	@Column(name="number_of_tickets")
	private int numberOfTickets;
	
	@Column(name="total_cost")
	private double totalCost;
	
	@Column(name="status")
	private String status;

	public Tickets() {}

	public Tickets(long passengerId, Credentials credential, long flightId, Flights flight, String departureDate,
			String departureTime, String airportName, String travelClass, int numberOfTickets, double totalCost,
			String status) {
		super();
		this.passengerId = passengerId;
		this.credential = credential;
		this.flightId = flightId;
		this.flight = flight;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.airportName = airportName;
		this.travelClass = travelClass;
		this.numberOfTickets = numberOfTickets;
		this.totalCost = totalCost;
		this.status = status;
	}

	public long getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(long ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public long getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(long passengerId) {
		this.passengerId = passengerId;
	}

	public Credentials getCredential() {
		return credential;
	}

	public void setCredential(Credentials credential) {
		this.credential = credential;
	}

	public long getFlightId() {
		return flightId;
	}

	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}

	public Flights getFlight() {
		return flight;
	}

	public void setFlight(Flights flight) {
		this.flight = flight;
	}

	public String getdepartureDate() {
		return departureDate;
	}

	public void setdepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getTravelClass() {
		return travelClass;
	}

	public void setTravelClass(String travelClass) {
		this.travelClass = travelClass;
	}

	public int getNumberOfTickets() {
		return numberOfTickets;
	}

	public void setNumberOfTickets(int numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}

