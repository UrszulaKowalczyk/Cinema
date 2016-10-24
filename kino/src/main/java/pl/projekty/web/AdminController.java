package pl.projekty.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.projekty.components.AdministratorManagament;
import pl.projekty.components.AuthorizationChecker;
import pl.projekty.components.Film;
import pl.projekty.database.AdminRepository;
import pl.projekty.database.BookingRepository;
import pl.projekty.database.MovieRepository;

@Controller
public class AdminController {
	@Autowired
	private MovieRepository movieRepository;	
	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private Film film;
	@Autowired
	private AdministratorManagament administratorManagament;
	@Autowired
	private AuthorizationChecker authorizationChecker;
	
	@GetMapping(value="/login")
    public String tryLogin() {
		return "login";
    }
	
	@PostMapping(value="/loggedIn")
    public String chooseFunctionAgain() {
		return "loggedIn";
    }
	@PostMapping(value="/addMovie")
	public String addMovie(){
		String login = SecurityContextHolder.getContext().getAuthentication().getName();
		return authorizationChecker.checkAuthorisationToAdd(login, adminRepository);
	}
	@PostMapping(value="/seeReservations")
	public String seeReservations(){
		String login = SecurityContextHolder.getContext().getAuthentication().getName();
		return authorizationChecker.checkAuthorisationToSee(login, adminRepository);
	}
	@GetMapping(value="/addFilm")
	public String addFilm(Model model){
		film.clear();
		model.addAttribute(film);
		return "newFilmData";
	}
	@PostMapping(value="/addFilm")
	public String addFilmToDataBase(@ModelAttribute Film film){
		this.film.setAll(film.getTitle(), film.getDay(), film.getHour(), film.getPlaces());
		administratorManagament.addFilmToDataBase(film, movieRepository);
		return "filmAdded";
	}
	
	@GetMapping(value="/seeAllReservations")
	public String seeBookings(@RequestParam(value="booking", required=false) List<String> booking, Model model){
		List<String> list = new ArrayList<String>();
		administratorManagament.seeAllReservations(film, bookingRepository, list);
		model.addAttribute("booking", list);
		return "seeBookings";
	}
	
	@GetMapping(value="/notAllowed")
    public String notAllowed() {
		return "notAllowed";
    }
	@GetMapping(value="/wrongPassword")
    public String wrongPassword() {
		return "wrongPassword";
    }
	@PostMapping(value="/logout")
    public String logout() {
		return "redirect:logout";
    }

}
