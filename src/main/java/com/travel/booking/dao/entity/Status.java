package com.travel.booking.dao.entity;

public enum Status {

	CANCELED(0),OK(1);

	int value;
	Status(int i) {
		this.value=i;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}

