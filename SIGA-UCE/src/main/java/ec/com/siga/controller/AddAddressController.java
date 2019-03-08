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
public class AddAddressController {

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

	@GetMapping("/addAddress")
	public ModelAndView showForm() {
		ModelAndView mav = new ModelAndView("addAddress");
		mav.addObject("paices", paisRepository.findAll());
		//mav.addObject("provincias", provinciaRepository.findAll());
		return mav;
	}
	
	@RequestMapping("/cargaCanton")
	public @ResponseBody ArrayList<ProvinciaEstado> showProvince(@RequestParam(name = "id", required = true) String id) {
		System.out.println(id);
		return new ArrayList<> (provinciaRepository.findByPaisId(Integer.valueOf(id)));
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
