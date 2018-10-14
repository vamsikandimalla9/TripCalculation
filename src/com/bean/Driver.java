package com.bean;

public class Driver {
	
	
	private String name;
	private double miles;
	private double mph;
	
	public Driver() {
		// TODO Auto-generated constructor stub
		// bold
	}
	
	public Driver(String name, double miles, double mph) {
		super();
		this.name = name;
		this.miles = miles;
		this.mph = mph;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getMiles() {
		return miles;
	}


	public void setMiles(double miles) {
		this.miles = miles;
	}


	public double getMph() {
		return mph;
	}


	public void setMph(double mph) {
		this.mph = mph;
	}


	@Override
	public String toString() {
		return name + " :" + Math.round(miles) + " miles @" + Math.round(mph) + "mph";
	}
	
	
	
	

}
