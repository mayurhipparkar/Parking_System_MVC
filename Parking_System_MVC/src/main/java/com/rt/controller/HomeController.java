package com.rt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rt.DTO.RequestSignUpDTO;
import com.rt.serviceImp.SignUpServiceImp;

@Controller
public class HomeController {
	
	//Sign-in and sign up form.
	@GetMapping("/")
	public String signInAndSignUpPage() {
		return "signInAndSignUp";
	}    
	

}
