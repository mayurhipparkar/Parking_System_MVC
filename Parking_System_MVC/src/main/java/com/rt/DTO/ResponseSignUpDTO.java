package com.rt.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseSignUpDTO {
	
	private int id;
	
	private String fullname;
	
	private String email;
		  
	private String number;
		  
	private String address;
		  
	private String password;
		  	
	private String role;

}
