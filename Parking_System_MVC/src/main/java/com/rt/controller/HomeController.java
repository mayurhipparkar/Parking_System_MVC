package com.rt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String signInAndSignUpPage() {
		return "signInAndSignUp";
	}
	
	@GetMapping("/dash")
	public String dashboardPage() {
		return "dashboard";
	}
	

}
