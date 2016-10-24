package pl.projekty.database;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
	List<Movie> findByDay(LocalDate day);
	List<Movie> findByHour(LocalTime hour);
	List<Movie> findByTitle(String title);
	List<Movie> findByDayAndTitle(LocalDate day, String title);
	List<Movie> findByDayAndTitleAndHour(LocalDate day, String title, LocalTime hour);
}