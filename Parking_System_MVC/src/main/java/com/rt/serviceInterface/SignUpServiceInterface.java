package com.rt.serviceInterface;

import org.springframework.stereotype.Service;

import com.rt.DTO.RequestSignUpDTO;
import com.rt.DTO.ResponseSignUpDTO;

@Service
public interface SignUpServiceInterface {

	
	 boolean registerUser(RequestSignUpDTO reqDto);

}
