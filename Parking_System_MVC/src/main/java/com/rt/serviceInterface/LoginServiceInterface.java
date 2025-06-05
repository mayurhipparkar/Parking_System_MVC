package com.rt.serviceInterface;

import org.springframework.stereotype.Service;

import com.rt.DTO.RequestLoginDTO;
import com.rt.DTO.RequestSignUpDTO;
import com.rt.DTO.ResponseLoginDTO;

@Service
public interface LoginServiceInterface {

	ResponseLoginDTO loginUser(RequestLoginDTO signUpDto);

}
