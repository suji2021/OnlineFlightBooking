package com.flightbooking.exception;

public class AirportNotFoundException extends Exception {
	private String message6;
	public AirportNotFoundException() {}
	public AirportNotFoundException(String message6) {
		this.message6=message6;
	}
	public String getMessage6() {
		return this.message6;
	}

}
