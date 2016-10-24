package pl.projekty.components;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Film {
	String title;
	LocalDate day;
	LocalTime hour;
	Integer places;
	public void setAll(String title, LocalDate day, LocalTime hour, Integer places){
		this.title = title;
		this.day = day;
		this.hour = hour;
		this.places = places;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = LocalDate.parse(day);
	}
	public LocalTime getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = LocalTime.parse(hour);
	}
	public Integer getPlaces() {
		return places;
	}
	public void setPlaces(Integer places) {
		this.places = places;
	}
	public Film(){
		title = null;
		day = null;
		hour = null;
		places = null;
	}
	public void clear(){
		title = null;
		day = null;
		hour = null;
		places = null;
	}
	

}
