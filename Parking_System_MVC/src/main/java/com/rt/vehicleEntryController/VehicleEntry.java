package com.rt.vehicleEntryController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rt.vehicleEntryDTO.add.ReqAddVehicleDto;
import com.rt.vehicleEntryDTO.add.RespAddVehicleDto;
import com.rt.vehicleEntryDTO.select.RespFetchVehicleInfo;
import com.rt.vehicleEntryServiceInterface.VehicleEntryInterface;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/vehicle")
public class VehicleEntry {
	@Autowired
	private VehicleEntryInterface vehicleEntryInterface;
	
	@GetMapping("add-vehicle-Form")
	public String addVehicleEntryForm() {
		return "vehicleEntry/addVehicle";	
	}
	
	//it is used to add data in database.
	@PostMapping("/add-Vehicle")
	public String addVehicleEntryData(@ModelAttribute ReqAddVehicleDto reqAddVehicleDto,HttpSession session) {
		int sessionUserId=Integer.parseInt((String) session.getAttribute("userId"));
	 System.out.println("session value "+ session.getAttribute("userId"));
	 reqAddVehicleDto.setUserId(sessionUserId);
		
		RespAddVehicleDto respAddVehicleDto=vehicleEntryInterface.addVehicleInfo(reqAddVehicleDto);
		if(respAddVehicleDto!=null) {
			System.out.println("vehicle entry added");
			if(respAddVehicleDto.getVehicleType().equalsIgnoreCase("two wheeler")) {
				
				return "redirect:/list/twoWheeler-list/"+respAddVehicleDto.getVehicleType();
				
			}else if(respAddVehicleDto.getVehicleType().equalsIgnoreCase("four wheeler")){
			
				return "redirect:/list/fourWheeler-list/"+respAddVehicleDto.getVehicleType();
			} 
		
		}
		return "vehicleEntry/addVehicle";
		
	}
	
	//it is used to fetch data using id to update the individual data in update form.
	@GetMapping("/fetch-Vehicle/{id}")
	public String fetchVehicleData(@PathVariable int id,Model model) {
		RespFetchVehicleInfo respFetchVehicleInfo=vehicleEntryInterface.fetchVehicleData(id);
		if(respFetchVehicleInfo!=null) {
			model.addAttribute("vehicleData", respFetchVehicleInfo);
				return "vehicleEntry/updateVehicleInfo";
		}
			
		return "vehicleEntry/twoWheelerlist";
		
	}
	
	

}
