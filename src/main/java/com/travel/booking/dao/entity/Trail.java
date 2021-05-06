package com.travel.booking.dao.entity;

/*
 * Enumeration containing the list of trail that George have.
 */
public enum Trail {

	Shire("Shire","07:00", "09:00", 5, 100, 29.90), Gondor("Gondor","10:00", "13:00", 11, 50, 59.90),
	Mordor("Mordor","14:00", "19:00", 18, 40, 99.90);

	Trail(final String name,final String start, final String end, final int startAge, final int maxAge, final double price) {
		this.name=name;
		this.start = start;
		this.end = end;
		this.startAge = startAge;
		this.maxAge = maxAge;
		this.price = price;

	}
	
	private String name;

	private String start;
	private String end;
	private int startAge;
	private int maxAge;
	private double price;

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public int getStartAge() {
		return startAge;
	}

	public void setStartAge(int startAge) {
		this.startAge = startAge;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
