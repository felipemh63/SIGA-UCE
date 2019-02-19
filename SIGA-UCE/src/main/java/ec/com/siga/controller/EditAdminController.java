package ec.com.siga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ec.com.siga.entity.User;
import ec.com.siga.repository.UserJpaRepository;

@Controller
public class EditAdminController {
	@Autowired 
	@Qualifier("userRepository") 
	private UserJpaRepository userRepository;
	

	@GetMapping("/editAdmin")
	public String redirectContactForm(@RequestParam(name = "id", required = false) int id, Model model) {
		model.addAttribute("contactModel", userRepository.findById(id));
		return "/editAdmin";
	}
	
	@PostMapping("/addcontact")
	public String addContact(@ModelAttribute(name = "contactModel") User contactModel, Model model) {
		
		if (null != userRepository.save(contactModel)) {
			model.addAttribute("result", 1);
		} else {
			model.addAttribute("result", 0);
		}
		return "dashboardAdmin";
	}
}
