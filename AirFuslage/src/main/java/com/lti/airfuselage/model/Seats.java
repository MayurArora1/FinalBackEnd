package com.lti.airfuselage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.lti.airfuselage.dto.SeatsCompositeKeyDTO;


@Entity
@IdClass(SeatsCompositeKeyDTO.class)
@Table(name = "seats")
public class Seats {

	@Id
	@Column(name = "flight_id")
	private long flightId;

	@Id
	@Column(name = "seat_id")
	private String seatId;

	@Column(name = "passenger_id")
	private long passengerId;

	public long getFlightId() {
		return flightId;
	}

	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}

	public String getSeatId() {
		return seatId;
	}

	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}

	public long getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(long passengerId) {
		this.passengerId = passengerId;
	}

	public Seats(long flightId, String seatId, long passengerId) {
		super();
		this.flightId = flightId;
		this.seatId = seatId;
		this.passengerId = passengerId;
	}

	public Seats() {
	}

}
