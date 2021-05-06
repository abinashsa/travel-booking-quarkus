package com.travel.booking.domain.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import com.travel.booking.dao.entity.Booking;
import com.travel.booking.dao.entity.Hiker;
import com.travel.booking.dao.entity.Status;
import com.travel.booking.dao.entity.Trail;
import com.travel.booking.domain.exception.AgeException;
import com.travel.booking.domain.exception.AgeHikerInvalidException;
import com.travel.booking.domain.exception.InvalidDateException;
import com.travel.booking.domain.exception.InvalidTrailException;
import com.travel.booking.domain.exception.UnknownHikerException;
import com.travel.booking.domain.mapper.BookingMapper;


@ApplicationScoped
public class BookingService {

	

	public List<Booking> getAllBooking() {

		 return Booking.listAll();
	}

	@Transactional
	public Booking createBooking(Booking b,Date d) throws InvalidDateException, AgeException {
		
		
		if (b.getDate().before(d)) {
			throw new InvalidDateException("Invalid Date inferior to now!!");
		}

		AgeException exception = new AgeException(new ArrayList<>());
		b.getHikers().stream().forEach(hiker -> {
			if (hiker.getAgeHiker() < b.getTrail().getStartAge() || hiker.getAgeHiker() > b.getTrail().getMaxAge()) {
				exception.getExceptions().add(new AgeHikerInvalidException(hiker.getName()));
			}
		});
		if (exception.getExceptions().size() > 0)
			throw exception;
		Hiker.persist(b.getHikers());
		b.persist();
		return b;
	}

	@SuppressWarnings("static-access")
	public void cancelBooking(String date, String name, String trailName)
			throws UnknownHikerException, InvalidTrailException {
		List<Booking> bookings = Booking.listAll();

		Trail trail = BookingMapper.stringToTrail(trailName);
		List<Booking> bookingByDate  = bookings.stream().filter(booking -> {
			try {
				return booking.getDate().getTime()==BookingMapper.stringdateToDate(date).getTime();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				return false;
			}
		}).collect(Collectors.toList());

		List<Booking> bookingByTrail = bookingByDate.stream().filter(booking -> booking.getTrail().equals(trail))

				.collect(Collectors.toList());
		List<Booking> bookingsTocancel = new ArrayList<>();
		for (Booking b : bookingByTrail) {
			if (b.getHikers().stream().map(hiker -> hiker.getName()).collect(Collectors.toList()).contains(name))
				bookingsTocancel.add(b);

		}
		bookingsTocancel.forEach(booking -> booking.update("status= ?1", Status.CANCELED));
	}

	public List<Booking> getBookingByDate(Date date) {
		return Booking.list("date", date);
	}

	public List<Booking> getBookingByHiker(String name) throws UnknownHikerException {
		List<Booking> bookings = Booking.listAll();
			return bookings.stream().filter(booking -> booking.getHikers().stream().map(hiker -> hiker.getName()).collect(Collectors.toList()).contains(name))
					.collect(Collectors.toList());

		

	}

}
