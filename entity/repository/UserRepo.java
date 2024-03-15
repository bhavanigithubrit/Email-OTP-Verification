package com.codewithspring.email_otp_verification.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithspring.email_otp_verification.entity.User;

public interface UserRepo extends JpaRepository<User, Long>{

	User findByEmail(String email);

//	User findByEmail(String email);
	

}
