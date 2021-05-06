package com.travel.booking.domain.mapper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import com.travel.booking.api.dto.BookingDto;
import com.travel.booking.dao.entity.Booking;
import com.travel.booking.dao.entity.Status;
import com.travel.booking.dao.entity.Trail;
import com.travel.booking.domain.exception.InvalidDateException;
import com.travel.booking.domain.exception.InvalidTrailException;

public class BookingMapper {



	public static Trail stringToTrail(String trailName) throws InvalidTrailException {
		return Arrays.asList(Trail.values()).stream().filter(trail -> trail.getName().toLowerCase().equals(trailName.toLowerCase())).findFirst()
				.orElseThrow(InvalidTrailException::new);

	}

	public static Date stringdateToDate(String date) throws ParseException {
		DateFormat sdf = new SimpleDateFormat("yyyy/mm/DD");
		Date result = sdf.parse(date);
		return result;
	}

	public static Booking bookingDtoToBooking(BookingDto dto) throws InvalidDateException, InvalidTrailException {

		Booking booking = new Booking();
		DateFormat sdf = new SimpleDateFormat("yyyy/mm/DD");
		try {
			booking.setDate(sdf.parse(dto.getDate()));
			booking.setBookingStatus(Status.OK);
		} catch (ParseException e) {
			throw new InvalidDateException(
					dto.getDate() + " can be parsed to date format . Your date should be like this YYYY/MM/DD");
		}
		booking.setHikers(dto.getHikers());

		Trail selectedTrail = Arrays.asList(Trail.values()).stream()
				.filter(trail -> trail.getName().equals(dto.getTrail())).findFirst()
				.orElseThrow(InvalidTrailException::new);
		booking.setTrail(selectedTrail);
		return booking;

	}

}
