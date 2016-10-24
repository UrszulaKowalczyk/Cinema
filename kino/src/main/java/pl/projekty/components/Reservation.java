package pl.projekty.components;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Reservation {

	private String title;
	private String name;
	private String surname;
	private LocalDate date2;
	private LocalTime hour;
	private Integer places;	
	
	
	public Reservation(){
		date2 = null;
		hour = null;
		title = null;
		places = null;
		name = null;
		surname = null;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDateString() {
		return LocalDate.now().toString();
	}
	public void setDateString(String dateString) {
		this.date2 = LocalDate.parse(dateString);
	}

	public void setDate2(LocalDate date){
		this.date2 = date;
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
	
	public LocalDate getDate2(){
		return date2;
	}
	public LocalTime getHour(){
		return hour;
	}
	public String getTitle(){
		return title;
	}
	public Integer getPlaces(){
		return places;
	}

	public void clear() {
		date2 = null;
		hour = null;
		title = null;
		places = null;
		name = null;
		surname = null;
	}
}
