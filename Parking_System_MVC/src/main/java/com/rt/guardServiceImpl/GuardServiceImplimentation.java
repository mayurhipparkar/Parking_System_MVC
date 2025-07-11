package com.rt.guardServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rt.guardDTO.AddGuardReqDTO;
import com.rt.guardServiceInterface.GuardServiceInterface;

@Service
public class GuardServiceImplimentation implements GuardServiceInterface{
@Autowired
private RestTemplate restTemplate;
	@Override
	public String addGuard(AddGuardReqDTO addGuardReqDTO) {
		
		String url="http://localhost:8181/guard/add";
		HttpHeaders header=new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<AddGuardReqDTO> request=new HttpEntity<AddGuardReqDTO>(addGuardReqDTO,header);
		
		return restTemplate.postForObject(url, request, String.class);
	
	}

}
