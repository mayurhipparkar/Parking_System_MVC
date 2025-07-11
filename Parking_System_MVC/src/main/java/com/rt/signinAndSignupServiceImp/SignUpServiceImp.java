package com.rt.signinAndSignupServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rt.signinAndSignupServiceInterface.SignUpServiceInterface;
import com.rt.signupAndSignInDTO.RequestSignUpDTO;

@Service
public class SignUpServiceImp implements SignUpServiceInterface {
	@Autowired 
	private RestTemplate restTemplate;

	//here RestTemplate used to connect the two different project and transfer the data to rest Api.
	@Override
	public String registerUser(RequestSignUpDTO signUpDto) {
		String url="http://localhost:8181/users/register";
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    
	    HttpEntity<RequestSignUpDTO> request = new HttpEntity<>(signUpDto, headers);
	    String userStatus=restTemplate.postForObject(url, request, String.class);
		
		return userStatus; 
	}

	

	

}
