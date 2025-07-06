package com.rt.vehicleEntryServiceImplimentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rt.vehicleEntryDTO.add.ReqAddVehicleDto;
import com.rt.vehicleEntryDTO.add.RespAddVehicleDto;
import com.rt.vehicleEntryDTO.select.RespFetchVehicleInfo;
import com.rt.vehicleEntryServiceInterface.VehicleEntryInterface;

@Service
public class VehicleEntryServiceImp implements VehicleEntryInterface{
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public RespAddVehicleDto addVehicleInfo(ReqAddVehicleDto reqAddVehicleDto) {
		String url="http://localhost:8181/entry/addVehicle";	
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    
		  HttpEntity<ReqAddVehicleDto> request=new HttpEntity<>(reqAddVehicleDto,headers);
		  
		    RespAddVehicleDto respAddVehicleDto=restTemplate.postForObject(url, request, RespAddVehicleDto.class);
			return respAddVehicleDto;
	}
	
	@Override
	public RespFetchVehicleInfo fetchVehicleData(int id) {
		String url="http://localhost:8181/entry/fetchVehicleInfo?id=" + id;
		
		RespFetchVehicleInfo respUpdate=restTemplate.getForObject(url,RespFetchVehicleInfo.class);
		return respUpdate;
	}
}
