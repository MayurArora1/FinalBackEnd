package com.lti.airfuselage.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SeatsCompositeKey implements Serializable {
	long flightId;
	String seatId;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (flightId ^ (flightId >>> 32));
		result = prime * result + ((seatId == null) ? 0 : seatId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SeatsCompositeKey other = (SeatsCompositeKey) obj;
		if (flightId != other.flightId)
			return false;
		if (seatId == null) {
			if (other.seatId != null)
				return false;
		} else if (!seatId.equals(other.seatId))
			return false;
		return true;
	}
	
	
}
