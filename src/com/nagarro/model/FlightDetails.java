package com.nagarro.model;

public class FlightDetails {
	private String flightNo,depLoc,arrLoc,validTill,flightTime,travelClass,seatAvailability,flightDur;
	private int fare;
	
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getDepLoc() {
		return depLoc;
	}
	public void setDepLoc(String depLoc) {
		this.depLoc = depLoc;
	}
	public String getArrLoc() {
		return arrLoc;
	}
	public void setArrLoc(String arrLoc) {
		this.arrLoc = arrLoc;
	}
	public String getValidTill() {
		return validTill;
	}
	public void setValidTill(String validTill) {
		this.validTill = validTill;
	}
	public String getFlightTime() {
		return flightTime;
	}
	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}
	public String getTravelClass() {
		return travelClass;
	}
	public void setTravelClass(String travelClass) {
		this.travelClass = travelClass;
	}
	public String getSeatAvailability() {
		return seatAvailability;
	}
	public void setSeatAvailability(String seatAvailability) {
		this.seatAvailability = seatAvailability;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	public String getFlightDur() {
		return flightDur;
	}
	public void setFlightDur(String flightDur) {
		this.flightDur = flightDur;
	}
}
