package com.rt.vehicleEntryServiceImplimentation;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rt.vehicleEntryServiceInterface.EnteredVehicleListInterface;

@Service
public class EnteredVehicleListImp implements EnteredVehicleListInterface{

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Map<String, Object> getVehicleListByType(int page, int size, String vehicleType) {
		String URL="http://localhost:8181/list/type?vehicleType="+vehicleType + "&page=" + page + "&size=" + size;
		 ResponseEntity<Map> response = restTemplate.getForEntity(URL, Map.class);
	            Map<String, Object> result = response.getBody();
	        
		return result;
	}

	
}
