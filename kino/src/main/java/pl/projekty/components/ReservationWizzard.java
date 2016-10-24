package pl.projekty.components;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import org.springframework.stereotype.Component;

import pl.projekty.database.Movie;
import pl.projekty.database.MovieRepository;

@Component
public class ReservationWizzard {
	public List<LocalDate> createListOfDates(Reservation reservation, MovieRepository movieRepository){
		List<LocalDate> newList = new ArrayList<LocalDate>();
		boolean isAlready;
		for (Movie movie : movieRepository.findAll()) {
			isAlready = false;
			for(LocalDate date : newList){
				if (date.equals(movie.getDay())){
					isAlready = true;
				}
			}
			if(!isAlready)
				newList.add(movie.getDay());
		}
		return newList;
	}
	
	public List<String> createList(Reservation reservation, MovieRepository movieRepository){
		List<String> newList = new ArrayList<String>();
		boolean isAlready;
		for(Movie movie: movieRepository.findByDay(reservation.getDate2())){
			isAlready = false;
			for(String title : newList){
				if(title.equals(movie.getTitle()))
					isAlready = true;
			}
			if (!isAlready)
				newList.add(movie.getTitle());
		}
		return newList;
	}
	
	public List<LocalTime> createListOfHour(Reservation reservation, MovieRepository movieRepository){
		List<LocalTime> newList = new ArrayList<>();
		boolean isAlready;
		for(Movie movie: movieRepository.findByDayAndTitle(reservation.getDate2(), reservation.getTitle())){
			isAlready = false;
			for(LocalTime hour : newList){
				if(hour.equals(movie.getHour()))
					isAlready = true;
			}
			if (!isAlready)
				newList.add(movie.getHour());
		}
		return newList;
	}
	
	public List<Integer> createListOfPlaces(Reservation reservation, MovieRepository movieRepository){
		Integer availablePlaces = null;
		List<Integer> newList = new ArrayList<Integer>();
		for(Movie movie: movieRepository.findByDayAndTitleAndHour(reservation.getDate2(), reservation.getTitle(), reservation.getHour())){
			availablePlaces = movie.getPlaces();
		}
		for(int i = 1; i < 7; i++){
			if (availablePlaces>=i) newList.add(i);
		}
		return newList;
	}

	
}
