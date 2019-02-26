package ec.com.siga.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ec.com.siga.entity.Direccion;
import ec.com.siga.entity.Pais;
import ec.com.siga.entity.ProvinciaEstado;
import ec.com.siga.repository.CantonJpaRepository;
import ec.com.siga.repository.DireccionRepository;
import ec.com.siga.repository.PaisJpaRepository;
import ec.com.siga.repository.ParroquiaJpaRepository;
import ec.com.siga.repository.ProvinciaJpaRepository;

@Controller
public class AddRegisterController {

	@Autowired
	@Qualifier("parroquiaRepository")
	private ParroquiaJpaRepository parroquiaRepository;
	
	@Autowired
	@Qualifier("cantonRepository")
	private CantonJpaRepository cantonRepository;
	
	@Autowired
	@Qualifier("provinciaRepository")
	private ProvinciaJpaRepository provinciaRepository;
	
	@Autowired
	@Qualifier("paisRepository")
	private PaisJpaRepository paisRepository;

	@Autowired
	@Qualifier("direccionRepository")
	private DireccionRepository direccionRepository;

	@GetMapping("/addRegister")
	public ModelAndView showForm() {
		ModelAndView mav = new ModelAndView("addRegister");
		mav.addObject("paises", paisRepository.findAll());
		return mav;
	}
	
	

	@PostMapping("/addRegister")
	public String addContact(@ModelAttribute(name = "registerModel") Direccion registerModel, Model model1) {

		if (null != direccionRepository.save(registerModel)) {
			model1.addAttribute("result", 1);
		} else {
			model1.addAttribute("result", 0);
		}
		return "/dashboardAdmin";
	}

}
