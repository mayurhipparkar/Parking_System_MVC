package com.rt.vehicleEntryController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rt.vehicleEntryDTO.select.RespEnteredVehicleListDTO;
import com.rt.vehicleEntryServiceInterface.EnteredVehicleListInterface;

@RequestMapping("/list")
@Controller
public class EnteredVehicleList {
	
	@Autowired
	private EnteredVehicleListInterface enteredVehicleListInterface;
	
	//it showing only two wheeler list with pagination.
	@GetMapping("/twoWheeler-list/{vehicleType}")
    public String twoWheelerList(@PathVariable String vehicleType,
                                       @RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "5") int size,
                                       Model model) {
	 
	 Map<String, Object> response =enteredVehicleListInterface.getVehicleListByType(page,size,vehicleType);
	 ObjectMapper mapper = new ObjectMapper();
     mapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule()); // for LocalDate/Time

     // Convert the raw list of LinkedHashMap to DTO list
     List<RespEnteredVehicleListDTO> vehicleList = ((List<?>) response.get("data")).stream()
             .map(item -> mapper.convertValue(item, RespEnteredVehicleListDTO.class))
             .toList();
     
     if(vehicleList!=null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");

	        // Add formatted time for each DTO
	        for (RespEnteredVehicleListDTO dto : vehicleList) {
	            if (dto.getEntry_time() != null) {
	                dto.setFormatted_entry_time(dto.getEntry_time().format(formatter));
	            }
	        }
     
     model.addAttribute("vehicleList", vehicleList);
     model.addAttribute("currentPage", response.get("currentPage"));
     model.addAttribute("totalPages", response.get("totalPages"));
     model.addAttribute("totalItems", response.get("totalItems"));    
     model.addAttribute("type",vehicleType);       
     model.addAttribute("today",LocalDate.now());       
 }
     return "vehicleEntry/twoWheelerList";	
}

	//it showing only four wheeler list with pagination.
	@GetMapping("/fourWheeler-list/{vehicleType}")
	    public String fourWheelerList(@PathVariable String vehicleType,
	                                       @RequestParam(defaultValue = "0") int page,
	                                       @RequestParam(defaultValue = "5") int size,
	                                       Model model) {
		 
		 Map<String, Object> response =enteredVehicleListInterface.getVehicleListByType(page,size,vehicleType);
		 ObjectMapper mapper = new ObjectMapper();
         mapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule()); // for LocalDate/Time

         // Convert the raw list of LinkedHashMap to DTO list
         List<RespEnteredVehicleListDTO> vehicleList = ((List<?>) response.get("data")).stream()
                 .map(item -> mapper.convertValue(item, RespEnteredVehicleListDTO.class))
                 .toList();
         
         if(vehicleList!=null) {
 			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
 
 	        // Add formatted time for each DTO
 	        for (RespEnteredVehicleListDTO dto : vehicleList) {
 	            if (dto.getEntry_time() != null) {
 	                dto.setFormatted_entry_time(dto.getEntry_time().format(formatter));
 	            }
 	        }
         
         model.addAttribute("vehicleList", vehicleList);
         model.addAttribute("currentPage", response.get("currentPage"));
         model.addAttribute("totalPages", response.get("totalPages"));
         model.addAttribute("totalItems", response.get("totalItems"));    
         model.addAttribute("type",vehicleType);       
         model.addAttribute("today",LocalDate.now());       
	 }
         return "vehicleEntry/fourWheelerList";	
	}
}
	

