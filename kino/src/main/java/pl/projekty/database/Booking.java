package pl.projekty.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Booking {
	@GeneratedValue
    @Id
    private Long id;
	
	@Column
	String name;
	@Column
	String surname;
	@Column
	Integer places;
	
	@ManyToOne
	@JoinColumn(name = "movie_id")
	private Movie movie;
	
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
	
	public int getPlaces(){
		return places;
	}
	
	public void setPlaces(Integer places){
		this.places = places;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getSurame(){
		return surname;
	}
	
	public void setSurname(String surname){
		this.surname = surname;
	}

	public Booking(){}
	public Booking(String name, String surname, int places, Movie movie){
		this.name = name;
		this.surname = surname;
		this.places = places;
		this.movie = movie;
	}
	
	@Override
    public String toString() {
        return String.format(
                "BOOKING id=%d:   name='%s',   surname='%s',   places='%d',   day='%s',   hour='%s',   title='%s'",
                id, name, surname, places, movie.getDay(), movie.getHour(), movie.getTitle());
    }
}
