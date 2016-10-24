package pl.projekty.components;

import java.util.List;

import org.springframework.stereotype.Component;

import pl.projekty.database.Booking;
import pl.projekty.database.BookingRepository;
import pl.projekty.database.Movie;
import pl.projekty.database.MovieRepository;

@Component
public class AdministratorManagament {
	
	public void addFilmToDataBase(Film film, MovieRepository movieRepository){
		movieRepository.save(new Movie(film.getDay(), film.getHour(), film.getTitle(), film.getPlaces()));
	}
	
	public void seeAllReservations(Film film, BookingRepository bookingRepository, List<String> list){
		for(Booking booking : bookingRepository.findAll()){
			list.add(booking.toString());
		}
	}
}
