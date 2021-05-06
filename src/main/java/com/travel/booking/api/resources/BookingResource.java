package com.travel.booking.api.resources;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.travel.booking.api.dto.BookingDto;
import com.travel.booking.dao.entity.Booking;
import com.travel.booking.domain.exception.AgeException;
import com.travel.booking.domain.exception.InvalidDateException;
import com.travel.booking.domain.exception.InvalidTrailException;
import com.travel.booking.domain.exception.UnknownHikerException;
import com.travel.booking.domain.mapper.BookingMapper;
import com.travel.booking.domain.service.BookingService;



@Path("/bookings")
public class BookingResource {

	
	@Inject
	BookingService bookingService;
  
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/create")
	public Booking createBooking( @Valid BookingDto dto)
			throws InvalidDateException, InvalidTrailException, AgeException, ParseException {
		DateFormat sdf = new SimpleDateFormat("yyyy/mm/DD");

		return 
				bookingService.createBooking(BookingMapper.bookingDtoToBooking(dto), sdf.parse(sdf.format(new Date())));
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/view/all")
	public List<Booking> viewAllBooking() {

		return bookingService.getAllBooking();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/view")
	public List<Booking> viewByDate(@QueryParam( "date") String date)
			throws InvalidDateException {
		DateFormat sdf = new SimpleDateFormat("yyyy/mm/DD");
		try {
			Date selectedDate = sdf.parse(date);

			return bookingService.getBookingByDate(selectedDate);
		} catch (ParseException e) {
			throw new InvalidDateException(
					date + " can be parsed to date format . Your date should be like this YYYY/MM/DD");
		}
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/cancel")
	public String cancelBooking(@QueryParam("date") String date,
			@QueryParam("name") String name, @QueryParam("trail") String trail)
			throws InvalidDateException, UnknownHikerException, InvalidTrailException {

		bookingService.cancelBooking(date, name, trail);

		return "Booking Canceled";

	}


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/view/booking/{name}")
	public List<Booking> hikerView(@PathParam("name") String name) throws UnknownHikerException {

		return bookingService.getBookingByHiker(name);
	}
  
}