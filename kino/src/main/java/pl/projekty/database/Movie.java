package pl.projekty.database;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.*;

@Entity
public class Movie {

	@GeneratedValue
    @Id
    private Long id;
	
	@Column
	private LocalDate day;
	@Column
	private LocalTime hour;
	@Column
	private String title;
	@Column
	private Integer places;
	
	public LocalTime getHour(){
		return hour;
	}
	public String getTitle(){
		return title;
	}
	public int getPlaces(){
		return places;
	}
	
	public void setHour(LocalTime hour){
		this.hour = hour;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public void setPlaces(Integer places){
		this.places = places;
	}
	
	public LocalDate getDay() {
		return day;
	}
	public Long getId() {
		return id;
	}
	
	public void setDay(LocalDate day) {
		this.day = day;
	}
 
	@Override
    public String toString() {
        return String.format(
                "Movie[id=%d, day='%s', hour='%s, title='%s, places='%d']",
                id, day.toString(), hour.toString(), title, places);
    }
    public Movie(){
    	
    }
	public Movie(String day, String hour, String title, int availablePlaces){
		this.day = LocalDate.parse(day);
		this.hour = LocalTime.parse(hour);
		this.title = title;
		this.places = availablePlaces;
	}
	public Movie(LocalDate day, LocalTime hour, String title, int availablePlaces){
		this.day = day;
		this.hour = hour;
		this.title = title;
		this.places = availablePlaces;
	}
	
}

