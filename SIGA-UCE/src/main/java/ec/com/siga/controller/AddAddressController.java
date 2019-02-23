package ec.com.siga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ec.com.siga.entity.Direccion;
import ec.com.siga.repository.DireccionRepository;
import ec.com.siga.repository.ParroquiaJpaRepository;

@Controller
public class AddAddressController {

	@Autowired
	@Qualifier("parroquiaRepository")
	private ParroquiaJpaRepository parroquiaRepository;

	@Autowired
	@Qualifier("direccionRepository")
	private DireccionRepository direccionRepository;

	@GetMapping("/addAddress")
	public ModelAndView showForm() {
		ModelAndView mav = new ModelAndView("addAddress");
		mav.addObject("parroquias", parroquiaRepository.findAll());
		return mav;
	}

	@PostMapping("/addAddress")
	public String addContact(@ModelAttribute(name = "addressModel") Direccion addressModel, Model model) {

		if (null != direccionRepository.save(addressModel)) {
			model.addAttribute("result", 1);
		} else {
			model.addAttribute("result", 0);
		}
		return "/dashboardAdmin";
	}

}
