package com.rt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
	
	//Sign-in and sign up form.
	@GetMapping("/")
	public String signInAndSignUpPage() {
		return "signInAndSignUp";
	}    
	

}
