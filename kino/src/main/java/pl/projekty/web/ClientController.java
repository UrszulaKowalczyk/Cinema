package pl.projekty.web;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.projekty.components.BookingsUpdator;
import pl.projekty.components.PlacesUpdator;
import pl.projekty.components.Reservation;
import pl.projekty.components.ReservationWizzard;
import pl.projekty.database.BookingRepository;
import pl.projekty.database.MovieRepository;

@Controller
public class ClientController {
	@Autowired
	private MovieRepository movieRepository;	
	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private ReservationWizzard reservationWizzard;
	@Autowired
	private Reservation reservation;
	@Autowired
	private PlacesUpdator placesUpdator;
	@Autowired
	private BookingsUpdator bookingsUpdator;
	
	@PostMapping(value="/reserve")
    public String reserve() {
		return "redirect:date";
    }
	
	@GetMapping("/date")
	public String chooseDate(@RequestParam(value="date", required=false) LocalDate date, Model model){
		List<LocalDate> list = new ArrayList<>();
		list = reservationWizzard.createListOfDates(reservation, movieRepository);
		model.addAttribute("date", list);
		model.addAttribute("reservation", reservation);
		return "chooseDate";
	}
	
	@PostMapping(value="/date")
    public String getDate(@ModelAttribute Reservation reservation) {
		this.reservation.setDate2(reservation.getDate2());
		return "redirect:film";
    }
	
	@GetMapping("/film")
	public String chooseFilm(@RequestParam(value="title", required=false) String title, Model model){
		List<String> list = new ArrayList<>();
		list = reservationWizzard.createList(reservation, movieRepository);
		model.addAttribute("title", list);
		model.addAttribute("reservation", reservation);
		return "chooseFilm";
	}
	
	@PostMapping(value="/film")
    public String getFilm(@ModelAttribute Reservation reservation) {
		this.reservation.setTitle(reservation.getTitle());
		return "redirect:hour";
    }
	
	@GetMapping("/hour")
	public String chooseHour(@RequestParam(value="hour", required=false) LocalTime hour, Model model){
		List<LocalTime> list = new ArrayList<>();
		list = reservationWizzard.createListOfHour(reservation, movieRepository);
		model.addAttribute("hour", list);
		model.addAttribute("reservation", reservation);
		return "chooseHour";
	}
	
	@PostMapping(value="/hour")
    public String getHour(@ModelAttribute Reservation reservation) {
		this.reservation.setHour(reservation.getHour());
		return "redirect:places";
    }
	
	@GetMapping("/places")
	public String choosePlaces(@RequestParam(value="places", required=false) Integer places, Model model){
		List<Integer> list = new ArrayList<>();
		list = reservationWizzard.createListOfPlaces(reservation, movieRepository);
		if (!list.isEmpty()){
			model.addAttribute("places", list);
			model.addAttribute("reservation", reservation);
			return "choosePlaces";
		}
		else return "noPlaces";
	}
	
	@PostMapping(value="/places")
    public String getPlaces(@ModelAttribute Reservation reservation) {
		this.reservation.setPlaces(reservation.getPlaces());
		return "redirect:principal";
    }
	
	@GetMapping(value="/principal")
    public String principalalData(Model model) {
		model.addAttribute("reservation", reservation);
		return "personalData";
    }
	
	@PostMapping(value="/principal")
    public String gotPersonalData(@ModelAttribute Reservation reservation) {
		this.reservation.setName(reservation.getName());
		this.reservation.setSurname(reservation.getSurname());
		bookingsUpdator.addReservation(movieRepository, this.reservation, bookingRepository);
		return "redirect:final";
    }
	
	@GetMapping("/final")
	public String finalPage(Model model){
		placesUpdator.updateDataBase(reservation, movieRepository);
		model.addAttribute("reservation", reservation);
		return "final";
	}

}
