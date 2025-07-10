package com.rt.guardController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddGuard {
	
	@GetMapping("/add-guard-form")
	public String addGuard() {
		return "guard/addGuard";
		
	}

}
