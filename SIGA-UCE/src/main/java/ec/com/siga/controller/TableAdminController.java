package ec.com.siga.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TableAdminController {

	@GetMapping("/tableAdmin")
	public String showForm() {
		return "tableAdmin";
	}

}
