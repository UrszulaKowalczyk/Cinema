package pl.projekty.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pl.projekty.components.Reservation;

@Controller
public class CinemaController {
	@Autowired
	private Reservation reservation;
	
	
	@GetMapping("/")
	public String start(){	
		reservation.clear();
		return "startingPage";
	}
	@PostMapping("/backToStart")
	public String startAgain(){	
		return "redirect:";
	}

}
