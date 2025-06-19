package com.rt.signinAndSignupServiceInterface;

import org.springframework.stereotype.Service;

import com.rt.signupAndSignInDTO.RequestSignUpDTO;


@Service
public interface SignUpServiceInterface {

	
	 boolean registerUser(RequestSignUpDTO reqDto);

}
