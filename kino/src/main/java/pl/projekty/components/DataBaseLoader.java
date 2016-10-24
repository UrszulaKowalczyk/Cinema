package pl.projekty.components;

import java.security.NoSuchAlgorithmException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.projekty.database.Admin;
import pl.projekty.database.AdminRepository;
import pl.projekty.database.Movie;
import pl.projekty.database.MovieRepository;

@Component
public class DataBaseLoader {

	@Autowired
	private MovieRepository movieRepository;	
	@Autowired
	private AdminRepository adminRepository;
	@PostConstruct
	private void fillDataBase() throws NoSuchAlgorithmException{
		movieRepository.save(new Movie("2016-10-26", "10:30", "Kids and Animals", 50));
		movieRepository.save(new Movie("2016-10-26", "12:10", "Just a Film", 50));
		movieRepository.save(new Movie("2016-10-26", "14:30", "A Film", 38));
		movieRepository.save(new Movie("2016-10-26", "16:55", "Just a Film", 47));
		movieRepository.save(new Movie("2016-10-26", "19:30", "A Film", 48));
		movieRepository.save(new Movie("2016-10-26", "22:30", "Very Scary Film", 27));

		movieRepository.save(new Movie("2016-10-27", "10:30", "Kids and Animals", 5));
		movieRepository.save(new Movie("2016-10-27", "12:10", "Kids and Animals", 38));
		movieRepository.save(new Movie("2016-10-27", "14:30", "Just a Film", 38));
		movieRepository.save(new Movie("2016-10-27", "16:55", "Just a Film", 27));
		movieRepository.save(new Movie("2016-10-27", "19:30", "Very Scary Film", 28));
		movieRepository.save(new Movie("2016-10-27", "22:30", "Very Scary Film", 27));
		
		movieRepository.save(new Movie("2016-10-28", "10:30", "Kids and Animals", 5));
		movieRepository.save(new Movie("2016-10-28", "12:10", "Kids and Animals", 38));
		movieRepository.save(new Movie("2016-10-28", "14:30", "Just a Film", 38));
		movieRepository.save(new Movie("2016-10-28", "16:55", "Just a Film", 27));
		movieRepository.save(new Movie("2016-10-28", "19:30", "Very Scary Film", 28));
		movieRepository.save(new Movie("2016-10-28", "22:30", "Very Scary Film", 27));
		
		movieRepository.save(new Movie("2016-10-29", "10:30", "Kids and Animals", 50));
		movieRepository.save(new Movie("2016-10-29", "12:10", "Just a Film", 50));
		movieRepository.save(new Movie("2016-10-29", "14:30", "Just a Film", 38));
		movieRepository.save(new Movie("2016-10-29", "16:55", "Just a Film", 47));
		movieRepository.save(new Movie("2016-10-29", "19:30", "Very Scary Film", 48));
		movieRepository.save(new Movie("2016-10-29", "22:30", "Very Scary Film", 27));
		
		movieRepository.save(new Movie("2016-10-30", "10:30", "Kids and Animals", 50));
		movieRepository.save(new Movie("2016-10-30", "12:10", "Just a Film", 50));
		movieRepository.save(new Movie("2016-10-30", "14:30", "A Film", 38));
		movieRepository.save(new Movie("2016-10-30", "16:55", "Just a Film", 47));
		movieRepository.save(new Movie("2016-10-30", "19:30", "A Film", 48));
		movieRepository.save(new Movie("2016-10-30", "22:30", "Just a Film", 27));
        adminRepository.save(new Admin("admin1", true, true));
        adminRepository.save(new Admin("admin2", false, true));
       

	}
}
