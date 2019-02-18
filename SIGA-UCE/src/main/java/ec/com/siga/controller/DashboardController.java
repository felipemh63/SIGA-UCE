package ec.com.siga.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {

	@GetMapping("/dashboardAdmin")
	public ModelAndView showFormHome() {
		ModelAndView mav =new ModelAndView("dashboardAdmin");
		User user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("username", user.getUsername());
		return mav;
	}




}
