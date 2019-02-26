package ec.com.siga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ec.com.siga.entity.Canton;
import ec.com.siga.entity.Direccion;
import ec.com.siga.entity.Parroquia;
import ec.com.siga.entity.ProvinciaEstado;
import ec.com.siga.service.AddressService;

@Controller
public class AddAddressController {

	@Autowired
	@Qualifier("addressService")
	private AddressService addressService;

	@GetMapping("/addAddress")
	public ModelAndView showForm() {
		ModelAndView mav = new ModelAndView("addAddress");
		mav.addObject("addressTipes", addressService.findAllDireccionTipo());
		mav.addObject("paices", addressService.findAllPais());
		return mav;
	}

	@PostMapping("/addAddress")
	public String addContact(@ModelAttribute(name = "addressModel") Direccion addressModel, Model model) {

		if (null != addressService.saveDireccion(addressModel)) {
			model.addAttribute("result", 1);
		} else {
			model.addAttribute("result", 0);
		}
		return "/dashboardAdmin";
	}

	
	@GetMapping("/selectProvincia")
	public @ResponseBody List<ProvinciaEstado> loginDisponible2(@ModelAttribute("login") String login) {
		return addressService.findAllByPaisId(Integer.parseInt(login));

	}
	@GetMapping("/selectCanton")
	public @ResponseBody List<Canton> loginDisponible3(@ModelAttribute("login") String login) {
		return addressService.findAllByPrpvinciaId(Integer.parseInt(login));

	}
	
	@GetMapping("/selectparish")
	public @ResponseBody List<Parroquia> loginDisponible4(@ModelAttribute("login") String login) {
		return addressService.findAllByCantonId(Integer.parseInt(login));

	}

}
