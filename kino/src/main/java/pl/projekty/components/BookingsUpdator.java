package pl.projekty.components;

import org.springframework.stereotype.Component;

import pl.projekty.database.Booking;
import pl.projekty.database.BookingRepository;
import pl.projekty.database.Movie;
import pl.projekty.database.MovieRepository;

@Component
public class BookingsUpdator {

	public void addReservation(MovieRepository movieRepository, Reservation reservation, BookingRepository bookingRepository){
		Movie movieId = null;
		for (Movie movie : movieRepository.findByDayAndTitleAndHour(reservation.getDate2(), reservation.getTitle(), reservation.getHour())){
			movieId = movie;
		}
		Booking booking = new Booking(reservation.getName(), reservation.getSurname(), reservation.getPlaces(), movieId);
		bookingRepository.save(booking);
	}
}
