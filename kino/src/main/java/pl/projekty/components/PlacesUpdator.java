package pl.projekty.components;

import org.springframework.stereotype.Component;

import pl.projekty.database.Movie;
import pl.projekty.database.MovieRepository;

@Component
public class PlacesUpdator {

	public void updateDataBase(Reservation reservation, MovieRepository movieRepository){

		for(Movie movie: movieRepository.findByDayAndTitleAndHour(reservation.getDate2(), reservation.getTitle(), reservation.getHour())){
			movie.setPlaces(movie.getPlaces()-reservation.getPlaces());
			movieRepository.save(movie);
		}
	}
}
