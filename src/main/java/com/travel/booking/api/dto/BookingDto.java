package com.travel.booking.api.dto;

import java.util.Set;

import javax.validation.constraints.NotBlank;

import com.travel.booking.dao.entity.Hiker;

public class BookingDto {

	@NotBlank
	private String trail;
	@NotBlank
	private String date;

	private Set<Hiker> hikers;

	public String getTrail() {
		return trail;
	}

	public void setTrail(String trail) {
		this.trail = trail;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Set<Hiker> getHikers() {
		return hikers;
	}

	public void setHikers(Set<Hiker> hikers) {
		this.hikers = hikers;
	}

}
