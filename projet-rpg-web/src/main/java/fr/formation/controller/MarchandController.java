package fr.formation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MarchandController {
	@GetMapping("/marchand")
	public String marchand(){
		return "marchand";
	}
	
}
