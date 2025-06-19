package com.rt.vehicleEntryServiceImp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rt.vehicleEntryDTO.RespEnteredVehicleListDTO;
import com.rt.vehicleEntryServiceInterface.EnteredVehicleListInterface;

@Service
public class EnteredVehicleListImp implements EnteredVehicleListInterface{

	@Autowired
	private RestTemplate restTemplate;
	@Override
	public List<RespEnteredVehicleListDTO>  twoWheelerList() {
		String URL="http://localhost:8181/list/vehicleList";
	
	        HttpHeaders headers = new HttpHeaders();
	        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

	        // Wrap headers in HttpEntity (no body for GET)
	        HttpEntity<String> request = new HttpEntity<>(headers);
	        
	        RespEnteredVehicleListDTO[] response=restTemplate.getForObject(URL,RespEnteredVehicleListDTO[].class);
	        
	        return response != null ? new ArrayList<>(Arrays.asList(response)) : new ArrayList<>();
	
		
	}

	@Override
	public List<RespEnteredVehicleListDTO> fourWheelerList() {
		return null;
		
		
	}

}
