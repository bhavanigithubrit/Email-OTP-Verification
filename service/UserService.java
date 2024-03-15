package com.codewithspring.email_otp_verification.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithspring.email_otp_verification.entity.User;
import com.codewithspring.email_otp_verification.entity.repository.UserRepo;
import com.codewithspring.email_otp_verification.payload.RequestDto;
import com.codewithspring.email_otp_verification.payload.ResponseDto;

@Service
public class UserService {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	EmailService emailService;
	
	public ResponseDto registerUser(RequestDto request) {
		ResponseDto res = new ResponseDto();
		User existingUser = this.userRepo.findByEmail(request.getEmail());
		if(existingUser != null) {
			res.setMessage("User Already registered.");
		} else {
			Random r = new Random();
			String otp = String.format("@06d", r.nextInt(100000));
			User newUser = new User();
			newUser.setUsername(request.getUsernamr());
			newUser.setEmail(request.getEmail());
			newUser.setOtp(otp);
			newUser.setVerified(false);
			
			User savedUser = this.userRepo.save(newUser);
//			Email send 
			
		}
		    return res;
	}

}
