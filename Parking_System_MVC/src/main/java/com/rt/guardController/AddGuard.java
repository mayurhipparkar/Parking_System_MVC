package com.rt.guardController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rt.guardDTO.AddGuardReqDTO;
import com.rt.guardServiceInterface.GuardServiceInterface;

@Controller
public class AddGuard {
	
	@Autowired
	private GuardServiceInterface guardServiceInterface;
	
	@GetMapping("/add-guard-form")
	public String addGuardForm() {
		return "guard/addGuard";
	}
	
	@PostMapping("/add-guard")
	public String getGuardData(@ModelAttribute AddGuardReqDTO addGuardReqDTO,Model model) {
		System.out.println("guard details :"+addGuardReqDTO.getFullname()+" "+addGuardReqDTO.getNumber()+" "+
				addGuardReqDTO.getEmail()+" "+addGuardReqDTO.getAddress()+" "+addGuardReqDTO.getPassword());
		
		//call to service layer.
		String message=guardServiceInterface.addGuard(addGuardReqDTO);
		
		if(message!=null) {
			System.out.println("the guard message :"+message);
			model.addAttribute("msg",message);
			
			return "guard/addGuard";
		}
		
		return "redirect:/add-guard-form";
		
	}

}
