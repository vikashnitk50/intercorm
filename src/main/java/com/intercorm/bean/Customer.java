package com.intercorm.bean;


public class Customer implements Comparable<Customer>{
	

	private Integer user_id;
	
	private String name;
	
	private double latitude;
	
	private double longitude;
	
	private double distance;

	public Customer() {
		super();
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "Customer [user_id=" + user_id + ", name=" + name
				+ ", latitude=" + latitude + ", longitude=" + longitude
				+ ", distance=" + distance + "]";
	}

	@Override
	public int compareTo(Customer o) {
		return this.getUser_id().compareTo(o.getUser_id());
	}
	
	

}
