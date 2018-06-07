package com.bean;

public class Trip {

	private String driver;
	private String from;
	private String to;
	private String miles;
	
	public Trip() {
		// TODO Auto-generated constructor stub
	}
	
	public Trip(String driver, String from, String to, String miles) {
		super();
		this.driver = driver;
		this.from = from;
		this.to = to;
		this.miles = miles;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getMiles() {
		return miles;
	}

	public void setMiles(String miles) {
		this.miles = miles;
	}
	
	
	
		
}
