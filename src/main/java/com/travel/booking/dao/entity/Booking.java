package com.travel.booking.dao.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;




@Entity
public class Booking extends PanacheEntityBase  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name = "id_booking")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBooking;

	
	private Trail trail;

	private Date date;

	private Status bookingStatus;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "hikers_booking", joinColumns = {
			@JoinColumn(name = "id_booking", referencedColumnName = "id_booking", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "name_hiker", referencedColumnName = "name_hiker", nullable = false, updatable = false) })
	private Set<Hiker> hikers;

	public Status getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(Status bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public Long getIdBooking() {
		return idBooking;
	}

	public void setIdBooking(Long idBooking) {
		this.idBooking = idBooking;
	}

	public Trail getTrail() {
		return trail;
	}

	public void setTrail(Trail trail) {
		this.trail = trail;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set<Hiker> getHikers() {
		return hikers;
	}

	public void setHikers(Set<Hiker> hikers) {
		this.hikers = hikers;
	}

}
