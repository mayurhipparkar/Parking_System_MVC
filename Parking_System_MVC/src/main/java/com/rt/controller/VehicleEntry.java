package com.rt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rt.vehicleEntryDTO.ReqAddVehicleDto;
import com.rt.vehicleEntryDTO.RespAddVehicleDto;
import com.rt.vehicleEntryServiceInterface.VehicleEntryInterface;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/vehicle")
public class VehicleEntry {
	@Autowired
	private VehicleEntryInterface vehicleEntryInterface;
	
	@GetMapping("addVehicleForm")
	public String addVehicleEntryForm() {
		return "vehicleEntry/addVehicle";	
	}
	
	@PostMapping("/addVehicle")
	public String addVehicleEntryData(@ModelAttribute ReqAddVehicleDto reqAddVehicleDto,HttpSession session) {
		int sessionUserId=Integer.parseInt((String) session.getAttribute("userId"));
	 System.out.println("session value "+ session.getAttribute("userId"));
	 reqAddVehicleDto.setSessionLogedUserId(sessionUserId);
		
		RespAddVehicleDto respAddVehicleDto=vehicleEntryInterface.addVehicleInfo(reqAddVehicleDto);
		if(respAddVehicleDto!=null) {
			System.out.println("vehicle entry added");
			return "vehicleEntry/addVehicle";
		}
		System.out.println("vehicle entry not added");
		return "vehicleEntry/addVehicle";
		
		
	}

}
