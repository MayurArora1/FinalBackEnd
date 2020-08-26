package com.lti.airfuselage.model;

public class FlightSearchDetails {
	private String source;
	private String destination;
	private  String destinationDate;
	private int seats;
	
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
	public String getDestinationDate() {
		return destinationDate;
	}
	public void setDestinationDate(String destinationDate) {
		this.destinationDate = destinationDate;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
}
