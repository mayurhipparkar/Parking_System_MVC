package com.rt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rt.DTO.RequestLoginDTO;
import com.rt.DTO.RequestSignUpDTO;
import com.rt.DTO.ResponseLoginDTO;
import com.rt.serviceImp.LoginServiceImp;
import com.rt.serviceImp.SignUpServiceImp;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginSignUpController {
	
	// SignUp logic Start.
	
	@Autowired
	SignUpServiceImp signUpService; //autowired signup service class.
	
	
	//it handles the registration form and transfer the data to service implemented class.
		@PostMapping("/registeruser")
		public String registerForm(@ModelAttribute RequestSignUpDTO reqDto,Model model,HttpSession session) {
		
			boolean userStatus=signUpService.registerUser(reqDto);
			System.out.println(reqDto.getFullname()+" "+reqDto.getEmail());
			System.out.println("check User status for signUp is it True or false "+userStatus);
		
			if(userStatus) {	
				return "index";
			}
			model.addAttribute("errorMsg","User already exist , login OR duplicate email is not allowed...!");
			return "signInAndSignUp";
			
		}
		
	// SignUp logic End.
		
	// Login logic Start.
		
		@Autowired
		LoginServiceImp loginService; //autowired login service class.
		
		@PostMapping("/loginuser")
		public String loginForm(@ModelAttribute RequestLoginDTO reqLoginDto,Model model,HttpSession session) {
		
			ResponseLoginDTO respLoginDto=loginService.loginUser(reqLoginDto);
			//setting session
			
		
			if(respLoginDto!=null) {
				String id = String.valueOf(respLoginDto.getId());
				session.setAttribute("userId",id);
				session.setAttribute("userName",respLoginDto.getFullname());
				session.setAttribute("userEmail",respLoginDto.getEmail());
				session.setAttribute("userRole",respLoginDto.getRole());
				return "index";
			}
			
			model.addAttribute("errorMsg","Something Wrong try again....!");
			return "signInAndSignUp";
			
		}
		
	// Login Login end.
		
		
		

}
