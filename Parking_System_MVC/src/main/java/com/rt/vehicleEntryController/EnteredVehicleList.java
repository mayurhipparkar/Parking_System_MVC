package com.rt.vehicleEntryController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rt.vehicleEntryDTO.RespEnteredVehicleListDTO;
import com.rt.vehicleEntryServiceInterface.EnteredVehicleListInterface;

@RequestMapping("/list")
@Controller
public class EnteredVehicleList {
	
	@Autowired
	private EnteredVehicleListInterface enteredVehicleListInterface;
	
	@GetMapping("/vehicleList")
	public String twoWheelerList(Model model) {
		List<RespEnteredVehicleListDTO> list=enteredVehicleListInterface.twoWheelerList();
		if(list!=null) {
			model.addAttribute("vehicleList", list); 
			return "vehicleEntry/twoWheelerList";
		}
		
		return "vehicleEntry/addVehicle";
		
	}
	
	
}
