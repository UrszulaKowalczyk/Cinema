package pl.projekty.components;

import org.springframework.stereotype.Component;

import pl.projekty.database.Admin;
import pl.projekty.database.AdminRepository;

@Component
public class AuthorizationChecker {
	public String checkAuthorisationToAdd(String login, AdminRepository adminRepository){
		for(Admin admin: adminRepository.findByLogin(login)){
			if(admin.getAuthorizedToAdd())
				return "redirect:addFilm";
		}
		return "redirect:notAllowed";
	}
	public String checkAuthorisationToSee(String login, AdminRepository adminRepository){
		for(Admin admin: adminRepository.findByLogin(login)){
			if(admin.getAuthorizedToSee())
				return "redirect:seeAllReservations";
		}
		return "redirect:notAllowed";
	}

}
