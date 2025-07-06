package com.rt.vehicleEntryController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rt.vehicleEntryDTO.update.ReqUpdateVehicleInfoDto;
import com.rt.vehicleEntryServiceInterface.UpdateAndDeleteVehicleInfoInterface;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/update-delete")
public class UpdateVehicleInfoController {
	@Autowired
	private UpdateAndDeleteVehicleInfoInterface updateAndDeleteVehicleInfoInterface;
	// it is used to open the update form .
	@GetMapping("/update-vehicle-form")
	public String updateForm() {
		
		return "vehicleEntry/updateVehicleUsingFetch";
	}
	
	
	//it is mapped to update existing record .
	@PostMapping("/update-vehicle")
	public String updateBasedOnId(@ModelAttribute ReqUpdateVehicleInfoDto reqUpdateDto,HttpSession session) {
		int sessionUserId=Integer.parseInt((String) session.getAttribute("userId"));
		 System.out.println("session value "+ session.getAttribute("userId"));
		 reqUpdateDto.setUserId(sessionUserId);
		 
		boolean	reqUpdateVehicleInfoDto=updateAndDeleteVehicleInfoInterface.updateVehicleInfoUsingId(reqUpdateDto);
		if(reqUpdateVehicleInfoDto) {
			
			if(reqUpdateDto.getVehicleType().equalsIgnoreCase("two wheeler")) {
				
				return "redirect:/list/twoWheeler-list/"+reqUpdateDto.getVehicleType();
			}else if(reqUpdateDto.getVehicleType().equalsIgnoreCase("four wheeler")){
				
				return "redirect:/list/fourWheeler-list/"+reqUpdateDto.getVehicleType();
			}
			
		}
		
		return "vehicleEntry/updateVehicleUsingFetch";
		
	}
	
}
